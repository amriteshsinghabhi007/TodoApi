package com.ads.todos.todos_manager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Todo {
    private int id;
    private String title;
    private String content;
    private String status;
    private Date addedDate;
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    private Date newDate;

    public int getId() {
        return this.id;
    }

    public Todo(int id, String title, String content, String status, Date addedDate, Date newDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addedDate = addedDate;
        this.newDate = newDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddedDate() {
        return this.addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getNewDate() {
        return this.newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public String toString() {
        int var10000 = this.id;
        return "Todo{id=" + var10000 + ", title='" + this.title + "', content='" + this.content + "', status='" + this.status + "', addedDate=" + String.valueOf(this.addedDate) + ", newDate=" + String.valueOf(this.newDate) + "}";
    }
}
