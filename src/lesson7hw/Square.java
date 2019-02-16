package lesson7hw;

public class Square extends Rectangle {

    public Square(Point pointA, Point pointC) {
        super(pointA, pointC);
    }

    @Override
    public double calculateArea() {
        return Math.pow(getHeight(), 2);
    }

    @Override
    public double calculatePerimeter() {
        return 4 * getHeight();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
