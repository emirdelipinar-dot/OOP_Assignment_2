public class Triangle extends Shape {
    private Coordinates p2;
    private Coordinates p3;

    public Triangle(Coordinates p1, Coordinates p2, Coordinates p3) {
        super(3, p1); // position p1'i temsil eder
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public void translate(int dx, int dy) {
        super.translate(dx, dy); // p1
        p2.translate(dx, dy);
        p3.translate(dx, dy);
    }

    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);
        p2.scale(factor, sign);
        p3.scale(factor, sign);
    }
}
