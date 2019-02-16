package lesson7hw;

public class Parallelogram extends Quadrangle {

    public Parallelogram(Point pointA, Point pointB, Point pointC) {
        super(pointA, pointB, pointC,
                (new Point(pointC.getX() + pointA.getX() - pointB.getX(),
                        pointC.getY() + pointA.getY() - pointB.getY())));
    }

    @Override
    public double calculatePerimeter() {
        return getPointA().getDistance(getPointB()) * 2 + getPointB().getDistance(getPointC()) * 2;
    }

    @Override
    public double calculateArea() {
        Triangle triangleABC = new Triangle(getPointA(), getPointB(), getPointC());
        return triangleABC.calculateArea() * 2;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
