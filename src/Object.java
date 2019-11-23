public class Object {
    private Coordinate coordinate;
    private double distance;
    private double bearing;

    public Object(Coordinate coordinate, double distance, double bearing){
        this.coordinate = coordinate;
        this.distance = distance;
        this.bearing = bearing;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getBearing() {
        return bearing;
    }

    public void setBearing(double bearing) {
        this.bearing = bearing;
    }
}
