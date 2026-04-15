public class Main {

    public class Main {
        public static void main(String[] args) {
            System.out.println("***** Shape Management Application ******");
            //Test coordinates class
            Coordinates point1 = new Coordinates(10, 20);
            System.out.println(point1.display());
            //Test Rectangle class
            Rectangle r1 = new Rectangle(point1, 10, 20);
            Coordinates pointA = new Coordinates(2, 3);
            double d = point1.distance(pointA);
            System.out.println("Distance between point 1 and point A " + d);
            System.out.println(r1.display());
            //Test Circle class
        }
    }




}
