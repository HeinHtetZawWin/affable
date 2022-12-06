package com.example.exercise1.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_product")
public class OrderedProduct extends IdClass {

    private int quantity;

    @ManyToOne
    private CustomerOrder customerOrder;

    @ManyToOne
    private Product product;

    public OrderedProduct() {
    }

    public OrderedProduct(int quantity) {
        this.quantity = quantity;
    }
}
