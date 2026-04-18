public class Square extends Shape {
    private double side;

    public Square(Coordinates coord, double side) {
        super(4, coord);
        this.side = side;
    }

    public static boolean isValid(double width, double length) {
        /* Ensures dimensions are positive non-zero values */
        return width > 0 && length > 0;
    }

    public static boolean isValid(double side) {
        /* Ensures the side length is a positive non-zero value */
        return side > 0;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) side *= factor;
        else side /= factor;
    }
    @Override
    public double getArea() { return side * side; }

    @Override
    public double getPerimeter() { return 4 * side; }

    @Override
    public String display() {
        return "Square [Side: " + side + ", Pos: " + position.display() +
                ", Area: " + getArea() + "]";
    }



}
