package VinylLibrary.Model.States;

import VinylLibrary.Model.Vinyl;
import VinylLibrary.Model.VinylState;

public class BorrowedState implements VinylState
{

  @Override public void reserveVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl has been reserved");
    vinyl.setReservedVinyl();
  }

  @Override public void unReserveVinyl(Vinyl vinyl)
  {
    System.out.println("Cannot unreserve an un-reserved vinyl.");
  }

  @Override public void borrowVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl is already borrowed. Find another one, please.");
  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
    System.out.println(
        "Vinyl has been returned. Thank you for taking good care of it.");
    vinyl.setCurrentState(new AvailableState());
  }

  @Override public void removeVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl cannot be rerminated, as it is borrowed.");
  }
}
