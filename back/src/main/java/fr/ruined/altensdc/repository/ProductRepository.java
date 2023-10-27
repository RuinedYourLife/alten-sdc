package fr.ruined.altensdc.repository;

import fr.ruined.altensdc.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
  
}
