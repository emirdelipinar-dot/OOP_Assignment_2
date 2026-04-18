import java.util.ArrayList;

class ShapeList {
    private ArrayList<Shape> listOfShapes = new ArrayList<>();

    public void addShape(Shape s) {
        if (s != null) {
            listOfShapes.add(s);
            System.out.println("Success: Shape added to the list.");
        }
    }

    public void removeShape(int id) {
        /* Boundary check to ensure the programme does not crash */
        if (id > 0 && id <= listOfShapes.size()) {
            listOfShapes.remove(id - 1);
            System.out.println("Success: Shape removed.");
        } else {
            System.out.println("Error: Invalid ID. No shape found at this position.");
        }
    }

    /* Enhanced display method showing area and perimeter for all shapes */
    public String displayAll() {
        if (listOfShapes.isEmpty()) {
            return "The shape list is currently empty.";
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