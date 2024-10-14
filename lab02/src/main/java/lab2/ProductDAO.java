package lab2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static lab2.DbConnection.getConnection;

public class ProductDAO<P extends Product, I extends Integer> implements Repository<Product, Integer> {
//    private static final String URL = "jdbc:mysql://localhost:3306";
//    private static final String USER = "root";
//    private static final String PASSWORD = "root123";
    private Connection conn;

    // Constructor để nhận kết nối từ bên ngoài
    public ProductDAO(Connection connection) {
        this.conn = connection;
    }
    @Override
    public Integer add(Product item) throws SQLException {
        String sql = "INSERT INTO product (name, price, color) VALUES(?,?,?)";
        try {
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());
            stmt.setString(3, item.getColor());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException();
            }

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
            else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try {
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();

            Product product = null;
            while (rs.next()) {
                product = new Product(
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getString("color"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public Product read(Integer id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try {
             PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Product product = null;
            if (rs.next()) {
                product = new Product(
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getString("color"));
                return product;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Product item) {
        String sql = "UPDATE Product SET name = ?, price = ?, color = ? WHERE id = ?";
        try {
             PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());
            stmt.setString(3, item.getColor());
            stmt.setInt(4, item.getId());

            int result = stmt.executeUpdate();
            stmt.close();
            conn.close();
            return result > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM Product WHERE id = ?";
        try {
             PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int result = stmt.executeUpdate();
            stmt.close();
            conn.close();
            return result > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
