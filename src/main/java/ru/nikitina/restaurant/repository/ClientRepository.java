package ru.nikitina.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitina.restaurant.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
