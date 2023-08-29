package com.example.shoppingCart.repository;

import com.example.shoppingCart.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserIdAndCartId(String userId, String cartId);
}
