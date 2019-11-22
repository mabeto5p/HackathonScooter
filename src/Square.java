import java.util.ArrayList;

public class Square {
    private Coordinate Min;
    private Coordinate Max;
    private ArrayList<Coordinate> coordinates;

    public Square(ArrayList<Coordinate> coordinates){
        this.coordinates = coordinates;
        createSquare();
    }

    public boolean isContained(Coordinate coordinate){
        boolean isCoordinateInXInterval = coordinate.getLatitude() < getMax().getLatitude() && coordinate.getLatitude() > getMin().getLatitude();
        boolean isCoordinateInYInterval = coordinate.getLongitude() < getMax().getLongitude() && coordinate.getLongitude() > getMin().getLongitude();
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
}
