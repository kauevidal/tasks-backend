package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.TaskBuilder;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController taskController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFailWhenDescriptionIsNull() throws ValidationException {

        Task task = new TaskBuilder()
                .id(1L)
                .description(null)
                .dueDate(LocalDate.now())
                .build();

        try {
            taskController.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void shouldFailWhenDateIsNull() throws ValidationException {

        Task task = new TaskBuilder()
                .id(1L)
                .description("task description")
                .dueDate(null)
                .build();
        try {
            taskController.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void shouldFailWhenPastDate() throws ValidationException {

        Task task = new TaskBuilder()
                .id(1L)
                .description("task description")
                .dueDate(LocalDate.now().minusDays(1))
                .build();

        try {
            taskController.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }
}