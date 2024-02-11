package com.springmvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @Column(name = "quiz_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "quiz", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private Course course;

    public Quiz() {
    }

    public Quiz(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
