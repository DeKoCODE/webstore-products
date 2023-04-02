package com.webstoreproducts.repository;

import com.webstoreproducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
