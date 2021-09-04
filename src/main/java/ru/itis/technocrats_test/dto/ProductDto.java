package ru.itis.technocrats_test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.technocrats_test.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String article;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .article(product.getArticle())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public static List<ProductDto> from(List<Product> products) {
        return products.stream().map(ProductDto::from).collect(Collectors.toList());
    }
}
