import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShapeList myShapes = new ShapeList();
        Scanner input = new Scanner(System.in);

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
                    // Inner loop to keep the user in "Add Shape" section until successful
                    while (!shapeAdded) {
                        System.out.print("Enter shape type (C: Circle, T: Triangle, S: Square, R: Rectangle) or 'M' for Main Menu: ");
                        String typeIn = input.nextLine().toUpperCase().trim();

                        if (typeIn.isEmpty()) continue;
                        char type = typeIn.charAt(0);

                        if (type == 'M') break; // Back to main menu option

                        if (type != 'C' && type != 'T' && type != 'S' && type != 'R') {
                            System.out.println("Invalid Input: Please only enter C, T, S, or R.");
                            continue; // Asks the same question again
                        }

                        // Coordinates input (Generic for all shapes)
                        System.out.print("Enter X and Y for position: ");
                        int x = input.nextInt();
                        int y = input.nextInt();
                        Coordinates pos = new Coordinates(x, y);

                        if (type == 'C') {
                            System.out.print("Enter radius: ");
                            myShapes.addShape(new Circle(pos, input.nextDouble()));
                            shapeAdded = true;
                        } else if (type == 'R') {
                            System.out.print("Enter width and length: ");
                            myShapes.addShape(new Rectangle(pos, input.nextDouble(), input.nextDouble()));
                            shapeAdded = true;
                        } else if (type == 'S') {
                            System.out.print("Enter side length: ");
                            myShapes.addShape(new Square(pos, input.nextDouble()));
                            shapeAdded = true;
                        } else if (type == 'T') {
                            System.out.print("Enter X Y for P2: ");
                            Coordinates p2 = new Coordinates(input.nextInt(), input.nextInt());
                            System.out.print("Enter X Y for P3: ");
                            Coordinates p3 = new Coordinates(input.nextInt(), input.nextInt());
                            myShapes.addShape(new Triangle(pos, p2, p3));
                            shapeAdded = true;
                        }
                        input.nextLine(); // Clear buffer after successful addition
                    }
                } else if (choice.equals("2")) {
                    System.out.print("Enter ID: ");
                    myShapes.removeShape(Integer.parseInt(input.nextLine()));
                } else if (choice.equals("3")) {
                    System.out.println(myShapes.displayAll());
                }

            } catch (Exception e) {
                /* General Exception handling for geometrical and numerical errors
                   (UK English comments) */
                System.out.println("Programme Alert: " + e.getMessage());
                if (input.hasNextLine()) input.nextLine(); // Flush scanner buffer
            }
        }
        input.close();
    }
}