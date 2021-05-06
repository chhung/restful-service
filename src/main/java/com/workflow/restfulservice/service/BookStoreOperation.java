package com.workflow.restfulservice.service;

import com.workflow.restfulservice.model.Book;

public interface BookStoreOperation {

    String listAllBooks();
    String queryBooksByTitile(String title);
    String queryBooks(Book condition);
    String deleteBooks(Integer bookId);
    String updateBooks(Integer bookId, Book condition);
}
