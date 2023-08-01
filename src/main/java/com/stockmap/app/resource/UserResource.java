package com.stockmap.app.resource;

import com.stockmap.app.entities.Users;
import com.stockmap.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService services;

    @PostMapping("/insert")
    public ResponseEntity<?> newUser(@RequestBody Users obj){
        return services.insert(obj);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUser(){
        return services.getAll();
    }

    @GetMapping("/get/{cpfCnpj}")
    public ResponseEntity<?> getByCpfCnpj(@PathVariable String cpfCnpj){
        return services.getByCpfCnpj(cpfCnpj);
    }

    @PutMapping("/up")
    public ResponseEntity<?> updateUser(@RequestBody Users obj){
        return services.updateObj(obj);
    }

    @DeleteMapping("/del/{cpfCnpj}")
    public ResponseEntity<?> removeUser(@PathVariable String cpfCnpj){
        return services.deleteObj(cpfCnpj);
    }

}
