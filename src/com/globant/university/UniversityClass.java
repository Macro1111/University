package com.globant.university;

import com.globant.university.teachers.Teacher;

import java.util.ArrayList;
import java.util.List;

public class UniversityClass {
    protected String className;
    protected Teacher teacher;
    protected Integer classRoom;
    protected List<Student> students = new ArrayList<>();


    public UniversityClass(String className, Integer classRoom, Teacher teacher, Student student) {
        this.className = className;
        this.classRoom = classRoom;
        this.teacher = teacher;
        addStudent(student);
    }

    public UniversityClass(String className, Integer classRoom, Teacher teacher, List<Student> students) {
        this.className = className;
        this.classRoom = classRoom;
        this.teacher = teacher;
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Integer getClassRoom() {
        return classRoom;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "\nClass Name: " + className + "\n" +
                "Classroom number: " + classRoom + "\n" +
                teacher + "\n" +
                "\nStudents: " + students;
    }
}
