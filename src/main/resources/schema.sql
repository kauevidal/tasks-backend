--drop table IF EXISTS task;

CREATE TABLE task (
    id INT AUTO_INCREMENT,
    description VARCHAR(256) NOT NULL,
    due_date DATE,
    PRIMARY KEY (id)
);
