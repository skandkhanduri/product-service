package com.secor.productservice.mapper;

import com.secor.productservice.dto.ProductDto;
import com.secor.productservice.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-24T00:44:58+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDTO(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setCreatedAt( entity.getCreatedAt() );
        productDto.setUpdatedAt( entity.getUpdatedAt() );
        productDto.setProductId( entity.getProductId() );
        productDto.setName( entity.getName() );
        productDto.setDescription( entity.getDescription() );
        productDto.setPrice( entity.getPrice() );

        return productDto;
    }

    @Override
    public List<ProductDto> toDTOList(List<Product> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( entity.size() );
        for ( Product product : entity ) {
            list.add( toDTO( product ) );
        }

        return list;
    }

    @Override
    public Product toEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( productDto.getProductId() );
        product.setName( productDto.getName() );
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );
        product.setCreatedAt( productDto.getCreatedAt() );
        product.setUpdatedAt( productDto.getUpdatedAt() );

        return product;
    }
}
