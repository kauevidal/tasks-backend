package br.ce.wcaquino.taskbackend.utils;

import br.ce.wcaquino.taskbackend.model.Task;

import java.time.LocalDate;

public class TaskBuilder {

    private Task task;

    public TaskBuilder() {
        task = new Task();
    }

    public TaskBuilder id(Long id) {
        task.setId(id);
        return this;
    }

    public TaskBuilder description(String description) {
        task.setDescription(description);
        return this;
    }

    public TaskBuilder dueDate(LocalDate dueDate) {
        task.setDueDate(dueDate);
        return this;
    }

    public Task build() {
        return task;
    }
}
