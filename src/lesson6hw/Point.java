package lesson6hw;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double getDistanceBetweenAxisCoordinates(double coordinate1, double coordinate2) {
        return Math.abs(coordinate1 - coordinate2);
    }

    public double getDistanceBetweenPoints(Point point) {
        double distanceBetweenX = getDistanceBetweenAxisCoordinates(x, point.getX());
        double distanceBetweenY = getDistanceBetweenAxisCoordinates(y, point.getY());
        return Math.sqrt(distanceBetweenX * distanceBetweenX + distanceBetweenY * distanceBetweenY);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
