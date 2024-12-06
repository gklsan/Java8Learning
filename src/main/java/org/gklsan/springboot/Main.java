package org.gklsan.springboot;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.gklsan.springboot.controller.ProductController;

import java.io.File;


public class Main {
  public static void main(String[] args) throws Exception {

    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    System.out.printf("Hello and welcome!");
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(4000);
    String webappDir = new File("src/main/webapp").getAbsolutePath();
    Context ctx = tomcat.addWebapp("", webappDir);

    tomcat.getConnector();

    Wrapper wrapper = Tomcat.addServlet(ctx, "productController", new ProductController());
    ctx.addServletMappingDecoded("/products/*", "productController");

    tomcat.start();
    tomcat.getServer().await();
  }
}