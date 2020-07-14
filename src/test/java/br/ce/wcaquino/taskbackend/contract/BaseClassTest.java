package br.ce.wcaquino.taskbackend.contract;

import br.ce.wcaquino.taskbackend.controller.TaskController;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.TaskBuilder;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseClassTest {

    @Autowired
    private TaskController taskController;

    @MockBean
    private TaskRepo taskRepo;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(context);

        when(taskRepo.findAll()).thenReturn(Arrays.asList(createTask()));
        when(taskRepo.save(any())).thenReturn(createTask());
    }

    private Task createTask() {
        return new TaskBuilder()
                .id(1L)
                .description("task 1")
                .dueDate(LocalDate.of(2025, 1, 1))
                .build();
    }
}
