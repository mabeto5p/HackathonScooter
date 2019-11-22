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
        boolean isCoordinateInXInterval = coordinate.getxCoordinate() < getMax().getxCoordinate() && coordinate.getxCoordinate() > getMin().getxCoordinate();
        boolean isCoordinateInYInterval = coordinate.getyCoordinate() < getMax().getyCoordinate() && coordinate.getyCoordinate() > getMin().getyCoordinate();
        return isCoordinateInXInterval && isCoordinateInYInterval;
    }

    public void createSquare() {
        float xMin = coordinates.get(0).getxCoordinate();
        float xMax = coordinates.get(0).getxCoordinate();
        float yMin = coordinates.get(0).getyCoordinate();
        float yMax = coordinates.get(0).getyCoordinate();
        for (Coordinate coordinate : coordinates) {
            float x = coordinate.getxCoordinate();
            float y = coordinate.getyCoordinate();
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
