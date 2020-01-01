package com.krzosa.todo.notes.models;

import com.krzosa.todo.login.User;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue
    private int id;
    private String note;
    private String color;
    @ManyToOne
    @JoinColumn
    private User user;

    public Note() {
    }
    public Note(String note, String color, User user) {
        this.note = note;
        this.color = color;
        this.user = user;
    }
    public Note(Integer id, String note, String color, User user) {
        this.id = id;
        this.note = note;
        this.color = color;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
