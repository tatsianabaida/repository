package lesson7hw;

public class Quadrangle extends Figure implements QuadrangleDiagonal, DisplayInfo {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Quadrangle(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    @Override
    public double calculatePerimeter() {
        return LineSegment.calculateSumLengthOfSegments(new LineSegment(this.pointA, this.pointB),
                new LineSegment(this.pointB, this.pointC), new LineSegment(this.pointC, this.pointD),
                new LineSegment(this.pointD, this.pointA));
    }

    @Override
    public double calculateArea() {
        Triangle triangleABC = new Triangle(this.pointA, this.pointB, this.pointC);
        Triangle triangleACD = new Triangle(this.pointA, this.pointC, this.pointD);
        return triangleABC.calculateArea() + triangleACD.calculateArea();
    }

    @Override
    public double getFirstDiagonal() {
        return pointA.getDistance(pointC);
    }

    @Override
    public double getSecondDiagonal() {
        return pointB.getDistance(pointD);
    }

    @Override
    public String displayFullInfo() {
        String generalInfo = toString()
                + "\n\t:: Perimeter :: " + roundToHundredth(calculatePerimeter())
                + "\n\t:: Area :: " + roundToHundredth(calculateArea());
        String diagonalInfo = roundToHundredth(getFirstDiagonal()) != roundToHundredth(getSecondDiagonal())
                ? "\n\t\tFirst diagonal = " + roundToHundredth(getFirstDiagonal())
                + "\n\t\tSecond diagonal = " + roundToHundredth(getSecondDiagonal())
                : "\n\t\tDiagonal = " + roundToHundredth(getFirstDiagonal());
        return generalInfo + diagonalInfo;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " ::"
                + "\n\tPoint A = " + pointA
                + "\n\tPoint B = " + pointB
                + "\n\tPoint C = " + pointC
                + "\n\tPoint D = " + pointD;
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

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

}
