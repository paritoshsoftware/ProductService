package com.ecom.productservice.services;

import com.ecom.productservice.Inerface.IProductService;
import com.ecom.productservice.dto.FakeStoreProductDTO;
import com.ecom.productservice.models.Category;
import com.ecom.productservice.models.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class FakeStoreProductService implements IProductService {

    private final RestTemplate  restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {

    FakeStoreProductDTO fakeStoreProductDTO =  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
    return  modifyToProductInternal(Objects.requireNonNull(fakeStoreProductDTO));
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        ResponseEntity<List<FakeStoreProductDTO>> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        List<FakeStoreProductDTO> fakeStoreProducts = responseEntity.getBody();
        if (fakeStoreProducts != null) {
            for (FakeStoreProductDTO storeDTO : fakeStoreProducts) {
                products.add(modifyToProductInternal(storeDTO));
            }
        }
        return products;
    }

    private Product modifyToProductInternal( FakeStoreProductDTO fakeStoreProductDTO)
    {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setName(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImage(fakeStoreProductDTO.getImage());

        Category  category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());

        Random random = new Random();
        category.setId(random.nextLong(1,500));
        product.setCategory(category);
        return  product;
    }
}
