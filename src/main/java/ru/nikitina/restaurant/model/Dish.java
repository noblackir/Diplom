package ru.nikitina.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Dish")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "dish")
public class Dish {
    @Id
    @Column(name = "id",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "dish")
    List<Basket> baskets;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    List<Rating> ratings;

    @Column(name = "title")
    String title;

    @Column(name = "cost")
    Double cost;

    @Column(name = "weight")
    Double weight;

    @Column(name = "calorie")
    Double calorie;

    @Column(name = "compound")
    String compound;
}
