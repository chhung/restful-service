package com.workflow.restfulservice.model;

public class BookRequest {
    private String timestamp;
    private Book condition;
    
    public String getTime() {
        return timestamp;
    }

    public void setTime(String time) {
        this.timestamp = time;
    }

    public Book getCondition() {
        return condition;
    }

    public void setCondition(Book condition) {
        this.condition = condition;
    }
}
