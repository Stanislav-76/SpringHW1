package ru.gb.SpringHW1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Igor","FrontDeveloper"));
        students.add(new Student("Vladislav","BackendDeveloper"));
        students.add(new Student("Petr","FrontDeveloper"));
        students.add(new Student("Vladimir","BackendDeveloper"));
        students.add(new Student("Alex","FrontDeveloper"));
        students.add(new Student("Ivan","FrontDeveloper"));
        students.add(new Student("Mihail","BackendDeveloper"));
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getByName(String name) {
        return students.stream()
                .filter(it -> it.getName().contains(name))
                .toList();
    }

    public List<Student> getByGroupName(String groupName) {
        return students.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName))
                .toList();
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }


}
