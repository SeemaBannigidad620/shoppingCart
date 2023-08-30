package com.example.shoppingCart.repository;

import com.example.shoppingCart.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    boolean existsByColourAndBrandAndCategory(String colour, String brand, String category);
    void deleteById(int id);
    Product findProductById(int productId);
    Product getProductByCategory(String productName);

}
