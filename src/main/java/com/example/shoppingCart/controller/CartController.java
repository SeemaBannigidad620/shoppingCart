package com.example.shoppingCart.controller;

import com.example.shoppingCart.model.Cart;
import com.example.shoppingCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/cart")
@RestController
public class CartController {

    @Autowired
    CartService cartService;
    
}
