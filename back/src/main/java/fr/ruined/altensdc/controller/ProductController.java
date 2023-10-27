package fr.ruined.altensdc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ruined.altensdc.model.Product;
import fr.ruined.altensdc.repository.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {
  
  @Autowired
  private ProductRepository productRepository;

  @GetMapping
  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Product> getProduct(@PathVariable String id) {
    return productRepository.findById(id);
  }

  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
    Optional<Product> optionalExistingProduct = productRepository.findById(id);

    if (!optionalExistingProduct.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    Product existingProduct = optionalExistingProduct.get();

    if (product.getCode() != null) existingProduct.setCode(product.getCode());
    if (product.getName() != null) existingProduct.setName(product.getName());
    if (product.getDescription() != null) existingProduct.setDescription(product.getDescription());
    if (product.getPrice() != 0) existingProduct.setPrice(product.getPrice());
    if (product.getQuantity() != 0) existingProduct.setQuantity(product.getQuantity());
    if (product.getInventoryStatus() != null) existingProduct.setInventoryStatus(product.getInventoryStatus());
    if (product.getCategory() != null) existingProduct.setCategory(product.getCategory());
    if (product.getImage() != null) existingProduct.setImage(product.getImage());
    if (product.getRating() != 0) existingProduct.setRating(product.getRating());

    return ResponseEntity.ok(productRepository.save(product));
  }

  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable String id) {
      productRepository.deleteById(id);
  }
}
