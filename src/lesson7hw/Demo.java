package lesson7hw;

public class Demo {

    private static class DemoQuadrangles {

        public static void main(String[] args) {
            Quadrangle quadrangle = new Quadrangle(new Point(10, 2),
                    new Point(1, -1), new Point(2, 2), new Point(15, 4));
            Parallelogram parallelogram = new Parallelogram(new Point(10, 2),
                    new Point(1, -1), new Point(2, 2));
            Rectangle square = new Square(new Point(2, 4), new Point(6, 8));
            Rectangle rectangle = new Rectangle(new Point(6, 8), new Point(3, 4));

            System.out.println(quadrangle.isEqualPerimeter(parallelogram)
                    ? "\n Provided figures have equal perimeters. \n"
                    : "\n Provided figures' perimeters are not equal.\n");
            System.out.println(quadrangle.displayFullInfo());
            System.out.println(parallelogram.displayFullInfo());
            System.out.println(ShapeUtils.isRectangle(parallelogram)
                    ? "\n Provided figure is rectangle. \n"
                    : "\n Provided figure is not rectangle.\n");
            System.out.println(ShapeUtils.isTriangle(parallelogram)
                    ? "\n Provided figure is triangle. \n"
                    : "\n Provided figure is not triangle.\n");
            System.out.println(square.displayFullInfo());
            System.out.println(rectangle.displayFullInfo());
        }
    }

    private static class DemoTriangles {

        public static void main(String[] args) {
            Triangle triangle = new Triangle(new Point(-3, 0), new Point(0, 4), new Point(3, 0));
            Triangle equalAreaTriangle = new Triangle(new Point(-3, 0), new Point(0, 4), new Point(3, 0));
            EquilateralTriangle equilateralTriangle = new EquilateralTriangle(new Point(0, 0),
                    new Point(1, (Math.sqrt(3))), new Point(2, 0));

            System.out.println(equilateralTriangle.displayFullInfo());
            System.out.println(ShapeUtils.isTriangle(equilateralTriangle)
                    ? "\n Provided figure is triangle. \n"
                    : "\n Provided figure is not triangle.\n");
            System.out.println(triangle.displayFullInfo());
            System.out.println(equalAreaTriangle.isEqualArea(triangle)
                    ? "\n Provided figures have equal areas. \n"
                    : "\n Provided figures' areas are not equal.\n");
        }
    }
}
