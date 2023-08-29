package com.example.shoppingCart.service;

import com.example.shoppingCart.model.ProductRequest;
import com.example.shoppingCart.model.Cart;
import com.example.shoppingCart.repository.CartRepository;
import com.example.shoppingCart.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.function.RenderingResponse;

import java.util.Map;
import java.util.Set;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ValidationUtils validationUtils;

    public ResponseEntity<String> createCart(Cart cart) {
        try {
            validationUtils.validateCart(cart.getCartId());
            validationUtils.validateUser(cart);
            validationUtils.validateProducts(cart);
            Cart savedCart = cartRepository.save(cart);
            return ResponseEntity.status(HttpStatus.OK).body("Cart created successfully with the cartId" +
                    savedCart.getCartId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    public ResponseEntity<String> addToCart(ProductRequest request) {
        try {
            Cart existingCart = validationUtils.cartValidation(request.getCartId());
            Map<String, Integer> productQuantityMap = existingCart.getProducts();
            for (Map.Entry<String, Integer> product : productQuantityMap.entrySet()) {
                String productName = product.getKey();
                int quantity = product.getValue();
                if (request.getProductName().equals(productName)) {
                    if (quantity < 10) {
                        productQuantityMap.put(productName, quantity + request.getQuantity());
                        existingCart.setProducts(productQuantityMap);
                        cartRepository.save(existingCart);
                    }
                } else {
                    if (quantity <= 10) {
                        productQuantityMap.put(productName, quantity);
                    } else {
                        throw new RuntimeException("quantity should be less than equals to 10");
                    }
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body("Product added successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}