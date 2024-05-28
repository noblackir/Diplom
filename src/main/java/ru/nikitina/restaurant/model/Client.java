package ru.nikitina.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "id",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    List<Rating> ratings;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "patronymic")
    String patronymic;

    @Column(name = "number")
    String number;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;
}
