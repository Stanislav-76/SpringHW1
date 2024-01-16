package ru.gb.SpringHW1;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable long id) {
        return repository.getById(id);
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return repository.getStudents();
    }

    @GetMapping("/student/search")
    public List<Student> getStudentByName(@RequestParam String name) {
        return repository.getByName(name);
    }

//    @RequestMapping(value = "/group/{groupName}/student", method = RequestMethod.GET)
    @GetMapping("/group/{groupName}/student")
    public List<Student> getStudentByGroup(@PathVariable String groupName) {
        return repository.getByGroupName(groupName);
    }

    @PostMapping("/student")
    public Student addStudent (@RequestBody Student student) {
        return repository.addStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable long id) {
        Student existsStudent = repository.getById(id);
        if (existsStudent == null) { // 404
            throw new IllegalArgumentException();
        }
        repository.deleteStudent(existsStudent);
    }

}
