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




}
