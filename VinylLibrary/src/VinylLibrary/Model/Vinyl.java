package VinylLibrary.Model;

import VinylLibrary.Model.States.AvailableState;
import VinylLibrary.Model.States.BorrowedState;

public class Vinyl
{
  private int userID;
  private VinylState currentState;
  private String title;
  private String artist;
  private int releaseYear;
  private boolean reservedVinyl;
  

  public Vinyl(String title, String artist, int releaseYear)
  {
    this.title = title;
    this.artist = artist;
    this.releaseYear = releaseYear;
    currentState = new AvailableState();
    reservedVinyl = false;
  }

  public void setUserID(int userID)
  {
    this.userID = userID;
  }

  public int getUserID()
  {
    return userID;
  }

  public String getTitle()
  {
    return title;
  }

  public String getArtist()
  {
    return artist;
  }

  public String getReleaseYear()
  {
    return String.valueOf(releaseYear);
  }

  public void reserveVinyl()
  {
    if (!reservedVinyl)
    {
      currentState.reserveVinyl(this);
      reservedVinyl = true;
    }
    else
      System.out.println(
          "Vinyl is alrady reserved. Please wait or find another vinyl in the meanwhile.");
  }

  public void unReserveVinyl()
  {
    currentState.unReserveVinyl(this);
    reservedVinyl = false;
  }

  public void borrowVinyl()
  {
    if (currentState instanceof BorrowedState)
    {
      System.out.println("Vinyl is already borrowed.");
    }
    else if (!reservedVinyl)
    {
      currentState.borrowVinyl(this);
    }
    else
      System.out.println("Cannot borrow, as vinyl has been reserved.");
  }

  public void returnVinyl()
  {
    currentState.returnVinyl(this);
  }

  public void removeVinyl()
  {
    currentState.removeVinyl(this);
  }

  public VinylState getCurrentState()
  {
    return currentState;
  }

  public void setCurrentState(VinylState state)
  {
    this.currentState = state;
  }

  public boolean isReservedVinyl()
  {
    return reservedVinyl;
  }

  public void setReservedVinyl()
  {
    if (!reservedVinyl)
    {
      this.reservedVinyl = reservedVinyl;
    }
    System.out.println("Vinyl is already reserved");
  }

}
