package VinylLibrary.Util;

import VinylLibrary.ViewModel.VinylListViewModel;

public class ViewModelFactory
{
private VinylListViewModel vinylListViewModel;
private ModelFactory modelFactory;

public ViewModelFactory(ModelFactory modelFactory)
{
  this.modelFactory = modelFactory;
}

public VinylListViewModel getVinylListViewModel()
{
  if(vinylListViewModel == null)
  {
    vinylListViewModel = new VinylListViewModel(modelFactory.getModel());
  }
  return vinylListViewModel;
}

}
