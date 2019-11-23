import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(Haversine.distance(56.17203083, 10.18773750, 56.17206200, 10.18766933)*1000);
        Coordinate coordinate = Haversine.inverseHaversine(new Coordinate(56.17203083, 10.18773750 ), 90.00000, 0.000000);
        System.out.println(Haversine.distance(coordinate.getLatitude(), coordinate.getLongitude(), 56.17206200, 10.18766933)*1000);
        GUI gui = new GUI();
        gui.update(true);
        FileLoader fileLoader = new FileLoader();
        List<Coordinate> coordinates = fileLoader.getCoordinatesLoadedCoordinates();
        System.out.println(coordinates.get(0).getLatitude()+", " + coordinates.get(0).getLongitude());
        Square square = new Square(coordinates);
        System.out.println(square);
        System.out.println(square.isContained(new Object(new Coordinate(56.17202983, 10.18773750 ), 1, -90)));

    }
}
