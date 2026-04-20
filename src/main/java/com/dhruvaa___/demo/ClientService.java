package com.dhruvaa___.demo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;


@Service
public class ClientService {

    private final ClientRepository repo;
    private final UserRepository userRepository;

    public ClientService(ClientRepository repo , UserRepository userRepository) {
        this.repo = repo;
        this.userRepository = userRepository;
    }

    public Client addClient(ClientDTO dto) {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username);
        Client client = new Client();
        client.setName(dto.getName());
        client.setLawyers(dto.getLawyers());
        System.out.println("Username: " + username);
        System.out.println("User: " + user);
        System.out.println("Saving client...");
        client.setUser(user);
        return repo.save(client);
    }

    public Page<ResponseDTO> getClient(Pageable pageable) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        User user = userRepository.findByUsername(username);
        return repo.findByUser(user, pageable).map(this::toDTO);
    }

    public Client getClientById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Client updateClient(Long id,ClientDTO updated)
    {
        Client existing=repo.findById(id).orElseThrow(
                ()-> new AppException("Client not found"+id)
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

        public ResponseDTO toDTO(Client client)
        {
            ResponseDTO dto=new ResponseDTO();
            dto.setId(client.getcId());
            dto.setName(client.getName());
            dto.setLawyers(client.getLawyers());
            return dto;
        }
}