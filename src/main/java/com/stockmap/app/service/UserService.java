package com.stockmap.app.service;

import com.stockmap.app.entities.Message;
import com.stockmap.app.entities.Users;
import com.stockmap.app.entities.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository urp;
    @Autowired
    private Message msg;

    public ResponseEntity<?> insert(Users obj){
        if(obj.getCpfCnpj().equals("")){
            msg.setMessagem("INVALID CPF/CNPJ !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getName().equals("")){
            msg.setMessagem("INVALID NAME !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getEmail().equals("")){
            msg.setMessagem("INVALID EMAIL !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(urp.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(urp.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> getByCpfCnpj(String cpf){
        Users user = urp.findByCpfCnpj(cpf);
        if(user == null){
            msg.setMessagem("NOT FOUND USER !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    public ResponseEntity<?> updateObj(Users obj){
        Users user = urp.findByCpfCnpj(obj.getCpfCnpj());
        if(user == null){
            msg.setMessagem("NOT FOUND CPF/CNPJ !");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }else if(obj.getName().equals("")){
            msg.setMessagem("INVALID NAME !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getEmail().equals("")){
            msg.setMessagem("INVALID EMAIL !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(urp.save(obj), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteObj(String cpf){
        Users user = urp.findByCpfCnpj(cpf);
        if(user == null){
            msg.setMessagem("NOT FOUND USER !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        urp.delete(user);
        msg.setMessagem("USER REMOVED !");
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }


}
