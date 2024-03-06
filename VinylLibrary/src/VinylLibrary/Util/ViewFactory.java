package VinylLibrary.Util;

import VinylLibrary.View.VinylLibraryView;
import VinylLibrary.ViewModel.VinylListViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory
{
  private ViewModelFactory viewModelFactory;
  private VinylLibraryView vinylLibraryView;
  private Stage stage;
  private FXMLLoader fxmlLoader;

  public ViewFactory(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;

  }

  public VinylLibraryView getVinylLibraryView() throws IOException
  {
    if (vinylLibraryView == null)
    {
      fxmlLoader = new FXMLLoader(getClass().getResource("/VinylLibrary/View/VinylLibrary.fxml"));
      fxmlLoader.setControllerFactory(controllerClass -> new VinylLibraryView(viewModelFactory.getVinylListViewModel()));

      stage = new Stage();
      Scene vinylLibraryScene = new Scene(fxmlLoader.load());
      stage.setTitle("View Vinyl");
      stage.setScene(vinylLibraryScene);
      stage.show();
      vinylLibraryView = fxmlLoader.getController();
    }
    return vinylLibraryView;
  }



}
