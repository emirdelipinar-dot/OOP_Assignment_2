import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Create Scanner
        Scanner input = new Scanner(System.in);
        //String Menu
        String menu = "\n ***** Shape Management Application ****** \n";
        menu += "Menu\n";
        menu += "1- Add Shape\n";
        menu += "2- Remove Shape\n";
        menu += "3- Show all shapes\n";
        menu += "4- Exit\n";
        menu += "Enter your Choice (1..4): ";

        //Repeat printing menu and get the user option
        while(true){
            System.out.print(menu);
            char choice = input.next().charAt(0);//get the user choice
            input.nextLine();//to consume the leftover newline character (\n) from the input buffer.
            if (choice == '1'){
                System.out.print("Enter shape type to add: (C , T, S, R) ");
                char type = input.next().toUpperCase().charAt(0);
                if(type == 'C'){
                    //add your code here
                    System.out.println("A new Circle created.");
                }
                else if(type == 'T'){
                    //add your code here
                    System.out.println("A new Triangle created.");
                }
                else if(type == 'S'){
                    //add your code here
                    System.out.println("A new Square created.");
                }
                else if(type == 'R'){
                    //add your code here
                    System.out.println("A new Rectangle created.");
                }
                else{
                    System.out.println("Invalid input, Try again.");
                }
            }
            else if (choice == '2'){
                System.out.print("Enter shape ID to remove: ");
                int id = input.nextInt();
                // add you code here
                System.out.println("\nA shape has been Successfully removed.");
            }
            else if (choice == '3'){
                System.out.println("\n-----List of all Shapes----\n ");
                // add you code here
            }
            else if (choice == '4'){
                System.out.println("Exiting .....");
                break;
            }
            else{
                System.out.println("Invalid input, Try again.");
            }
        }
    }
}




