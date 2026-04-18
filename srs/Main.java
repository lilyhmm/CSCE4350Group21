import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Scanner scanner = new Scanner(System.in);
        Connection conn = DBConnector.getConnection();

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. Add Inventory");
            System.out.println("2. Search by VIN");
            System.out.println("3. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            String sql = "";
            String input = "";

            switch (choice) {
                case 1:
                    //insert vehicle into inventory
                    System.out.println("Enter VIN: ");
                    String vin = scanner.nextLine();
                    System.out.println("Enter color: ");
                    String color = scanner.nextLine();
                    System.out.println("Enter transmission: ");
                    String transmission = scanner.nextLine();
                    System.out.println("Enter model ID: ");
                    int modelId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter dealer ID: ");
                    int dealerId = scanner.nextInt();
                    scanner.nextLine();
                    sql = "INSERT INTO Vehicle (VIN, transmission, color, model_id) VALUES (?, ?, ?, ?)";
                    try {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, vin);
                        stmt.setString(2, transmission);
                        stmt.setString(3, color);
                        stmt.setInt(4, modelId);
                        stmt.executeUpdate();
                        String inventorySql = "INSERT INTO Inventory (VIN, dealer_id) VALUES (?, ?);";
                        PreparedStatement inventoryStmt = conn.prepareStatement(inventorySql);
                        inventoryStmt.setString(1, vin);
                        inventoryStmt.setInt(2, dealerId);
                        inventoryStmt.executeUpdate();
                        System.out.println("Vehicle added to inventory successfully.");
                    } catch (Exception e) {
                        System.out.println("Error executing query: " + e.getMessage());
                    }
                    break;
                case 2:
                    //search for vehicle in inventory
                    System.out.println("Enter search criteria (VIN): ");
                    input = scanner.nextLine();
                    sql = """
                        SELECT v.VIN, v.transmission, v.color,
                        m.model_name, m.body_type,
                        b.brand_name,
                        d.dealer_name, d.address, d.phone_num
                        FROM Vehicle v 
                        JOIN Model m ON v.model_id = m.model_id
                        JOIN Brand b ON m.brand_id = b.brand_id
                        JOIN Inventory i ON v.VIN = i.VIN
                        JOIN Dealer d ON i.dealer_id = d.dealer_id
                        WHERE v.VIN = ?;
                        """;
                        try {
                            PreparedStatement stmt = conn.prepareStatement(sql);
                            stmt.setString(1, input);
                            ResultSet rs = stmt.executeQuery();
                            while (rs.next()) {
                                System.out.println("VIN: " + rs.getString("VIN"));
                                System.out.println("Transmission: " + rs.getString("transmission"));
                                System.out.println("Color: " + rs.getString("color"));
                                System.out.println("Model Name: " + rs.getString("model_name"));
                                System.out.println("Body Type: " + rs.getString("body_type"));
                                System.out.println("Brand Name: " + rs.getString("brand_name"));
                                System.out.println("Dealer Name: " + rs.getString("dealer_name"));
                                System.out.println("Dealer Address: " + rs.getString("address"));
                                System.out.println("Dealer Phone Number: " + rs.getString("phone_num"));
                                System.out.println("------------------------------------------");
                            }
                        } catch (Exception e) {
                            System.out.println("Error executing query: " + e.getMessage());
                        }
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