package com.example.ecommercemanual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ecommercemanual.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
