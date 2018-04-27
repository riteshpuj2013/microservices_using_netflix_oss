package com.globomart.controllers;

import com.globomart.exceptions.ResourceNotFoundException;
import com.globomart.models.Product;
import com.globomart.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/ps")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody @Valid Product product) {
        log.info("createProduct product {}", product);
        return productService.createProduct(product);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable("id") Long id) throws ResourceNotFoundException {
        log.info("getProduct id {}", id);
        return productService.getProduct(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable("id") Long id, @RequestBody @Valid Product product) throws ResourceNotFoundException {
        log.info("updateProduct id {} product {}", id, product);
        product.setId(id);
        productService.updateProduct(id, product);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id) throws ResourceNotFoundException {
        log.info("deleteProduct id {}", id);
        productService.deleteProduct(id);
    }

    @RequestMapping(value = "*", method = RequestMethod.GET)
    @ResponseBody
    public String getFallback() {
        return "Fallback for GET Requests";
    }
}
