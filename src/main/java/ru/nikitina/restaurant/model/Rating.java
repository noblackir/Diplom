package ru.nikitina.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rating")
public class Rating {
    @Id
    @Column(name = "id",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    Dish dish;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @Column(name = "grade")
    Long grade;

    @Column(name = "comment")
    String comment;
}
