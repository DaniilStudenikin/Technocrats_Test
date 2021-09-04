package ru.itis.technocrats_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.technocrats_test.dto.ProductDto;
import ru.itis.technocrats_test.model.Product;
import ru.itis.technocrats_test.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void create(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .isDeleted(false)
                .article(productDto.getName().toUpperCase().charAt(0) + "-" +
                        Math.abs((productDto.getName() + productDto.getPrice()).hashCode()))
                .price(productDto.getPrice())
                .build();
        productRepository.save(product);
    }
}
