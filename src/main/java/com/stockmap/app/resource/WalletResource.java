package com.stockmap.app.resource;

import com.stockmap.app.entities.Users;
import com.stockmap.app.entities.Wallet;
import com.stockmap.app.service.UserService;
import com.stockmap.app.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletResource {

    @Autowired
    private WalletService services;

    @PostMapping("/insert")
    public ResponseEntity<?> newWallet(@RequestBody Wallet obj){
        return services.insert(obj);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getWallet(){
        return services.getAll();
    }

    @GetMapping("/get/{cpfCnpj}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return services.getById(id);
    }

    @PutMapping("/up")
    public ResponseEntity<?> updateWallet(@RequestBody Wallet obj){
        return services.updateObj(obj);
    }

    @DeleteMapping("/del/{cpfCnpj}")
    public ResponseEntity<?> removeWallet(@PathVariable Long id){
        return services.deleteObj(id);
    }

}
