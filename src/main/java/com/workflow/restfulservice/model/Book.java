package com.workflow.restfulservice.model;

import java.math.BigDecimal;

public class Book {
    private Integer id;
    private String title;
    private BigDecimal price;
    private Integer quantity;

    public Book() {}
    
    public Book(Integer id, String title, BigDecimal price, Integer quantity) {
        super();
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "id:" + id + ",title:" + title + ",price:" + price + ",quantity:" + quantity;
    }
}
