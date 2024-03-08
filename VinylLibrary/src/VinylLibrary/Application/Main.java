package VinylLibrary.Application;

import VinylLibrary.Util.ModelFactory;
import VinylLibrary.Util.ViewFactory;
import VinylLibrary.Util.ViewModelFactory;
import VinylLibrary.View.VinylLibraryView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
  public static void main(String[] args)
  {
    launch();
  }

  @Override public void start(Stage primaryStage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewFactory viewFactory = new ViewFactory(viewModelFactory);

    viewFactory.getVinylLibraryView();


    UserSimulator user1 = new UserSimulator(viewFactory.getVinylLibraryView(), modelFactory.getModel(),1);
    UserSimulator user2 = new UserSimulator(viewFactory.getVinylLibraryView(), modelFactory.getModel(),2);
    UserSimulator user3 = new UserSimulator(viewFactory.getVinylLibraryView(), modelFactory.getModel(),3);
    UserSimulator user4 = new UserSimulator(viewFactory.getVinylLibraryView(), modelFactory.getModel(),4);
    UserSimulator user5 = new UserSimulator(viewFactory.getVinylLibraryView(), modelFactory.getModel(),5);

    Thread userIdThread1 = new Thread(user1);
    Thread userIdThread2 = new Thread(user2);
    Thread userIdThread3 = new Thread(user3);
    Thread userIdThread4 = new Thread(user4);
    Thread userIdThread5 = new Thread(user5);

    userIdThread1.setDaemon(true);
    userIdThread1.start();
    userIdThread2.setDaemon(true);
    userIdThread2.start();
    userIdThread3.setDaemon(true);
    userIdThread3.start();
    userIdThread4.setDaemon(true);
    userIdThread4.start();
    userIdThread5.setDaemon(true);
    userIdThread5.start();

  }
}
