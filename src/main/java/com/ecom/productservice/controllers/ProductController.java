package com.ecom.productservice.controllers;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.services.FakeStoreProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final FakeStoreProductService productService;
    public ProductController(FakeStoreProductService _productService) {
        this.productService = _productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id)
    {
        return  productService.getProductById(id);
    }

    @GetMapping("/")
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }
}
