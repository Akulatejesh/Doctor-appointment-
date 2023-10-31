package com.example.demo.repositories;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.example.demo.model.Product;
 
@Repository
public interface ProductRepositoty extends CrudRepository<Product, Integer>{
 
}