package ru.gb.SpringHW1;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

public class Student {

    private static long idCounter = 1L;

    private final long id;

    private String name;
    private String groupName;

    public Student(long id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }

    @JsonCreator
    public Student(String name, String groupName) {
        this.id = idCounter++;
        this.name = name;
        this.groupName = groupName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group='" + groupName + '\'' +
                '}';
    }
}
