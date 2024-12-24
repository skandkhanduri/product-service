package com.secor.productservice.service;

import com.secor.productservice.entity.Product;
import com.secor.productservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
     ProductRepository productRepository;
    ProductServices(ProductRepository productRepository)
    {
     this.productRepository=productRepository;
    }
    public List<Product> getAllProduct()

    {

        return productRepository.findAll();
    }

    public Optional <Product> getProductById(Long id)

    {
        Optional<Product> product=productRepository.findById(id);
        if (product.isPresent())
        {
            return product;
        }
        else {
            throw new EntityNotFoundException("Product with id " + id + " not found");
        }
    }

    public Product createProduct(Product product)
    {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        Product savedProduct= productRepository.save(product);
       return savedProduct;
    }
    public Product updateProduct(Product productDetails)
    {
        Optional<Product> optionalProduct=productRepository.findById(productDetails.getProductId());
        if (optionalProduct.isPresent())
        {
            productDetails.setCreatedAt(optionalProduct.get().getCreatedAt());
            productDetails.setUpdatedAt(LocalDateTime.now());
            return productRepository.save(productDetails);
        }
        else {
            throw new EntityNotFoundException("Product with id " + productDetails.getProductId() + " not found");
        }
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
