public abstract class Shape {
    protected Coordinates position;
    protected int sides;

    public Shape(int noOfSides, Coordinates coord) {
        this.position = coord;
        this.sides = noOfSides;
    }


}