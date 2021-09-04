package ru.itis.technocrats_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.technocrats_test.dto.OrderDto;
import ru.itis.technocrats_test.service.OrderService;
import java.util.Arrays;
import java.util.List;


@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;



    @PostMapping(value = "api/order/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto order) {
        System.out.println(Arrays.toString(order.getProductList().toArray()));
        orderService.create(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "api/order/email", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<OrderDto>> getOrdersByEmail(@RequestParam String email) {
        return ResponseEntity.ok(orderService.getAllByEmail(email));
    }

    @GetMapping(value = "api/order/dates", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<OrderDto>> getOrdersBetweenDates(@RequestParam String date1,
                                                                @RequestParam String date2) {

        return ResponseEntity.ok(orderService.getAllOrdersBetweenDate(date1, date2));
    }

//    @GetMapping(value = "api/order/article", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<List<OrderDto>> getOrdersByArticle(@RequestParam String article) {
//        return ResponseEntity.ok(OrderDto.from(orderService.findAllByProductsContains(article)));
//    }
}
