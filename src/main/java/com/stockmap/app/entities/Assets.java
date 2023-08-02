package com.stockmap.app.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_assets")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Integer quantity;
    private Double price;
    private Double totAssets;
    @ManyToMany(mappedBy = "assets")
    private List<Wallet> wallets;

    
    public Assets(){

    }

    public Assets(Long id, String name, Integer quantity, Double price, Double totAssets) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totAssets = totAssets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotAssets() {
        return totAssets;
    }

    public void setTotAssets(Double totAssets) {
        this.totAssets = totAssets;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }
}
