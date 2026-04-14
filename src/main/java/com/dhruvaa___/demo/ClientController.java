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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {
    public final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClient() {
        return ResponseEntity.ok(service.getClient());
    }

    @GetMapping("/{cId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long cId) {
        Client client=service.getClientById(cId);
        if (client==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@Valid @RequestBody ClientDTO dto)
    {
        Client client=service.addClient(dto);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
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
