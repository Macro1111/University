package com.globant.university;

public class Student implements Comparable<Student> {
    private static int idCounter = 0;

    private int id;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "\n" +
                "id: " + id +
                ", name: " + name +
                ", age: " + age;
    }

   @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
}
