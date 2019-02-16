package lesson7hw;

public class Rectangle extends Parallelogram {


    public Rectangle(Point pointA, Point pointC) {
        super(pointA, new Point(pointA.getX(), pointC.getY()), pointC);
    }

    public double calculateArea() {
        return getHeight() * getWidth();
    }

    public double getWidth() {
        return getPointA().getDistance(getPointB());
    }

    public double getHeight() {
        return getPointA().getDistance(getPointD());
    }

    @Override
    public String displayFullInfo() {
        return super.displayFullInfo() +
                "\n\t\tHeight = " + roundToHundredth(getHeight()) +
                "\n\t\tWidth = " + roundToHundredth(getWidth());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
