package org.gklsan.springboot.dao;

import org.gklsan.springboot.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
  private String jdbcURL = "jdbc:mysql://localhost:3306/productdb";
  private String jdbcUsername = "springstudent";
  private String jdbcPassword = "springstudent";

  protected Connection getConnection() throws SQLException {
    return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
  }

  public List<Product> listAllProducts() throws SQLException {
    List<Product> products = new ArrayList<>();
    String sql = "SELECT * FROM products";
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        products.add(product);
      }
    }
    return products;
  }

  public Product getProduct(int id) throws SQLException {
    Product product = null;
    String sql = "SELECT * FROM products WHERE id = ?";
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
      }
    }
    return product;
  }

}
