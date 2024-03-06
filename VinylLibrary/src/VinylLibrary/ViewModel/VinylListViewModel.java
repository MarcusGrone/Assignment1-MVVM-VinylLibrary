package VinylLibrary.ViewModel;

import VinylLibrary.Model.Model;
import VinylLibrary.Model.Vinyl;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class VinylListViewModel
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


  public VinylListViewModel(Model model)
  {

    userID = new SimpleStringProperty();
    title = new SimpleStringProperty();
    artist = new SimpleStringProperty();
    releaseYear = new SimpleStringProperty();
    vinylState = new SimpleStringProperty();
    reserved = new SimpleStringProperty();;
    removed = new SimpleStringProperty();;
    this.model = model;
    vinyls = FXCollections.observableArrayList();
    model.addPropertyChangeListener("VinylAdded", this::Update);
    refresh();
  }

  public void setUserID()
  {
    model.setUserID(Integer.parseInt(userID.get()));
  }

  public void addVinyl() {
    if (releaseYear.get() != null && !releaseYear.get().isEmpty()) {
      model.addVinyl(title.get(), artist.get(), Integer.parseInt(releaseYear.get()));
      refresh();
    } else {
      System.out.println("Release year has not been provided.");
    }
  }

  public StringProperty userIDProperty()
  {
    return userID;
  }

  public StringProperty titleProperty()
  {
    return title;
  }

  public StringProperty artistProperty()
  {
    return artist;
  }

  public StringProperty releaseYearProperty()
  {
    return releaseYear;
  }

  public StringProperty vinylStateProperty()
  {

    return vinylState;
  }

  public StringProperty reservedProperty()
  {
    return reserved;
  }

  public StringProperty removedProperty()
  {
    return removed;
  }


  public void borrowPressed()
  {
    model.onButtonBorrowPressed();
  }

  public void returnPressed()
  {
    model.onButtonReturnPressed();
  }

  public void reservePressed()
  {
    model.onButtonReservePressed();
  }

  public void unReservePressed()
  {
    model.onButtonUnReservePressed();
  }

  public void removePressed()
  {
    model.onButtonRemovePressed();
  }

  public ObservableList<Vinyl> getVinyls()
  {
    return vinyls;
  }

  public void refresh()
  {
    vinyls.clear();
    vinyls.addAll(model.getVinyls());
  }

  private void Update(PropertyChangeEvent propertyChangeEvent)
  {
    List<Vinyl> newVinyls = (List<Vinyl>) propertyChangeEvent.getNewValue();
    vinyls.clear();
    vinyls.addAll(newVinyls);
  }

}
