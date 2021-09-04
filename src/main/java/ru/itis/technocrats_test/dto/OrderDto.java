package ru.itis.technocrats_test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.technocrats_test.model.Order;
import ru.itis.technocrats_test.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String email;
    private List<ProductDto> productList;

    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .email(order.getEmail())
                .productList(ProductDto.from(order.getProducts()))
                .build();
    }

    public static List<OrderDto> from(List<Order> order) {
        return order.stream().map(OrderDto::from).collect(Collectors.toList());
    }
}
