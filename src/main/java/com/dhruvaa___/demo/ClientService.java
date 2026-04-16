package com.dhruvaa___.demo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<Client> getClient(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Client getClientById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Client updateClient(Long id,ClientDTO updated)
    {
        Client existing=repo.findById(id).orElseThrow(
                ()-> new ClientNotFoundException("Client not found"+id)
        );
            existing.setName(updated.getName());
            existing.setLawyers(updated.getLawyers());
            return  repo.save(existing);
    }

    public void deleteClient(Long cId)
    {
        if(!repo.existsById(cId))
            throw new ClientNotFoundException("Client not found");
        repo.deleteById(cId);
        }
}