package ru.itis.technocrats_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.technocrats_test.model.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> getProductByName(String name);
}
