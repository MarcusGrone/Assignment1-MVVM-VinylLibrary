package VinylLibrary.View;

import VinylLibrary.Model.Vinyl;
import VinylLibrary.Model.VinylState;
import VinylLibrary.ViewModel.VinylListViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class VinylLibraryView
{

  @FXML TableView<Vinyl> vinylListView;
  @FXML TextField userIDField;
  @FXML TableColumn<Vinyl, String> userID;
  @FXML TableColumn<Vinyl, String> Title;
  @FXML TableColumn<Vinyl, String> Artist;
  @FXML TableColumn<Vinyl, String> Release_year;
  @FXML TableColumn<Vinyl, String> VinylState;
  @FXML TableColumn<Vinyl, String> Reserved;
  @FXML TableColumn<Vinyl, String> Removed;
  private Vinyl selectedVinyl;
  private int currentUserID;

  private final VinylListViewModel vinylListViewModel;

  public VinylLibraryView(VinylListViewModel createVinylListViewModel)
  {
    this.vinylListViewModel = createVinylListViewModel;
  }

  public void initialize()
  {
    userID.setCellValueFactory(
        new PropertyValueFactory<Vinyl, String>("userID"));
    Title.setCellValueFactory(new PropertyValueFactory<Vinyl, String>("title"));
    Artist.setCellValueFactory(
        new PropertyValueFactory<Vinyl, String>("artist"));

    Release_year.setCellValueFactory(
        new PropertyValueFactory<Vinyl, String>("releaseYear"));

    VinylState.setCellValueFactory(
        new PropertyValueFactory<Vinyl, String>("currentState"));
    Reserved.setCellValueFactory(
        new PropertyValueFactory<Vinyl, String>("userID"));
    Removed.setCellValueFactory(
        new PropertyValueFactory<Vinyl, String>("userID"));
    vinylListView.setOnMouseClicked((MouseEvent event) -> {
      if (event.getButton().equals(MouseButton.PRIMARY))
      {
        selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
      }
    });
    vinylListView.setItems(vinylListViewModel.getVinyls());
    vinylListViewModel.addVinyl();
  }

  public Vinyl getRandomVinyl()
  {
    int size = vinylListViewModel.getVinyls().size();
    Random random = new Random();
    int randomNumber = random.nextInt(size);

    for (int i = 0; i < size; i++)
    {
      if (i == randomNumber)
      {
        return vinylListViewModel.getVinyls().get(i);
      }
    }
    return null;
  }

  @FXML public void onButtonBorrowPressed()
  {
    if (currentUserID == 0)
    {
      System.out.println("Please set a userID before borrowing a vinyl.");
      return;
    }
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.borrowPressed(selectedVinyl);
  }

  @FXML public void onButtonReturnPressed()
  {
    if (currentUserID == 0)
    {
      System.out.println("Please set a userID before borrowing a vinyl.");
      return;
    }
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.returnPressed(selectedVinyl);
  }

  @FXML public void onButtonReservePressed()
  {
    if (currentUserID == 0)
    {
      System.out.println("Please set a userID before borrowing a vinyl.");
      return;
    }
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.reservePressed(selectedVinyl);
  }

  @FXML public void onButtonUnReservePressed()
  {
    if (currentUserID == 0)
    {
      System.out.println("Please set a userID before borrowing a vinyl.");
      return;
    }
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.unReservePressed(selectedVinyl);
  }

  @FXML public void onButtonRemovePressed()
  {
    if (currentUserID == 0)
    {
      System.out.println("Please set a userID before borrowing a vinyl.");
      return;
    }
    Vinyl selectedVinyl = vinylListView.getSelectionModel().getSelectedItem();
    vinylListViewModel.removePressed(selectedVinyl);
  }

  @FXML public void onButtonSetIDPressed()
  {
    try
    {
      currentUserID = Integer.parseInt(userIDField.getText());
    }
    catch (NumberFormatException e)
    {
      System.out.println("Invalid user ID format.");
      return;
    }

    vinylListViewModel.setUserID(currentUserID, selectedVinyl);
  }
}
