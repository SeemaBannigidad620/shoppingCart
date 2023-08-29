package com.example.shoppingCart.repository;

import com.example.shoppingCart.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByUserIdAndCartId(String cartId, String userId);
}
