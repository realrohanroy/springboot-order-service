package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.enums.OrderStatus;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @CreationTimestamp
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order(){

    }


    public int getId() {
        return id;
    }
    
    
    public void setId(int id){
        this.id= id;
    }
    
    public OrderStatus getStatus(){
        return status;
    }
    
    public void setStatus(OrderStatus status){
        this.status = status;
    }
}
    
    
