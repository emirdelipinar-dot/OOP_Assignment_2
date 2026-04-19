import java.util.ArrayList;

class ShapeList {
    private ArrayList<Shape> listOfShapes = new ArrayList<>();

    public void addShape(Shape s) {
        if (s != null) {
            listOfShapes.add(s);
            System.out.println("Success: Shape added to the repository.");
        }
    }

    public void removeShape(int id) {
        /* Boundary check to ensure the programme does not crash */
        if (id > 0 && id <= listOfShapes.size()) {
            listOfShapes.remove(id - 1);
            System.out.println("Success: Shape removed successfully.");
        } else {
            System.out.println("Error: Invalid ID. No shape found at this position.");
        }
    }

    /* Translates all shapes in the list by a given displacement (UK English) */
    public void translateAllShapes(int dx, int dy) {
        if (listOfShapes.isEmpty()) {
            System.out.println("Notice: No shapes available to translate.");
            return;
        }
        for (Shape s : listOfShapes) {
            s.translate(dx, dy);
        }
        System.out.println("Success: All shapes in the list have been translated.");
    }

    /* Scales all shapes in the list by a given factor (UK English) */
    public void scaleAllShapes(int factor, boolean sign) {
        if (listOfShapes.isEmpty()) {
            System.out.println("Notice: No shapes available to scale.");
            return;
        }
        for (Shape s : listOfShapes) {
            s.scale(factor, sign);
        }
        System.out.println("Success: All shapes in the list have been scaled.");
    }

    /* Enhanced display method showing area and perimeter for all shapes */
    public String displayAll() {
        if (listOfShapes.isEmpty()) {
            return "Notice: The shape repository is currently empty.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Current Shapes in Repository -----\n");
        for (int i = 0; i < listOfShapes.size(); i++) {
            Shape s = listOfShapes.get(i);
            sb.append("ID: ").append(i + 1).append(" | ")
                    .append(s.display()).append("\n")
                    .append("   > Calculated Area: ").append(String.format("%.2f", s.getArea())).append("\n")
                    .append("   > Calculated Perimeter: ").append(String.format("%.2f", s.getPerimeter())).append("\n")
                    .append("----------------------------------------\n");
        }
        return sb.toString();
    }
}