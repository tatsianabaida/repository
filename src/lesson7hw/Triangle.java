package lesson7hw;

public class Triangle extends Figure implements DisplayInfo, TriangleHeight {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    @Override
    public double calculatePerimeter() {
        return LineSegment.calculateSumLengthOfSegments(new LineSegment(this.pointA, this.pointB),
                new LineSegment(this.pointB, this.pointC), new LineSegment(this.pointC, this.pointA));
    }

    @Override
    public double calculateArea() {
        LineSegment segmentAB = new LineSegment(this.pointA, this.pointB);
        LineSegment segmentBC = new LineSegment(this.pointB, this.pointC);
        LineSegment segmentCA = new LineSegment(this.pointC, this.pointA);
        double semiPerimeter = calculatePerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - segmentAB.getLength())
                * (semiPerimeter - segmentBC.getLength())
                * (semiPerimeter - segmentCA.getLength()));
    }

    @Override
    public double getFirstHeight() {
        return 2 * calculateArea() / pointA.getDistance(pointB);
    }

    @Override
    public double getSecondHeight() {
        return 2 * calculateArea() / pointB.getDistance(pointC);
    }

    @Override
    public double getThirdHeight() {
        return 2 * calculateArea() / pointC.getDistance(pointA);
    }

    @Override
    public String displayFullInfo() {
        String generalInfo = toString()
                + "\n\t:: Perimeter :: " + roundToHundredth(calculatePerimeter())
                + "\n\t:: Area :: " + roundToHundredth(calculateArea());
        String heightInfo = roundToHundredth(getFirstHeight()) == roundToHundredth(getSecondHeight())
                && roundToHundredth(getSecondHeight()) == roundToHundredth(getThirdHeight())
                ? "\n\t\tHeight = " + roundToHundredth(getFirstHeight())
                : "\n\t\tFirst height = " + roundToHundredth(getFirstHeight())
                + "\n\t\tSecond height = " + roundToHundredth(getSecondHeight())
                + "\n\t\tThird height = " + roundToHundredth(getThirdHeight());
        return generalInfo + heightInfo;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " ::"
                + "\n\tPoint A = " + pointA
                + "\n\tPoint B = " + pointB
                + "\n\tPoint C = " + pointC;
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

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }
}
