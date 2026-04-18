public class Triangle extends Shape {
    private Coordinates p2, p3;

    public Triangle(Coordinates p1, Coordinates p2, Coordinates p3) {
        super(3, p1);
        this.p2 = p2;
        this.p3 = p3;
    }

    /* Validates triangle using the rule: a + b > c > |a - b| */
    public static boolean isValid(Coordinates c1, Coordinates c2, Coordinates c3) {
        double a = c1.distance(c2);
        double b = c2.distance(c3);
        double c = c3.distance(c1);

        /* Checking all sides against the sum and absolute difference of the others */
        boolean checkA = (b + c > a) && (a > Math.abs(b - c));
        boolean checkB = (a + c > b) && (b > Math.abs(a - c));
        boolean checkC = (a + b > c) && (c > Math.abs(a - b));

        return checkA && checkB && checkC;
    }

    @Override
    public double getArea() {
        double a = position.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(position);
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return position.distance(p2) + p2.distance(p3) + p3.distance(position);
    }

    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);
        p2.scale(factor, sign);
        p3.scale(factor, sign);
    }

    @Override
    public String display() {
        return "Triangle [P1: " + position.display() + ", P2: " + p2.display() + ", P3: " + p3.display() + "]";
    }
}