package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long cbu;
    private String type;
    private Double amount;

    public Transaction(){}

    public Transaction(Long cbu, String type, Double amount){
        this.cbu = cbu;
        this.amount = amount;
        this.type = type;
    }
    public Long getId(){return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCbu(){return cbu; }
    public void setCbu(Long cbu) { this.cbu = cbu; }
    public String getType(){return type; }

    public void setType(String type) {this.type = type; }

    public Double getAmount(){return amount; }

    public void setAmount(Double amount) {this.amount = amount; }
}


