package com.stockmap.app.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_wallet")
public class Wallet implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mediator;
    private Double balance;
    private Double price;
    private Integer quantity;
    private String name;
    private Double totAssets;
    @ManyToMany
    @JoinTable(name = "wallet_assets",
    joinColumns = {@JoinColumn(name = "wallet_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "assets_id")})
    private List<Assets> assets;

    @OneToOne(mappedBy = "wallets")
    private Users users;

    public Wallet() {
    }

    public Wallet(Long id, String mediator, Double balance, Double price, Integer quantity, String name) {
        this.id = id;
        this.mediator = mediator;
        this.balance = balance;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.totAssets = Double.valueOf(totalAsset());  // O atributo recebe o metodo Double totalAsset();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMediator() {
        return mediator;
    }

    public void setMediator(String mediator) {
        this.mediator = mediator;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotAssets() {
        return totAssets;
    }

    // Esse é o metodo totalAsset() que faz o calculo e já manda para o banco de dados
    private String totalAsset(){
        DecimalFormat df = new DecimalFormat("0.00");
        totAssets = price * quantity;
        return df.format(totAssets);
    }

    public void setTotAssets(Double totAssets) {
        this.totAssets = totAssets;
    }



    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
