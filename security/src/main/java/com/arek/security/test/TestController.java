package com.arek.security.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/management")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    private static final List<Student> STUDENTS = List.of(
            new Student(1, "Batman"),
            new Student(2, "Deadpool"),
            new Student(3, "Wolverine")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody final Student student) {
        LOGGER.info(student.toString());
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable("id") final int id) {
        LOGGER.info("deleted student with id {}", id);
    }

    @PutMapping(path = "/{id}")
    public void updateStudent(@PathVariable("id") final int id,
            @RequestBody final Student student) {
        LOGGER.info("updated student {} wit {}", id, student.toString());
    }
}
