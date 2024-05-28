package ru.nikitina.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitina.restaurant.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByTitle(String title);
}
