package fr.ruined.altensdc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Product {
  @Id
  private String id;
  private String code;
  private String name;
  private String description;
  private double price;
  private int quantity;
  private String inventoryStatus;
  private String category;
  private String image;
  private int rating;
}
