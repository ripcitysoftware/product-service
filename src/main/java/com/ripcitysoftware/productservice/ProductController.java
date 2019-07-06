package com.ripcitysoftware.productservice;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Optional;

@RestController
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    @CrossOrigin
    @ResponseBody
    public Optional<Product> getProduct(@PathVariable("id") Long id) {
        log.info("/products/{} invoked!", id);
        return productService.findProduct(id);
    }
}
