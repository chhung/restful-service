package com.workflow.restfulservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workflow.restfulservice.model.BookRequest;
import com.workflow.restfulservice.service.BookStoreService;

@RestController
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;
    
    @GetMapping("/listall")
    public String listAllBooks() {
        return bookStoreService.listAllBooks();
    }
    
    @GetMapping("/querybooktitle")
    public String queryBooksByTitile(@RequestParam(value="title", defaultValue="no") String title) {
        return bookStoreService.queryBooksByTitile(title);
    }
    
    @PostMapping("/querybook")
    public String queryBooks(@RequestBody BookRequest bookRequest) {
        return bookStoreService.queryBooks(bookRequest.getCondition());
    }
    
    @DeleteMapping("/delete/{bookId}")
    public String deleteBooks(@PathVariable Integer bookId) {
        return bookStoreService.deleteBooks(bookId);
    }
    
    @PutMapping("/update/{bookId}")
    public String updateBooks(@PathVariable Integer bookId, @RequestBody BookRequest bookRequest) {
        return bookStoreService.updateBooks(bookId, bookRequest.getCondition());
    }
}
