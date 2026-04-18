import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        menu();

    }

    //menu display and selection logic
    private static void menu() throws SQLException {

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

    private static void adminMenu() throws SQLException {
        //admin view can input sql queries through command line

        int choice;
        String query;
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
            input.nextLine();

            switch (choice) {
                case 1:
                    //pass gathered string into function to send it to execute it in mySQL
                    System.out.println("Enter Query: ");
                    System.out.println("(Ensure input is on one line)");
                    query = input.nextLine();

                    if (query == null || query.isEmpty()) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    else {
                        executeQuery(query);
                    }

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
        Connection conn = DBConnector.getConnection();
        int choice;
        Scanner input = new Scanner(System.in);
        String sql = "";
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
                    try {
                        Statement stmt = conn.createStatement();
                        sql = "SELECT dealer_id, dealer_name, address, phone_num FROM Dealer";
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            System.out.println("Dealer ID: " + rs.getInt("dealer_id"));
                            System.out.println("Dealer Name: " + rs.getString("dealer_name"));
                            System.out.println("Address: " + rs.getString("address"));
                            System.out.println("Phone Number: " + rs.getString("phone_num"));
                            System.out.println("------------------------------------------");
                        }
                    } catch (Exception e) {
                        System.out.println("Error executing query: " + e.getMessage());
                    }
                    break;
                case 2:
                    //view vehicles table with dealer and vehicle details
                    try {
                        Statement statement = conn.createStatement();
                        sql = "SELECT v.VIN, v.transmission, v.color, m.model_name, m.body_type, b.brand_name, d.dealer_name " +
                                "FROM Vehicle v " +
                                "JOIN Model m ON v.model_id = m.model_id " +
                                "JOIN Brand b ON m.brand_id = b.brand_id " +
                                "JOIN Inventory i ON v.VIN = i.VIN " +
                                "JOIN Dealer d ON i.dealer_id = d.dealer_id;";
                        ResultSet rs = statement.executeQuery(sql);
                        while (rs.next()) {
                            System.out.println("VIN: " + rs.getString("VIN"));
                            System.out.println("Transmission: " + rs.getString("transmission"));
                            System.out.println("Color: " + rs.getString("color"));
                            System.out.println("Model Name: " + rs.getString("model_name"));
                            System.out.println("Body Type: " + rs.getString("body_type"));
                            System.out.println("Brand Name: " + rs.getString("brand_name"));
                            System.out.println("Dealer Name: " + rs.getString("dealer_name"));
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

    private static void marketingMenu() {
        //marketing view can view sales reports (Dealers, Sales, Customers)

        int choice;
        Scanner input = new Scanner(System.in);
        Connection conn = DBConnector.getConnection();

        //do while loop to display menu
        do {
            System.out.println("\nSelect one of the following options: ");
            System.out.println("------------------------------------------");
            System.out.println("1. View Sales Report");
            System.out.println("2. Return to Main Menu");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //View Sales Reports for Dealers (list of sales for each dealer)
                    try {
                        Statement statement = conn.createStatement();
                        String sql = "SELECT * FROM sales;";
                        ResultSet rs = statement.executeQuery(sql);
                        System.out.println();
                        System.out.println("------------------------------------------");
                        while (rs.next()) {
                            System.out.println("Sale ID: " + rs.getString("sale_id"));
                            System.out.println("Date: " + rs.getString("date"));
                            System.out.println("Brand Name: " + rs.getString("brand"));
                            System.out.println("Model Name: " + rs.getString("model"));
                            System.out.println("Body Color: " + rs.getString("color"));
                            System.out.println("Dealer ID: " + rs.getString("dealer_id"));
                            System.out.println("Customer ID: " + rs.getString("customer_id"));
                            System.out.println("------------------------------------------");
                        }
                    } catch (Exception e) {
                        System.out.println("Error executing query: " + e.getMessage());
                    }
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

    private static void executeQuery(String query) throws SQLException {
        //passes query as valid SQL query in database

        Connection conn = DBConnector.getConnection();
        Statement statement = conn.createStatement();

        try {

            boolean content = statement.execute(query);

            //checks if query is null or not, passes query if not
            if (content) {
                ResultSet resultSet = statement.getResultSet();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int colCount = metaData.getColumnCount();
                int counter = 1;
                System.out.println("\n");

                while (resultSet.next()) {
                    for (int i = 1; i <= colCount; i++) {
                        System.out.println(resultSet.getString(i) + " ");

                    }
                    System.out.println();
                    counter++;
                }
            }

            //if null, output status changes
            else {
                int rowsAffected = statement.getUpdateCount();
                if (rowsAffected < 0) {
                    System.out.println("Query Executed. No rows affected.");
                }
                else if (rowsAffected > 0) {
                    System.out.println("Query Executed. " + rowsAffected + " rows affected.");
                }
            }

        } catch (Exception e) {
            System.out.println("\nError executing query: " + e.getMessage());
        }
    }
}