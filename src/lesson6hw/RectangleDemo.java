package lesson6hw;


public class RectangleDemo {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(new Point(-6.7654, 8.4563), new Point(-2.948, -8.648));
        Rectangle rectangle2 = new Rectangle(new Point(0, 10), new Point(-6, 2));

        System.out.println(":: First rectangle ::");
        soutRectangleInfo(rectangle1);
        System.out.println(":: Second rectangle ::");
        soutRectangleInfo(rectangle2);
        rectangle2.getPointA().setX(6);
        rectangle2.getPointB().setY(4);
        System.out.println(":: Second with corrected points' coordinates ::");
        soutRectangleInfo(rectangle2);
        rectangle2.setPointA(new Point(3, 0));
        rectangle2.setPointB(new Point(0, 4));
        System.out.println(":: Second with new points ::");
        soutRectangleInfo(rectangle2);
    }

    private static void soutRectangleInfo(Rectangle rectangle) {
        System.out.println("Rectangle diagonal: " + roundToHundredth(rectangle.calculateDiagonal())
                + "\nRectangle area: " + roundToHundredth(rectangle.calculateRectangleArea())
                + "\n\tFirst side: " + roundToHundredth(rectangle.getRectangleHeight())
                + "\n\tSecond side: " + roundToHundredth(rectangle.getRectangleWidth()) + "\n");
    }

    private static double roundToHundredth(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}
