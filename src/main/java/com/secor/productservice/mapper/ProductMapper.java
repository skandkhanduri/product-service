package com.secor.productservice.mapper;

import com.secor.productservice.dto.ProductDto;
import com.secor.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto toDTO(Product entity);
    List<ProductDto> toDTOList( List<Product> entity);
    Product toEntity(ProductDto productDto);
}
