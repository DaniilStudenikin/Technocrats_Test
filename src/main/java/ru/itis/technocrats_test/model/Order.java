package ru.itis.technocrats_test.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate createdOn;

    private String orderNo;

    private String email;

    @OneToMany()
    @JoinTable(name = "orders_products", joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")}
            , inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    @JoinColumn(name = "products_id")
    private List<Product> products;
}
