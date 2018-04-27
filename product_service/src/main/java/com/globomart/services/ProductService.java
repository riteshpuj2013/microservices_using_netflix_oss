package com.globomart.services;

import com.globomart.exceptions.ResourceNotFoundException;
import com.globomart.models.Product;
import com.globomart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long id) throws ResourceNotFoundException {
        Product product = productRepository.findOne(id);
        if (product == null) {
            throw new ResourceNotFoundException(Product.class, "id", id.toString());
        }
        return product;
    }

    public void updateProduct(Long id, Product product) throws ResourceNotFoundException {
        checkResourceFound(id);
        productRepository.save(product);
    }

    public void deleteProduct(Long id) throws ResourceNotFoundException {
        checkResourceFound(id);
        productRepository.delete(id);
    }

    private void checkResourceFound(Long id) throws ResourceNotFoundException {
        if (!productRepository.exists(id)) {
            throw new ResourceNotFoundException(Product.class, "id", id.toString());
        }
    }
}
