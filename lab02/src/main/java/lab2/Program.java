package lab2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Program {
    private ProductDAO<Product, Integer> productDAO;

    public Program(Connection conn) {
        productDAO = new ProductDAO<>(conn);
    }

    public static void main(String[] args) throws SQLException {

        if (args.length < 1) {
            System.out.println("Usage: java lab2.Program <connection_url>");
            return;
        }

        // Lấy URL từ đối số dòng lệnh
        String url = args[0];
        Connection connection = DbConnection.getConnection(url);

        if (connection == null) {
            System.out.println("Failed to connect to the database");
            return;
        }

        Program program = new Program(connection);
        int choice = 0;

        while (choice != 6); {
            program.menu();
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                //DOC TOAN BO PRODUCT
                case 1:
                    program.readAll();
                    break;
                //DOC PRODUCT VOI ID
                case 2:
                    program.read();
                    break;
                //them product
                case 3:
                    program.add();
                    break;
                //update product voi id
                case 4:
                    program.update();
                    break;
                case 5:
                    program.delete();
                    break;
                case 6:
                    break;
            }
        }
    }

    public void menu() {
        System.out.println("1. Read all products");
        System.out.println("2. Read detail of product by id");
        System.out.println("3. Add new product");
        System.out.println("4. Update product");
        System.out.println("5. Delete product by id");
        System.out.println("6. Exit\n");

        System.out.println("Enter your choice: ");
    }
    private void readAll() {
        List<Product> products = productDAO.readAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }
    private void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product id: ");
        int product_id = sc.nextInt();
        Product product = productDAO.read(product_id);
        System.out.println(product);
    }
    private void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = sc.next();
        String enter = sc.next();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        enter = sc.next();
        System.out.println("Enter product color: ");
        String color = sc.next();
        Product product = new Product(name, price, color);
        if (product != null) {
            System.out.println("Add product successfully");
        }
        else {
            System.out.println("Add product failed");
        }
    }
    private void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product id: ");
        int id = sc.nextInt();
        String enter = sc.next();
        System.out.println("Enter product name: ");
        String name = sc.next();
        enter = sc.next();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        enter = sc.next();
        System.out.println("Enter product color: ");
        String color = sc.next();
        enter = sc.next();
        Product product = new Product(name, price, color, id);
        boolean rs = productDAO.update(product);
        if (rs) {
            System.out.println("Update product successfully");
        }
        else {
            System.out.println("Update product failed");
        }
    }
    private void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product id: ");
        int id = sc.nextInt();
        boolean rs = productDAO.delete(id);
        if (rs) {
            System.out.println("Delete product successfully");
        }
        else {
            System.out.println("Delete product failed");
        }
    }

}
