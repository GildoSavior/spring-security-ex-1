package com.gildo.springsecex.controller;

import com.gildo.springsecex.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Alice", 85));
        students.add(new Student(2, "Bob", 90));
        students.add(new Student(3, "Charlie", 78));
        students.add(new Student(4, "David", 88));
        students.add(new Student(5, "Eve", 92));
        students.add(new Student(6, "Frank", 75));
        students.add(new Student(7, "Grace", 80));
        students.add(new Student(8, "Hannah", 95));
        students.add(new Student(9, "Ian", 70));
        students.add(new Student(10, "Jack", 82));
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(updatedStudent.getName());
            student.setMarks(updatedStudent.getMarks());
            return student;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return students.removeIf(student -> student.getId() == id) ? "Deleted successfully" : "Student not found";
    }
}
