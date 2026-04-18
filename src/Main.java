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
                String choiceStr = input.next(); // Reading as String to prevent scanner crashes
                char choice = choiceStr.charAt(0);

                if (choice == '4') {
                    System.out.println("Exiting the programme...");
                    break;
                }

                switch (choice) {
                    case '1':
                        System.out.print("Enter shape type (C, T, S, R): ");
                        char type = input.next().toUpperCase().charAt(0);

                        System.out.print("Enter X and Y coordinates: ");
                        int x = input.nextInt();
                        int y = input.nextInt();
                        Coordinates pos = new Coordinates(x, y);

                        if (type == 'C') {
                            System.out.print("Enter radius: ");
                            double r = input.nextDouble();
                            myShapes.addShape(new Circle(pos, r));
                        } else if (type == 'T') {
                            System.out.print("Enter P2(x y) and P3(x y): ");
                            Coordinates p2 = new Coordinates(input.nextInt(), input.nextInt());
                            Coordinates p3 = new Coordinates(input.nextInt(), input.nextInt());
                            if (Triangle.isValid(pos, p2, p3)) {
                                myShapes.addShape(new Triangle(pos, p2, p3));
                            } else {
                                System.out.println("Error: Invalid coordinates for a triangle.");
                            }
                        } else if (type == 'S') {
                            System.out.print("Enter side length: ");
                            double s = input.nextDouble();
                            myShapes.addShape(new Square(pos, s));
                        } else if (type == 'R') {
                            System.out.print("Enter width and length: ");
                            double w = input.nextDouble();
                            double l = input.nextDouble();
                            myShapes.addShape(new Rectangle(pos, w, l));
                        }
                        break;

                    case '2':
                        System.out.print("Enter shape ID to remove: ");
                        int id = input.nextInt();
                        myShapes.removeShape(id);
                        break;

                    case '3':
                        System.out.println("\n----- List of all Shapes -----");
                        System.out.println(myShapes.displayAll());
                        break;

                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                /* Catching all possible exceptions to prevent the programme from crashing */
                System.out.println("An error occurred: Invalid input or operation.");
                input.nextLine(); // Clear the buffer
            }
        }
        input.close();
    }
}

