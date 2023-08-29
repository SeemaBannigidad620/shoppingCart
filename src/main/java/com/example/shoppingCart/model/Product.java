package com.example.shoppingCart.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "product")
public class Product {

        @Id
        @Transient
        public static final String SEQUENCE_NAME="Ordersequence";
        int id;

        String category;

        String colour;

        Double price;

        String brand;

        String Quantity;

}
