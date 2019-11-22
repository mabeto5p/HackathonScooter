public class Haversine {
    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

    public static double distance(double startLat, double startLong,
                                  double endLat, double endLong) {

        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }

    public static Coordinate inverseHaversine(Coordinate coordinate, double bearing, double distance){
        double lat1 = Math.toRadians(coordinate.getLatitude());
        double lon1 = Math.toRadians(coordinate.getLongitude());
        double brng = Math.toRadians(bearing);
        double dist = distance/1000.0;


        double lat2 = Math.asin(Math.sin(lat1)*Math.cos(dist/EARTH_RADIUS) +
                Math.cos(lat1)*Math.sin(dist/EARTH_RADIUS)*Math.cos(brng));

        double lon2 = lon1 + Math.atan2(Math.sin(brng)*Math.sin(dist/EARTH_RADIUS)*Math.cos(lat1),
                Math.cos(dist/EARTH_RADIUS)-Math.sin(lat1)*Math.sin(lat2));

        lat2 = Math.toDegrees(lat2);
        lon2 = Math.toDegrees(lon2);

        return new Coordinate(lat2, lon2);
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
