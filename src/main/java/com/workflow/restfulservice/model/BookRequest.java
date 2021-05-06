package com.workflow.restfulservice.model;

import java.time.LocalDateTime;

public class BookRequest {
    private LocalDateTime time;
    private Book condition;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Book getCondition() {
        return condition;
    }

    public void setCondition(Book condition) {
        this.condition = condition;
    }
}
