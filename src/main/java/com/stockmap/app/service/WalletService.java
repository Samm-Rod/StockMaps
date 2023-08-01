package com.stockmap.app.service;

import com.stockmap.app.entities.Message;
import com.stockmap.app.entities.Users;
import com.stockmap.app.entities.Wallet;
import com.stockmap.app.entities.repositories.UserRepository;
import com.stockmap.app.entities.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    private WalletRepository wrp;
    @Autowired
    private Message msg;

    public ResponseEntity<?> insert(Wallet obj){
        if(obj.getMediator().equals("")){
            msg.setMessagem("INVALID MEDIATOR!");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(wrp.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(wrp.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> getById(long id){
        if(id == 0){
            msg.setMessagem("NOT FOUND USER !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(wrp.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<?> updateObj(Wallet obj){
        if(obj.getId() == 0){
            msg.setMessagem("NOT FOUND ID !");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }else if(obj.getMediator().equals("")) {
            msg.setMessagem("INVALID MEDIATOR !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getBalance() == 0.0){
            msg.setMessagem("INVALID BALANCE !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getPrice() == 0.0){
            msg.setMessagem("INVALID PRICE !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getQuantity() == 0){
            msg.setMessagem("INVALID QUANTITY !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getName().equals("")){
            msg.setMessagem("INVALID NAME ASSETS !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getTotAssets() == 0.0){
            msg.setMessagem("INVALID TOTAL VALUE ASSETS !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(wrp.save(obj), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteObj(long id){
        Wallet obj = wrp.findById(id);
        if(obj == null){
            msg.setMessagem("NOT FOUND USER !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        wrp.delete(obj);
        msg.setMessagem("WALLET REMOVED !");
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }


}
