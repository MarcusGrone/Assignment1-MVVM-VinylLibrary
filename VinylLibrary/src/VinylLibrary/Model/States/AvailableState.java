package VinylLibrary.Model.States;

import VinylLibrary.Model.Vinyl;
import VinylLibrary.Model.VinylState;

public class AvailableState implements VinylState
{

  @Override public void reserveVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl has been reserved");
  vinyl.setCurrentState(new ReservedState(vinyl));
  }

  @Override public void unReserveVinyl(Vinyl vinyl)
  {
    System.out.println("Unable to unreserve un-reserved vinyls.");
  }

  @Override public void borrowVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl has been borrowed");
    vinyl.setCurrentState(new BorrowedState());
  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl is already available");

  }

  @Override public void removeVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl has been terminated from the library.");
    vinyl.setCurrentState(new RemovedState());
  }
}
