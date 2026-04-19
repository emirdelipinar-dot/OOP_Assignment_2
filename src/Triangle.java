public class Triangle extends Shape {
    private Coordinates p2;
    private Coordinates p3;

    /* Constructor that receives three vertices and validates the shape  */
    public Triangle(Coordinates p1, Coordinates p2, Coordinates p3) throws Exception {
        super(3, p1); // Initialises the number of sides and the first vertex [cite: 46]

        // 1. Check if any two points are exactly at the same location
        if (isIdentical(p1, p2) || isIdentical(p1, p3) || isIdentical(p2, p3)) {
            throw new Exception("Geometrical Error: A triangle must have three distinct vertices. Identical points detected.");
        }

        // 2. Geometrical validation using the Triangle Inequality Theorem (a + b > c > |a - b|)
        if (!isValid(p1, p2, p3)) {
            throw new Exception("Geometrical Error: These vertices are collinear and cannot form a valid triangle.");
        }

        this.p2 = p2;
        this.p3 = p3;
    }

    /* Helper method to check for identical coordinates */
    private boolean isIdentical(Coordinates c1, Coordinates c2) {
        return c1.getX() == c2.getX() && c1.getY() == c2.getY();
    }

    /* Validates the triangle geometry by checking all side relationships [cite: 83] */
    public static boolean isValid(Coordinates c1, Coordinates c2, Coordinates c3) {
        double a = c1.distance(c2);
        double b = c2.distance(c3);
        double c = c3.distance(c1);

        // Comprehensive check: each side must be less than sum and greater than absolute difference of the others
        return (a + b > c && c > Math.abs(a - b)) &&
                (a + c > b && b > Math.abs(a - c)) &&
                (b + c > a && a > Math.abs(b - c));
    }

    /* Implementation of Heron's Formula to calculate the area [cite: 83, 84] */
    @Override
    public double getArea() {
        double a = position.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(position);
        double s = (a + b + c) / 2.0; // Semiperimeter [cite: 86]
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /* Returns the perimeter as the sum of the distances between vertices [cite: 81] */
    @Override
    public double getPerimeter() {
        return position.distance(p2) + p2.distance(p3) + p3.distance(position);
    }

    /* Overridden translate method to move all vertices accordingly [cite: 82, 87] */
    @Override
    public void translate(int dx, int dy) {
        position.translate(dx, dy);
        p2.translate(dx, dy);
        p3.translate(dx, dy);
    }

    /* Overridden scale method to adjust all vertices relative to the centre [cite: 88, 89] */
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