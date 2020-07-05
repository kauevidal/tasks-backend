package br.ce.wcaquino.taskbackend.api;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TaskControllerTest {

    @Test
    @Sql(scripts = {"/insert-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"/clean-database.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void shouldFindWithSuccess() {
        given()
                .when()
                .get("/todo")
                .then()
                .statusCode(200)
                .body("description", hasItem("db task 1"))
                .body("dueDate", hasItem("2025-07-01"));
    }

    @Test
    @Sql(scripts = {"/clean-database.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void shouldSaveWithSuccess() {
        given()
                .body("{ \"description\": \"Test task 1\", \"dueDate\": \"2032-01-01\" }")
                .contentType(ContentType.JSON)
                .when()
                .post("/todo")
                .then()
                .statusCode(201);
    }

    @Test
    public void shouldReturnInvalidDate() {
        given()
                .body("{ \"description\": \"Test task 1\", \"dueDate\": \"2018-01-01\" }")
                .contentType(ContentType.JSON)
                .when()
                .post("/todo")
                .then()
                .statusCode(400)
                .body("message", is("Due date must not be in past"));
    }
}
