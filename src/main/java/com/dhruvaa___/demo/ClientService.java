package com.dhruvaa___.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public Client addClient(ClientDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setLawyers(dto.getLawyers());
        return repo.save(client);
    }

    public List<Client> getClient() {
        return repo.findAll();
    }

    public Client getClientById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Client updateClient(Long id,Client updated)
    {
        Client existing=repo.findById(id).orElse(null);
        if(existing!=null) {
            existing.setName(updated.getName());
            existing.setLawyers(updated.getLawyers());
            repo.save(existing);
        }
        return null;
    }

    public void deleteClient(@PathVariable Long cId)
    {
        repo.deleteById(cId);
        }
}