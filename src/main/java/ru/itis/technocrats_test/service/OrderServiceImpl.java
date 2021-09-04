package ru.itis.technocrats_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.technocrats_test.dto.OrderDto;
import ru.itis.technocrats_test.dto.ProductDto;
import ru.itis.technocrats_test.model.Order;
import ru.itis.technocrats_test.model.Product;
import ru.itis.technocrats_test.repository.OrderRepository;
import ru.itis.technocrats_test.repository.ProductRepository;

import static ru.itis.technocrats_test.dto.ProductDto.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void create(OrderDto orderDto) {
        LocalDate time = LocalDate.now();
        List<Product> productsFromDbList = new ArrayList<>();
        for (ProductDto product : orderDto.getProductList()) {
            productsFromDbList.add(productRepository.getProductByName(product.getName())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found!")));
        }
        Order order = Order.builder()
                .email(orderDto.getEmail())
                .createdOn(time)
                .orderNo(String.valueOf(Math.abs(time.hashCode())))
                .products(productsFromDbList)
                .build();
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getAllByEmail(String email) {
        return OrderDto.from(orderRepository.findAllByEmail(email));
    }

    @Override
    public List<OrderDto> getAllOrdersBetweenDate(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.ROOT );
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);
        return OrderDto.from(orderRepository.findAllByCreatedOnBetween(localDate1, localDate2));
    }

//    @Override
//    public List<Order> findAllByProductsContains(String article) {
//        return orderRepository.findAllByOrderAndProductsContains(article);
//    }
}
