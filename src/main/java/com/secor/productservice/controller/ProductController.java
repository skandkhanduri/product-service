package com.secor.productservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.secor.productservice.ProductService;
import com.secor.productservice.dto.ProductDto;
import com.secor.productservice.entity.Product;
import com.secor.productservice.mapper.ProductMapper;
import com.secor.productservice.service.ProductServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/v1")
public class ProductController {


    private ProductServices productServices;
    ProductController(ProductServices productServices)
    {
        this.productServices=productServices;
    }
    @GetMapping("/all")
    public ResponseEntity<Object> getAllProducts()
    {
  List<Product> product=productServices.getAllProduct();
        List<ProductDto> responseDto= ProductMapper.INSTANCE.toDTOList(product);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/getProduct")
    public ResponseEntity<Object> getProductByID(@RequestParam("productId") Long productId
                                             ) throws JsonProcessingException {
      Product product=  productServices.getProductById(productId).get();
      ProductDto responseDto=ProductMapper.INSTANCE.toDTO(product);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        Product createdProduct = productServices.createProduct(product);
        ProductDto responseDto=ProductMapper.INSTANCE.toDTO(createdProduct);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Object> updateProduct( @RequestBody Product product) {
        Product updatedProduct = productServices.updateProduct(product);
        ProductDto responseDto=ProductMapper.INSTANCE.toDTO(updatedProduct);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<Void> deleteProduct(@RequestParam("productId") Long productId) {
        productServices.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

}
