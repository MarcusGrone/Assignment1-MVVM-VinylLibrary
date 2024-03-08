package VinylLibrary.Model;

public interface VinylState
{
  void reserveVinyl(Vinyl vinyl);
  void unReserveVinyl(Vinyl vinyl);
  void borrowVinyl(Vinyl vinyl);
  void returnVinyl(Vinyl vinyl);
  void removeVinyl(Vinyl vinyl);
  String toString();

}
