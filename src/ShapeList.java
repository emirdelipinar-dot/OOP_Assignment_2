import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> listOfShapes = new ArrayList<>();

    /* Adds a shape to the list whilst ensuring it is not null */
    public void addShape(Shape s) {
        if (s != null) {
            listOfShapes.add(s);
            System.out.println("Success: Shape added to the repository.");
        }
    }

    /* Removes a shape based on its ID, with boundary checks to prevent crashes */
    public void removeShape(int id) {
        if (id > 0 && id <= listOfShapes.size()) {
            listOfShapes.remove(id - 1);
            System.out.println("Success: Shape removed successfully.");
        } else {
            System.out.println("Error: Shape ID not found. Please provide a valid ID.");
        }
    }

    /* Displays area and perimeter for a specific shape if the ID is valid */
    public void showStats(int id) {
        if (id > 0 && id <= listOfShapes.size()) {
            Shape s = listOfShapes.get(id - 1);
            System.out.println("--- Shape Statistics ---");
            System.out.println("Area: " + String.format("%.2f", s.getArea()));
            System.out.println("Perimeter: " + String.format("%.2f", s.getPerimeter()));
        } else {
            System.out.println("Error: Invalid ID.");
        }
    }

    public String displayAll() {
        if (listOfShapes.isEmpty()) return "Notice: The shape list is currently empty.";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listOfShapes.size(); i++) {
            sb.append("ID: ").append(i + 1).append(" | ").append(listOfShapes.get(i).display()).append("\n");
        }
        return sb.toString();
    }
}