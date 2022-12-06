package com.example.exercise1.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer_order")
public class CustomerOrder extends IdClass {

    private double amount;
    private LocalDate date_created;
    private int confirmation_number;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.PERSIST)
    private List<OrderedProduct> orderedProducts = new ArrayList<>();

    public CustomerOrder() {
    }

    public CustomerOrder(double amount, LocalDate date_created, int confirmation_number) {
        this.amount = amount;
        this.date_created = date_created;
        this.confirmation_number = confirmation_number;
    }

    public void addOrderedProduct(OrderedProduct orderedProduct) {
        orderedProduct.setCustomerOrder(this);
        this.orderedProducts.add(orderedProduct);
    }
}
