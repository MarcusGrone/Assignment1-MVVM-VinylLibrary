package VinylLibrary.View;

import VinylLibrary.Model.Vinyl;
import VinylLibrary.Model.VinylState;
import VinylLibrary.ViewModel.VinylListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VinylLibraryView
{
  @FXML TextField userIDField;
  @FXML TableColumn<Vinyl, Integer> userID;
  @FXML TableColumn<Vinyl, String> Title;
  @FXML TableColumn<Vinyl, String> Artist;
  @FXML TableColumn<Vinyl, Integer> Release_year;
  @FXML TableColumn<Vinyl, String> VinylState;
  @FXML TableColumn<Vinyl, String> Reserved;
  @FXML TableColumn<Vinyl, String> Removed;
  @FXML TableView<Vinyl> vinylListView;

  private VinylListViewModel vinylListViewModel;

  public VinylLibraryView(VinylListViewModel createVinylListViewModel)
  {
    this.vinylListViewModel = createVinylListViewModel;
  }

  public void initialize()
  {
    userID.textProperty()
        .bindBidirectional(vinylListViewModel.userIDProperty());
    Title.textProperty().bindBidirectional(vinylListViewModel.titleProperty());
    Artist.textProperty()
        .bindBidirectional(vinylListViewModel.artistProperty());
    Release_year.textProperty()
        .bindBidirectional(vinylListViewModel.releaseYearProperty());
    VinylState.textProperty().bindBidirectional(vinylListViewModel.vinylStateProperty());
Reserved.textProperty().bindBidirectional(vinylListViewModel.reservedProperty());
Removed.textProperty().bindBidirectional(vinylListViewModel.removedProperty());
    vinylListView.setItems(vinylListViewModel.getVinyls());
    vinylListViewModel.addVinyl();
  }

  @FXML public void onButtonBorrowPressed()
  {
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.borrowPressed();
  }

  @FXML public void onButtonReturnPressed()
  {
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.returnPressed();
  }

  @FXML public void onButtonReservePressed()
  {
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.reservePressed();
  }

  @FXML public void onButtonUnReservePressed()
  {
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.unReservePressed();
  }

  @FXML public void onButtonRemovePressed()
  {
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.removePressed();
  }

  @FXML public void onButtonSetIDPressed()
  {
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.setUserID();
  }
}
