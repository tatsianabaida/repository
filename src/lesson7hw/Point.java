package lesson7hw;

public class Point extends Figure {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point point) {
        double distanceBetweenX = Math.abs(x - point.getX());
        double distanceBetweenY = Math.abs(y - point.getY());
        return Math.sqrt(distanceBetweenX * distanceBetweenX + distanceBetweenY * distanceBetweenY);
    }

    @Override
    public double calculatePerimeter() {
        return 0;
    }

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public String toString() {
        return "{" +
                "x = " + roundToHundredth(x) +
                ", y = " + roundToHundredth(y) +
                "} ";
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

