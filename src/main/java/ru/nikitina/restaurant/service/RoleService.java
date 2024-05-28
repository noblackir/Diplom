package ru.nikitina.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitina.restaurant.model.Role;
import ru.nikitina.restaurant.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public Role findRole(String title) {
        return roleRepository.findByTitle(title);
    }

    public List<Role> all() {
        return (List<Role>) roleRepository.findAll();
    }
}
