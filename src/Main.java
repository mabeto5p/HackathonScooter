import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileLoader fileLoader = new FileLoader();
        fileLoader.addObserver(new GUI());
        //    System.out.println(Haversine.distance(56.17203083, 10.18773750, 56.17206200, 10.18766933)*1000);
      //  Coordinate coordinate = Haversine.inverseHaversine(new Coordinate(56.17203083, 10.18773750 ), 90.00000, 0.000000);
        //System.out.println(Haversine.distance(coordinate.getLatitude(), coordinate.getLongitude(), 56.17206200, 10.18766933)*1000);
       // fileLoader.continuousReading();
       // List<Coordinate> coordinates = fileLoader.getCoordinatesLoadedCoordinates();
       // System.out.println(coordinates.get(0).getLatitude()+", " + coordinates.get(0).getLongitude());
        Square square =  new Square(fileLoader.getSquareCoordinatesLoadedCoordinates());


    }
}
