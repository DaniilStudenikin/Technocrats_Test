package ru.itis.technocrats_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.technocrats_test.model.Order;
import ru.itis.technocrats_test.model.Product;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByEmail(String email);

    List<Order> findAllByCreatedOnBetween(LocalDate createdOn, LocalDate createdOn2);

    List<Order> findOrdersByProductsIn(List<Product> products);
}
