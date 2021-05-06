package com.workflow.restfulservice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookStoreDB {
    private List<Book> stock;
    
    public BookStoreDB() {
        stock = new ArrayList<>();
        stock.add(new Book(1, "Six-Way Paragraphs: Introductory Level", new BigDecimal(380.0), 23));
        stock.add(new Book(2, "Why We Sleep: Unlocking the Power of Sleep and Dreams", new BigDecimal(630.0), 17));
        stock.add(new Book(3, "Invent and Wander: The Collected Writings of Jeff Bezos, With an Introduction by Walter Isaacson", new BigDecimal(980.0), 5));
        stock.add(new Book(4, "Charlotte’s Web", new BigDecimal(160.0), 60));
        stock.add(new Book(5, "The Complete Sherlock Holmes: All 4 Novels and 56 Short Stories", new BigDecimal(487.0), 25));
    }

    public List<Book> getStock() {
        return stock;
    }
}
