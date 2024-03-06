package VinylLibrary.Model.States;

import VinylLibrary.Model.Vinyl;
import VinylLibrary.Model.VinylState;

public class ReservedState implements VinylState
{

  private Thread unReserveAfterTimeThread;

  public ReservedState(Vinyl vinyl)
  {
    unReserveAfterTimeThread = new Thread(() -> {
      try
      {
        Thread.sleep(15000);
        unReserveVinyl(vinyl);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    });
    unReserveAfterTimeThread.setDaemon(true);
    unReserveAfterTimeThread.start();
    System.out.println(
        "Your vinyl has been reserved for 15 seconds. Please come back to this site to renew your reservation, if you are still interested.");
  }

  @Override public void reserveVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl is already reserved. Find another, please.");
  }

  @Override public void unReserveVinyl(Vinyl vinyl)
  {
    System.out.println(
        "Thank you for unreserving. Other people may now enjoy the vinyl.");
    vinyl.setCurrentState(new AvailableState());
    unReserveAfterTimeThread.interrupt();
  }

  @Override public void borrowVinyl(Vinyl vinyl)
  {
    System.out.println(
        "Vinyl is reserved and cannot be borrowed at this time.");
  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
    //na
  }

  @Override public void removeVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl cannot be removed, as it is reserved");
  }
}


