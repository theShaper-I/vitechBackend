package com.hrybanov.spring.springboot.spring_vitech.entities;

import javax.persistence.*;

@Entity
@Table (name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String commentText;

    @Column(name = "data")
    private String data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Comment() {
    }

    public Comment(String commentText, String data) {
        this.commentText = commentText;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", commentText='" + commentText + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
