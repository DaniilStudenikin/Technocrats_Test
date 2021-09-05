package ru.itis.technocrats_test.service;

import ru.itis.technocrats_test.dto.OrderDto;
import ru.itis.technocrats_test.model.Order;


import java.time.LocalDate;

import java.util.List;


public interface OrderService {
    void create(OrderDto orderDto);
    List<OrderDto> getAllByEmail(String email);
    List<OrderDto> getAllOrdersBetweenDate(String date1, String date2);
    List<OrderDto> findProductsByArticle(String article);
}
