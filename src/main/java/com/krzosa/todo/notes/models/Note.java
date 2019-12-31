package com.krzosa.todo.notes.models;

import com.krzosa.todo.notes.login.User;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue
    private int id;
    private String note;
    private String color;
    @ManyToOne
    private User user;

    public Note() {
    }
    public Note(String note, String color, User user) {
        this.note = note;
        this.color = color;
        this.user = user;
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
