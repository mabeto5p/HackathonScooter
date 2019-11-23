import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Square {
    private Coordinate Min;
    private Coordinate Max;
    private List<Coordinate> coordinates;

    public Square(List<Coordinate> coordinates){
        this.coordinates = coordinates;
        createSquare();
    }

    public boolean isContained(Object object, Coordinate coordinate){
        Coordinate objectEnd = Haversine.inverseHaversine(coordinate, coordinate.getBearing(), object.getDistance());
        boolean isCoordinateInXInterval = objectEnd.getLatitude() <= getMax().getLatitude() && objectEnd.getLatitude() >= getMin().getLatitude();
        boolean isCoordinateInYInterval = objectEnd.getLongitude() <= getMax().getLongitude() && objectEnd.getLongitude() >= getMin().getLongitude();
        return isCoordinateInXInterval && isCoordinateInYInterval;
    }

    public void createSquare() {
        double xMin = coordinates.get(0).getLatitude();
        double xMax = coordinates.get(0).getLatitude();
        double yMin = coordinates.get(0).getLongitude();
        double yMax = coordinates.get(0).getLongitude();
        for (Coordinate coordinate : coordinates) {
            double x = coordinate.getLatitude();
            double y = coordinate.getLongitude();
            if(xMin > x){
                xMin = x;
            }
            if(xMax < x){
                xMax = x;
            }
            if(yMin > y){
                yMin = y;
            }
            if (yMax < y){
                yMax = y;
            }
        }
        setMin(new Coordinate(xMin, yMin));
        setMax(new Coordinate(xMax, yMax));
    }

    public Coordinate getMin() {
        return Min;
    }

    public void setMin(Coordinate min) {
        this.Min = min;
    }

    public Coordinate getMax() {
        return Max;
    }

    public void setMax(Coordinate max) {
        this.Max = max;
    }

    @Override
    public String toString() {
        return getMin() + " and " + getMax();
    }
}
