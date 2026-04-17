public class Square extends Shape {
    private double side;

    public Square(Coordinates coord, double side) {
        super(4, coord);
        this.side = side;
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
