package lesson6hw;

public class Rectangle {

    private Point pointA;
    private Point pointB;

    public Rectangle(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public double calculateDiagonal() {
        return pointA.getDistanceBetweenPoints(pointB);
    }

    public double calculateRectangleArea() {
        return getRectangleHeight() * getRectangleWidth();
    }

    public double getRectangleWidth() {
        return Point.getDistanceBetweenAxisCoordinates(pointA.getX(), pointB.getX());
    }

    public double getRectangleHeight() {
        return Point.getDistanceBetweenAxisCoordinates(pointA.getY(), pointB.getY());
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }
}
