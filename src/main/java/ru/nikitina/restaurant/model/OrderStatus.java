package ru.nikitina.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "OrderStatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orderStatus")
public class OrderStatus {
    @Id
    @Column(name = "id",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "orderStatus")
    List<Order> orders;

    @Column(name = "title")
    String title;
}
