package lesson7hw;

public abstract class Figure {

    public abstract double calculatePerimeter();
    public abstract double calculateArea();

    public boolean isEqualArea(Figure figure){
        return calculateArea() == figure.calculateArea();
    }

    public boolean isEqualPerimeter(Figure figure){
        return calculatePerimeter() == figure.calculatePerimeter();
    }

    public static double roundToHundredth(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}
