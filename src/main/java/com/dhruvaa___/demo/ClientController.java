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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {
    public final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Map<String,Object>> getClient(Pageable pageable) {
        Page<Client> page=service.getClient(pageable);
        Map<String,Object> response=new HashMap<>();
        response.put("data",page.getContent());
        response.put("Total pages:",page.getTotalPages());
        response.put("Total elements:",page.getTotalElements());

        return ResponseEntity.ok(response);
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
    public Client updateClient(@PathVariable Long cId,@Valid @RequestBody ClientDTO dto1)
    {
        return service.updateClient(cId,dto1);
    }

    @DeleteMapping("/{cId}")
    public ResponseEntity<String> deleteClient(@PathVariable Long cId)
    {
        service.deleteClient(cId);
        return ResponseEntity.ok("Client deleted");
    }
}
