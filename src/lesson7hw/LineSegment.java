package lesson7hw;

public class LineSegment extends Figure {

    private Point point1;
    private Point point2;

    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public static double calculateSumLengthOfSegments(LineSegment... sides) {
        double length = 0;
        for (LineSegment side : sides) {
            length += side.getLength();
        }
        return length;
    }

    public double getLength() {
        return point1.getDistance(point2);
    }

    public boolean isEqualLength(LineSegment lineSegment) {
        return getLength() == lineSegment.getLength();
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
        return getClass().getSimpleName() + " ::" +
                "\n\tPoint 1 = " + point1 +
                "\n\tPoint 2 = " + point2 +
                "\n\t:: Length = " + getLength();
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
}
