import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        menu();
        shutdown();

    }

    //menu display and selection logic
    private static void menu() {

        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. Administrator View");
            System.out.println("2. Vehicle Locator View");
            System.out.println("3. Customers View");
            System.out.println("4. Marketing View");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    vehicleLocatorMenu();
                    break;
                case 3:
                    customerMenu();
                    break;
                case 4:
                    marketingMenu();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            //loop ends and program exits if 5 is input
        }   while (choice != 5);

    }

    private static void adminMenu() {
        //admin view can input sql queries through command line

        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. New Query");
            System.out.println("2. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //intake new query to modify the database
                    break;
                case 2:
                    //end loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            //loop ends and program exits if 6 is input
        }   while (choice != 2);


    }

    private static void vehicleLocatorMenu() {
        //vehicle locator view can check inventory, search for vehicles

        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. Add Inventory");
            System.out.println("2. Search for Vehicle");
            System.out.println("3. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //insert vehicle into inventory
                    break;
                case 2:
                    //search for vehicle
                    break;
                case 3:
                    //end loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            //loop ends and program exits if 6 is input
        }   while (choice != 3);


    }

    private static void customerMenu() {
        //customer view can view dealers and look at vehicles/products/inventories

        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. View Dealers");
            System.out.println("2. View Vehicles");
            System.out.println("3. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //insert list of dealers table
                    break;
                case 2:
                    //view vehicles table with dealer and vehicle details
                    break;
                case 3:
                    //end loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            //loop ends and program exits if 6 is input
        }   while (choice != 3);

    }

    private static void marketingMenu() {
        //marketing view can view sales reports (Dealers, Sales, Customers)

        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. Add Sales Report");
            System.out.println("2. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //View Sales Reports for Dealers (list of sales for each dealer)
                    break;
                case 2:
                    //end loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            //loop ends and program exits if 6 is input
        }   while (choice != 2);

    }

    private static void shutdown() {

    }

}