package com.workflow.restfulservice.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookResponse<T> {
    private String timestamp;
    private Integer status;
    private String message;
    private List<T> data;
    private static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    
    public BookResponse() {
        timestamp = LocalDateTime.now().format(formatter);
    }
    
    public String getTime() {
        return timestamp;
    }

    public BookResponse<T> setTime(String time) {
        this.timestamp = time;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public BookResponse<T> setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BookResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public BookResponse<T> setData(List<T> data) {
        this.data = data;
        return this;
    }
}
