package VinylLibrary.Application;

import VinylLibrary.Model.Model;
import VinylLibrary.Model.Vinyl;
import VinylLibrary.View.VinylLibraryView;
import VinylLibrary.ViewModel.VinylListViewModel;
import javafx.application.Platform;

import java.util.Random;

public class UserSimulator implements Runnable
{
  private Model model;
  private VinylLibraryView vinylLibraryView;
  private Vinyl selectedVinyl;
  private int userID;

  public UserSimulator(VinylLibraryView vinylLibraryView, Model model, int userID)
  {
    this.userID = userID;
    this.vinylLibraryView = vinylLibraryView;
    this.model = model;
    selectedVinyl = vinylLibraryView.getRandomVinyl();
    model.setUserID(userID, selectedVinyl);
  }

  @Override public void run()
  {
    Random random = new Random();

    while (true)
    {
      try
      {
        Thread.sleep((random.nextInt(6) + 5) * 1000);

        int action = random.nextInt(4);

        performAction(action);

      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  private void performAction(int action)
  {
    Platform.runLater(() -> {
    switch (action)
    {
      case 0:
        selectedVinyl = vinylLibraryView.getRandomVinyl();
        model.setUserID(userID, selectedVinyl);
        model.onButtonBorrowPressed(selectedVinyl);
        break;
      case 1:
        selectedVinyl = vinylLibraryView.getRandomVinyl();
        model.setUserID(userID, selectedVinyl);
        model.onButtonReturnPressed(selectedVinyl);
        break;
      case 2:
        selectedVinyl = vinylLibraryView.getRandomVinyl();
        model.setUserID(userID, selectedVinyl);
        model.onButtonReservePressed(selectedVinyl);
        break;
      case 3:
        selectedVinyl = vinylLibraryView.getRandomVinyl();
        model.setUserID(userID, selectedVinyl);
        model.onButtonUnReservePressed(selectedVinyl);
        break;
      default:
        selectedVinyl = vinylLibraryView.getRandomVinyl();
        System.out.println("Unable to comply any buttonActions");
        break;
    }});
  }
}