public class Coordinates {
    private int x;
    private int y;

    /* Constructor with validation to ensure coordinates are non-negative */
    public Coordinates(int x, int y) throws Exception {
        if (x < 0 || y < 0) {
            /* Since the origin (0,0) is at the top-left, coordinates must be positive */
            throw new Exception("Input Error: Coordinates (X and Y) must be positive.");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    /* Calculates the Euclidean distance between two points */
    public double distance(Coordinates p) {
        return Math.sqrt(Math.pow(p.getX() - this.x, 2) + Math.pow(p.getY() - this.y, 2));
    }

    /* Moves the coordinates by a specified displacement */
    public void translate(int dx, int dy) {
        /* After translation, we ensure the points don't move into negative space */
        this.x = Math.max(0, this.x + dx);
        this.y = Math.max(0, this.y + dy);
    }

    /* Scales the coordinate values by a given factor */
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.x *= factor;
            this.y *= factor;
        } else {
            if (factor != 0) {
                this.x /= factor;
                this.y /= factor;
            }
        }
    }

    public String display() {
        return "X = " + x + ", Y = " + y;
    }
}