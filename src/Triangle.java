public class Triangle extends Shape {
    private Coordinates p2, p3;

    public Triangle(Coordinates p1, Coordinates p2, Coordinates p3) {
        super(3, p1);
        this.p2 = p2;
        this.p3 = p3;
    }

    /* Validation: Checks if three points form a valid triangle using the Triangle Inequality Theorem */
    public static boolean isValid(Coordinates c1, Coordinates c2, Coordinates c3) {
        double a = c1.distance(c2);
        double b = c2.distance(c3);
        double c = c3.distance(c1);
        // A triangle is valid if the sum of any two sides is greater than the third side
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /* Implementation of Heron's Formula to calculate the area of the triangle */
    @Override
    public double getArea() {
        double a = position.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(position);
        double s = (a + b + c) / 2.0; // Semiperimeter
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return position.distance(p2) + p2.distance(p3) + position.distance(p3);
    }

    @Override
    public void translate(int dx, int dy) {
        position.translate(dx, dy);
        p2.translate(dx, dy);
        p3.translate(dx, dy);
    }

    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);
        p2.scale(factor, sign);
        p3.scale(factor, sign);
    }

    @Override
    public String display() {
        return "Triangle [Vertices: " + position.display() + ", " + p2.display() + ", " + p3.display() + "]";
    }
}