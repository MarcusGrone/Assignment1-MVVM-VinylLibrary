package VinylLibrary.Model.States;

import VinylLibrary.Model.Vinyl;
import VinylLibrary.Model.VinylState;

public class RemovedState implements VinylState
{

  @Override public void reserveVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl is unreachable at this moment, at it has been terminated from Library");
  }

  @Override public void unReserveVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl is unreachable at this moment, at it has been terminated from Library");

  }

  @Override public void borrowVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl is unreachable at this moment, at it has been terminated from Library");

  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
    System.out.println("Vinyl is unreachable at this moment, at it has been terminated from Library");

  }

  @Override public void removeVinyl(Vinyl vinyl)
  {    System.out.println("Vinyl is unreachable at this moment, at it has been terminated from Library");

  }

  @Override public String toString()
  {
    return "Removed";
  }

}
