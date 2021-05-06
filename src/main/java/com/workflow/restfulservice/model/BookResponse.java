package com.workflow.restfulservice.model;

import java.time.LocalDateTime;
import java.util.List;

public class BookResponse<T> {
    private LocalDateTime time;
    private Integer status;
    private String message;
    private List<T> data;

    public BookResponse() {
        time = LocalDateTime.now();
    }
    
    public LocalDateTime getTime() {
        return time;
    }

    public BookResponse<T> setTime(LocalDateTime time) {
        this.time = time;
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
