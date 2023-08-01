package com.stockmap.app.config;

import com.stockmap.app.entities.Users;
import com.stockmap.app.entities.Wallet;
import com.stockmap.app.entities.repositories.UserRepository;
import com.stockmap.app.entities.repositories.WalletRepository;
import com.stockmap.app.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.DecimalFormat;
import java.util.Arrays;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository urp;
    @Override
    public void run(String... args) throws Exception {
        DecimalFormat df = new DecimalFormat("#.##");


        Wallet w1 = new Wallet(null, "BOVESPA",23950.4,16.66,3,"BBDC4");
        Users u1 = new Users("111.111.111-11","Joao da Silva","joao.silva@gmail.com",w1);

        urp.save(u1);


    }
}
