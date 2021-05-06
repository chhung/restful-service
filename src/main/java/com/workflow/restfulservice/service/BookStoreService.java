package com.workflow.restfulservice.service;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.workflow.restfulservice.model.Book;
import com.workflow.restfulservice.model.BookResponse;
import com.workflow.restfulservice.model.BookStoreDB;

@Service
public class BookStoreService implements BookStoreOperation {
    @Autowired
    BookStoreDB bsDB;
    
    @Autowired
    Gson gson;

    @Override
    public String listAllBooks() {
        BookResponse<Book> response = new BookResponse<>();
        response.setData(bsDB.getStock()).setMessage("OK").setStatus(1);
        return gson.toJson(response);
    }

    @Override
    public String queryBooksByTitile(String title) {
        List<Book> result = bsDB.getStock().stream().filter(x -> x.getTitle().equals(title))
                                .collect(Collectors.toList());
        BookResponse<Book> response = new BookResponse<>();
        response.setData(result).setMessage("OK").setStatus(25);
        return gson.toJson(response);
    }

    @Override
    public String queryBooks(Book condition) {
        BookResponse<Book> response = new BookResponse<>();
        
        if (Objects.isNull(condition)) {
            response.setMessage("Searching condition is null!").setStatus(99);
            return gson.toJson(response);
        }
        
        response.setData(combinationQuery(condition)).setMessage("OK").setStatus(1117);
        return gson.toJson(response);
    }

    @Override
    public String deleteBooks(Integer bookId) {
        BookResponse<Book> response = new BookResponse<>();
        
        List<Book> result = bsDB.getStock().stream().filter(x -> x.getId() == bookId)
                .collect(Collectors.toList());
        bsDB.getStock().removeAll(result);
        response.setData(result).setMessage("Remove list books.").setStatus(1117);
        return gson.toJson(response);
    }

    @Override
    public String updateBooks(Integer bookId, Book condition) {
        BookResponse<Book> response = new BookResponse<>();
        
        bsDB.getStock().forEach(x -> {
            if (x.getId() == bookId) {
                updateContent(x, condition);
            }
        });
        response.setData(bsDB.getStock()).setMessage("update list books.").setStatus(1117);
        return gson.toJson(response);
    }

    private void updateContent(Book x, Book condition) {
        if (!Objects.isNull(condition.getPrice()))
            x.setPrice(condition.getPrice());
        
        if (!Objects.isNull(condition.getQuantity()))
            x.setQuantity(condition.getQuantity());
        
        if (!Objects.isNull(condition.getTitle()))
            x.setTitle(condition.getTitle());
    }
    
    private List<Book> combinationQuery(Book condition) {
        List<Book> result = bsDB.getStock(); 
        if (!Objects.isNull(condition.getId())) {
            result = result.stream().filter(x -> x.getId() == condition.getId()).collect(Collectors.toList());
            System.out.println("has ID result:");
            result.forEach(System.out::println);
        }
        
        if (!Objects.isNull(condition.getTitle())) {
            result = result.stream().filter(x -> x.getTitle().equals(condition.getTitle())).collect(Collectors.toList());
            System.out.println("has title result:");
            result.forEach(System.out::println);
        }
        
        if (!Objects.isNull(condition.getPrice())) {
            result = result.stream().filter(x -> x.getPrice().compareTo(condition.getPrice()) == 0).collect(Collectors.toList());
            System.out.println("has price result:");
            result.forEach(System.out::println);
        }
        
        if (!Objects.isNull(condition.getQuantity())) {
            result = result.stream().filter(x -> x.getQuantity() == condition.getQuantity()).collect(Collectors.toList());
            System.out.println("has quantity result:");
            result.forEach(System.out::println);
        }
        
        return result;
    }
}
