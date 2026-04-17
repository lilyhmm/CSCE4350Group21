import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        menu();

    }

    //menu display and selection logic
    private static void menu() {

        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("Select one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. View Sales");
            //System.out.println("2. Create Sale");
            System.out.println("2. View Inventory");
            System.out.println("3. View Suppliers");
            //System.out.println("5. Add Supplier");
            System.out.println("4. View Vehicles");
            System.out.println("5. View Customers");
            //System.outprintln("Add Customer");
            System.out.println("6. Exit");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    salesMenu();
                    break;
                case 2:
                    inventoryMenu();
                    break;
                case 3:
                    suppliersMenu();
                    break;
                case 4:
                    vehicleMenu();
                    break;
                case 5:
                    customerMenu();
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    shutdown();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            //loop ends and program exits if 6 is input
        }   while (choice != 6) ;

    }

    private static void salesMenu() {

    }

    private static void inventoryMenu() {

    }

    private static void suppliersMenu() {

    }

    private static void vehicleMenu() {

    }

    private static void customerMenu() {

    }

    private static void shutdown() {

    }

}