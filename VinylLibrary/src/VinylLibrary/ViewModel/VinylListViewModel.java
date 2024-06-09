package VinylLibrary.ViewModel;

import VinylLibrary.Model.Model;
import VinylLibrary.Model.Vinyl;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class VinylListViewModel implements PropertyChangeListener
{
  private final Model model;
  private final ObservableList<Vinyl> vinyls;
  private final StringProperty userID;
  private final StringProperty title;
  private final StringProperty artist;
  private final StringProperty releaseYear;
  private final StringProperty vinylState;
  private final StringProperty reserved;
  private final StringProperty removed;


  public VinylListViewModel(Model model) {
    userID = new SimpleStringProperty();
    title = new SimpleStringProperty();
    artist = new SimpleStringProperty();
    releaseYear = new SimpleStringProperty();
    vinylState = new SimpleStringProperty();
    reserved = new SimpleStringProperty();
    removed = new SimpleStringProperty();
    this.model = model;
    vinyls = FXCollections.observableArrayList();
    model.addPropertyChangeListener("VinylAdded", this);
    model.addPropertyChangeListener("VinylListUpdated", this);
    refresh();
  }

  public void setUserID(int userID, Vinyl selectedVinyl) {
    model.setUserID(userID, selectedVinyl);
  }

  public void addVinyl() {
    if (releaseYear.get() != null && !releaseYear.get().isEmpty()) {
      model.addVinyl(title.get(), artist.get(), Integer.parseInt(releaseYear.get()));
      refresh();
    } else {
      System.out.println("Vinyl's has been added");
    }
  }

  public void borrowPressed(Vinyl selectedVinyl) {
    model.onButtonBorrowPressed(selectedVinyl);
  }

  public void returnPressed(Vinyl selectedVinyl) {
    model.onButtonReturnPressed(selectedVinyl);
  }

  public void reservePressed(Vinyl selectedVinyl) {
    model.onButtonReservePressed(selectedVinyl);
  }

  public void unReservePressed(Vinyl selectedVinyl) {
    model.onButtonUnReservePressed(selectedVinyl);
  }

  public void removePressed(Vinyl selectedVinyl) {
    model.onButtonRemovePressed(selectedVinyl);
  }

  public ObservableList<Vinyl> getVinyls() {
    return vinyls;
  }

  public void refresh() {
    vinyls.clear();
    vinyls.addAll(model.getVinyls());
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    switch (evt.getPropertyName()) {
      case "VinylAdded":
      case "VinylListUpdated":
        updateVinylList((List<Vinyl>) evt.getNewValue());
        break;
    }
  }

  private void updateVinylList(List<Vinyl> newVinyls) {
    vinyls.clear();
    vinyls.addAll(newVinyls);
  }
}
