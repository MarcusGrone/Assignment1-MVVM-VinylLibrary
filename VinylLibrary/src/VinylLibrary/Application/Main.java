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

    Thread modelThread = new Thread(modelFactory.getModel());
    modelThread.setDaemon(true);
    modelThread.start();





  }
}
