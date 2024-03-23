package com.ecom.productservice.Inerface;

import com.ecom.productservice.models.Product;

import java.util.List;

public interface IProductService {

      Product getProductById(Long id);
      List<Product> getProducts();

}
