package com.INTStore.EcommerceSiteWithSpring.application.repository;

import com.INTStore.EcommerceSiteWithSpring.application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
