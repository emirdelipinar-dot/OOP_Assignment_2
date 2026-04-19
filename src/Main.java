import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShapeList myShapes = new ShapeList();
        Scanner input = new Scanner(System.in);

        // Standard menu as per the assignment specification
        String menu = "\n ***** Shape Management Application ****** \n";
        menu += "Menu\n";
        menu += "1- Add Shape\n";
        menu += "2- Remove Shape\n";
        menu += "3- Show all shapes\n";
        menu += "4- Exit\n";
        menu += "Enter your Choice (1..4): ";

        while (true) {
            try {
                System.out.print(menu);
                String choice = input.nextLine().trim();

                if (choice.equals("4")) {
                    System.out.println("Exiting the programme. Goodbye!");
                    break;
                }

                if (choice.equals("1")) {
                    boolean shapeAdded = false;
                    /* Inner loop to ensure the user stays in the 'Add' section until
                       a valid shape is created or they choose to return to the menu. */
                    while (!shapeAdded) {
                        System.out.print("Enter shape type (C: Circle, T: Triangle, S: Square, R: Rectangle) or 'M' for Main Menu: ");
                        String typeIn = input.nextLine().toUpperCase().trim();

                        if (typeIn.isEmpty()) continue;
                        if (typeIn.equals("M")) break; // Escape to main menu

                        char type = typeIn.charAt(0);

                        // Validate shape type to avoid 'always true' logic warnings
                        if ("CTSR".indexOf(type) == -1) {
                            System.out.println("Invalid Input: Please only enter C, T, S, or R.");
                            continue;
                        }

                        try {
                            // Common coordinate input for all shapes
                            System.out.print("Enter X and Y for position: ");
                            int x = input.nextInt();
                            int y = input.nextInt();
                            Coordinates pos = new Coordinates(x, y);

                            switch (type) {
                                case 'C':
                                    System.out.print("Enter radius: ");
                                    myShapes.addShape(new Circle(pos, input.nextDouble()));
                                    shapeAdded = true;
                                    break;
                                case 'S':
                                    System.out.print("Enter side length: ");
                                    myShapes.addShape(new Square(pos, input.nextDouble()));
                                    shapeAdded = true;
                                    break;
                                case 'R':
                                    System.out.print("Enter width and length: ");
                                    double w = input.nextDouble();
                                    double l = input.nextDouble();
                                    /* The Rectangle constructor will throw an exception
                                       if width equals length to ensure it is not a square. */
                                    myShapes.addShape(new Rectangle(pos, w, l));
                                    shapeAdded = true;
                                    break;
                                case 'T':
                                    System.out.print("Enter X Y for Vertex 2: ");
                                    Coordinates p2 = new Coordinates(input.nextInt(), input.nextInt());
                                    System.out.print("Enter X Y for Vertex 3: ");
                                    Coordinates p3 = new Coordinates(input.nextInt(), input.nextInt());
                                    /* The Triangle constructor validates identical points
                                       and the triangle inequality theorem (a+b > c > |a-b|). */
                                    myShapes.addShape(new Triangle(pos, p2, p3));
                                    shapeAdded = true;
                                    break;
                            }
                        } catch (Exception e) {
                            /* Catches geometrical errors (like identical vertices in a triangle)
                               and asks the user for input again within the inner loop. */
                            System.out.println("Programme Alert: " + e.getMessage());
                        } finally {
                            // Ensure the scanner buffer is cleared after numeric inputs
                            if (input.hasNextLine()) input.nextLine();
                        }
                    }
                } else if (choice.equals("2")) {
                    System.out.print("Enter shape ID to remove: ");
                    int id = Integer.parseInt(input.nextLine());
                    myShapes.removeShape(id);
                } else if (choice.equals("3")) {
                    // Displays all shapes including their area and perimeter calculations
                    System.out.println(myShapes.displayAll());
                } else {
                    System.out.println("Invalid selection. Please enter a number between 1 and 4.");
                }

            } catch (Exception e) {
                /* General Exception handling to prevent the programme from crashing
                   due to invalid data types or unexpected errors. */
                System.out.println("Programme Notice: " + e.getMessage());
                if (input.hasNextLine()) input.nextLine();
            }
        }
        input.close();
    }
}