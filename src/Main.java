import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShapeList myShapes = new ShapeList();
        Scanner input = new Scanner(System.in);

        /* Standard menu following the assignment specification */
        String menu = "\n ***** Shape Management Application ****** \n";
        menu += "1- Add Shape\n";
        menu += "2- Remove Shape\n";
        menu += "3- Show all shapes\n";
        menu += "4- Translate all shapes\n";
        menu += "5- Scale all shapes\n";
        menu += "0- Exit\n";
        menu += "Enter your Choice (0..5): ";

        while (true) {
            try {
                System.out.print(menu);
                String choice = input.nextLine().trim();

                if (choice.equals("0")) {
                    System.out.println("Exiting the programme. Goodbye!");
                    break;
                }

                if (choice.equals("1")) {
                    boolean shapeAdded = false;
                    while (!shapeAdded) {
                        System.out.print("Enter shape type (C: Circle, T: Triangle, S: Square, R: Rectangle) or 'M' for Menu: ");
                        String typeIn = input.nextLine().toUpperCase().trim();
                        if (typeIn.equals("M")) break;
                        if (typeIn.isEmpty()) continue;

                        char type = typeIn.charAt(0);
                        if ("CTSR".indexOf(type) == -1) {
                            System.out.println("Invalid Input: Please enter C, T, S, or R.");
                            continue;
                        }

                        try {
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
                                    myShapes.addShape(new Rectangle(pos, input.nextDouble(), input.nextDouble()));
                                    shapeAdded = true;
                                    break;
                                case 'T':
                                    System.out.print("Enter X Y for Vertex 2: ");
                                    Coordinates p2 = new Coordinates(input.nextInt(), input.nextInt());
                                    System.out.print("Enter X Y for Vertex 3: ");
                                    Coordinates p3 = new Coordinates(input.nextInt(), input.nextInt());
                                    myShapes.addShape(new Triangle(pos, p2, p3));
                                    shapeAdded = true;
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("Programme Alert: " + e.getMessage());
                        } finally {
                            if (input.hasNextLine()) input.nextLine();
                        }
                    }
                } else if (choice.equals("2")) {
                    System.out.print("Enter shape ID to remove: ");
                    int id = Integer.parseInt(input.nextLine());
                    myShapes.removeShape(id);
                } else if (choice.equals("3")) {
                    System.out.println(myShapes.displayAll());
                } else if (choice.equals("4")) {
                    System.out.print("Enter DX and DY to translate all shapes: ");
                    int dx = input.nextInt();
                    int dy = input.nextInt();
                    input.nextLine();
                    myShapes.translateAllShapes(dx, dy);
                } else if (choice.equals("5")) {
                    System.out.print("Enter scale factor: ");
                    int factor = input.nextInt();
                    System.out.print("Enter 'true' to enlarge or 'false' to shrink: ");
                    boolean sign = input.nextBoolean();
                    input.nextLine();
                    myShapes.scaleAllShapes(factor, sign);
                } else {
                    System.out.println("Invalid selection. Please choose an option between 0 and 5.");
                }

            } catch (Exception e) {
                System.out.println("Programme Notice: An unexpected error occurred. " + e.getMessage());
                if (input.hasNextLine()) input.nextLine();
            }
        }
        input.close();
    }
}