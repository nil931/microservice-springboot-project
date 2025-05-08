package com.ProductService.ProductServiceApplication.repository;

import com.ProductService.ProductServiceApplication.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product,String > {
}
