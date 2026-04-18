import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> listOfShapes = new ArrayList<>();

    public void addShape(Shape s) { listOfShapes.add(s); }

    public void removeShape(int pos) {
        if (pos > 0 && pos <= listOfShapes.size()) {
            listOfShapes.remove(pos - 1);
        }
    }

    public void translateShapes(int dx, int dy) {
        for (Shape s : listOfShapes) s.translate(dx, dy);
    }

    public void scaleShapes(int factor, boolean sign) {
        for (Shape s : listOfShapes) s.scale(factor, sign);
    }
    public String displayAll() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listOfShapes.size(); i++) {
            sb.append((i + 1)).append(": ").append(listOfShapes.get(i).display()).append("\n");
        }
        return sb.toString();
    }

    public Shape getShape(int pos) {
        return (pos > 0 && pos <= listOfShapes.size()) ? listOfShapes.get(pos-1) : null;
    }
}
