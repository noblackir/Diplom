package ru.nikitina.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.nikitina.restaurant.model.Client;
import ru.nikitina.restaurant.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    RoleService roleService;
    @Autowired
    @Lazy
    OrderService orderService;

    public Client save(Client client) {
        Client client1 = clientRepository.save(client);
        orderService.firstBasket(client1);
        return client1;
    }

    public Client getClient(Long id) {
        return clientRepository.findById(id).get();
    }

    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    public Client setRole(String role, Long id) {
        Client client = clientRepository.findById(id).get();
        client.setRole(roleService.findRole(role));
        return clientRepository.save(client);
    }
}
