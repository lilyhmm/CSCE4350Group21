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
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. View Sales");
            System.out.println("2. View Inventory");
            System.out.println("3. View Suppliers");
            System.out.println("4. View Customers");
            System.out.println("5. Exit");
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
                    customerMenu();
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

    private static void salesMenu() {
        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. Create Sale");
            System.out.println("2. View Sales Table");
            System.out.println("3. View Dealers Table");
            System.out.println("4. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //insert new sale into sales table
                    break;
                case 2:
                    //view sales table
                    break;
                case 3:
                    //view dealers table
                    break;
                case 4:
                    //end loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            //loop ends and program exits if 6 is input
        }   while (choice != 4);

    }

    private static void inventoryMenu() {
        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. Add New Car to Inventory");
            System.out.println("2. View Inventory Table");
            System.out.println("3. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //insert new vehicle into inventory table
                    break;
                case 2:
                    //view inventory table
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

    private static void suppliersMenu() {
        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. Add New Supplier");
            System.out.println("2. View Suppliers Table");
            System.out.println("3. View Parts Table");
            System.out.println("4. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //insert new supplier into supplier table
                    break;
                case 2:
                    //view supplier table
                    break;
                case 3:
                    //view parts table
                    break;
                case 4:
                    //end loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            //loop ends and program exits if 6 is input
        }   while (choice != 4);

    }

    private static void customerMenu() {
        int choice;
        Scanner input = new Scanner(System.in);

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. Add New Customer");
            System.out.println("2. View Customer Table");
            System.out.println("3. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //insert new customer into customer table
                    break;
                case 2:
                    //View customer table
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

    private static void shutdown() {

    }

}