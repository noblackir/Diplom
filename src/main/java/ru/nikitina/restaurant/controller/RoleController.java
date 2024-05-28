package ru.nikitina.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikitina.restaurant.model.Role;
import ru.nikitina.restaurant.service.RoleService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/{title}")
    public ResponseEntity<Role> getRole(@PathVariable String title){
        return new ResponseEntity<>(roleService.findRole(title), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Role>> all(){
        return new ResponseEntity<>(roleService.all(), HttpStatus.OK);
    }
}
