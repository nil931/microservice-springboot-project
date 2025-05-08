package com.ProductService.ProductServiceApplication.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "products")
public class Product implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
