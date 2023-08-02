package com.stockmap.app.service;

import com.stockmap.app.entities.Assets;
import com.stockmap.app.entities.Message;
import com.stockmap.app.entities.repositories.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssetsService {

    @Autowired
    private AssetsRepository service;

    @Autowired
    private Message msg;


    // Total sum of user assets
    public ResponseEntity<?> totAssets(long id){
        if(service.countById(id) == 0){
            return ResponseEntity.notFound().build();
        }else{
            Assets value = service.findById(id);
            var sum = value.getPrice() * value.getQuantity();
            value.setTotAssets(sum);
            return ResponseEntity.ok().build();
        }
    }


}
