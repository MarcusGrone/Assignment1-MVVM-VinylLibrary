package VinylLibrary.Application;

import VinylLibrary.Model.Model;
import VinylLibrary.ViewModel.VinylListViewModel;

import java.util.Random;

public class UserSimulator implements Runnable {
  private Model model;


  @Override
  public void run() {
    Random random = new Random();

    while (true) {
      try {
        Thread.sleep((random.nextInt(6) + 5) * 1000);

        int action = random.nextInt(4);
        performAction(action);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void performAction(int action) {
    switch (action) {
      case 0:
        model.onButtonBorrowPressed();
        break;
      case 1:
        model.onButtonReturnPressed();
        break;
      case 2:
        model.onButtonReservePressed();
        break;
      case 3:
        model.onButtonUnReservePressed();
        break;
      default:
        System.out.println("Unable to comply any buttonActions");
        break;
    }
  }
}