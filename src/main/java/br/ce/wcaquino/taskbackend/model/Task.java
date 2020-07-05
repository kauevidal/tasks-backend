package br.ce.wcaquino.taskbackend.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {

    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate dueDate;

    public Task() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
