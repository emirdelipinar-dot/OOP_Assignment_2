public class Rectangle extends Shape {
    private double width;
    private double length;

    /* Constructor with validation to ensure it is not a square */
    public Rectangle(Coordinates coord, double width, double length) throws Exception {
        super(4, coord);
        if (width == length) {
            throw new Exception("Geometrical Error: Width and length cannot be equal. For equal sides, please create a Square.");
        }
        if (width <= 0 || length <= 0) {
            throw new Exception("Geometrical Error: Dimensions must be positive values.");
        }
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.width *= factor;
            this.length *= factor;
        } else {
            if (factor != 0) {
                this.width /= factor;
                this.length /= factor;
            }
        }
    }

    @Override
    public String display() {
        return "Rectangle [Width: " + width + ", Length: " + length + ", Position: " + position.display() + "]";
    }
}