package com.INTStore.EcommerceSiteWithSpring.application.service;

import com.INTStore.EcommerceSiteWithSpring.application.model.Product;
import com.INTStore.EcommerceSiteWithSpring.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;
    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }
    public Product getProduct(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public void deleteProduct(Long id)
    {
        productRepository.deleteById(id);
    }
}
