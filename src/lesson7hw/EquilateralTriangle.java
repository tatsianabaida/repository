package lesson7hw;

public class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(Point pointA, Point pointB, Point pointC) {
        super(pointA, pointB, pointC);
    }

    @Override
    public double calculatePerimeter() {
        return 3 * getPointA().getDistance(getPointB());
    }

    @Override
    public String displayFullInfo() {
        return super.displayFullInfo()
                + "\n\t\tMedian = " + roundToHundredth(getFirstHeight())
                + "\n\t\tBisector = " + roundToHundredth(getFirstHeight());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
