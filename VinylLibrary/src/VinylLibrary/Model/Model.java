package VinylLibrary.Model;

import VinylLibrary.Util.PropertyChangeSubject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model implements PropertyChangeSubject, Runnable
{
  private PropertyChangeSupport support;
  private List<Vinyl> vinylList;
  private Vinyl vinyl;

  public Model()
  {
    vinylList = new ArrayList<>();
    support = new PropertyChangeSupport(this);

    Random random = new Random();

    for (int i = 0; i < 25; i++)
    {
      String title = "Viny l" + (i + 1);
      String artist = "Artist " + (i + 1);
      int releaseYear = random.nextInt(134) + 1890;

      vinylList.add(new Vinyl(title, artist, releaseYear));
    }
  }


  public void addVinyl(String title, String artist, int releaseYear)
  {
    vinylList.add(new Vinyl(title, artist, releaseYear));
    support.firePropertyChange("VinylAdded", null, vinylList);
    System.out.println(
        "Vinyl has been added: " + title + ", " + artist + ", " + releaseYear);
  }

  public List<Vinyl> getVinyls()
  {
    return new ArrayList<>(vinylList);
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  public void setUserID(int userID) {
    for (Vinyl vinyl : vinylList) {
      vinyl.setUserID(userID);
    }
    support.firePropertyChange("UserIDSet", null, userID);
    System.out.println("UserID has been set: " + userID);
  }


  public void onButtonBorrowPressed()
  {
    vinyl.borrowVinyl();
  }


  public void onButtonReturnPressed()
  {vinyl.returnVinyl();
  }


  public void onButtonReservePressed()
  {
    vinyl.reserveVinyl();
  }


  public void onButtonUnReservePressed()
  {
    vinyl.unReserveVinyl();
  }


  public void onButtonRemovePressed()
  {
    vinyl.removeVinyl();
  }


  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
    listener.propertyChange(
        new PropertyChangeEvent(this, null, null, vinylList));
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
    listener.propertyChange(
        new PropertyChangeEvent(this, name, null, vinylList));
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }


}
