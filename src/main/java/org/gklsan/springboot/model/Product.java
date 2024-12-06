package org.gklsan.springboot.model;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
  private int id;
  private String name;
  private double price;
}
