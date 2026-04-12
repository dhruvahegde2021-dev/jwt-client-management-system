//Postman
//   ↓
//@RequestBody (JSON → Java)
//   ↓
//Controller
//   ↓
//Service
//   ↓
//Repository (JPA)
//   ↓
//Hibernate
//   ↓
//PostgreSQL
package com.dhruvaa___.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    public final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Client> getClient() {
        return service.getClient();
    }

    @GetMapping("/{cId}")
    public Client getClientById(@PathVariable Long cId) {
        return service.getClientById(cId);
    }

    @PostMapping
    public String addClient(@RequestBody ClientDTO dto)
    {
        this.service.addClient(dto);
        return "Client added";
    }

    @PutMapping("/{cId}")
    public Client updateClient(@PathVariable Long cId,@RequestBody Client client)
    {
        return service.updateClient(cId,client);
    }

    @DeleteMapping("/{cId}")
    public String deleteClient(@PathVariable Long cId)
    {
        service.deleteClient(cId);
        return "Client deleted";
    }
}
