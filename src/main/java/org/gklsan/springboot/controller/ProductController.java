package org.gklsan.springboot.controller;

import org.gklsan.springboot.dao.ProductDAO;
import org.gklsan.springboot.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/products/*")
public class ProductController extends HttpServlet{
  private ProductDAO productDAO;

  public void init() {
    productDAO = new ProductDAO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getPathInfo();
    try {
      switch(action) {
        case "/list":
          listProducts(request, response);
          break;
      }
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
  }

  private void listProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Product> products = productDAO.listAllProducts();
    request.setAttribute("products", products);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/product-list.jsp");
    dispatcher.forward(request, response);
  }
}
