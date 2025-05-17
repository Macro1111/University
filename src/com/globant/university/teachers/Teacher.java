package com.globant.university.teachers;

public abstract class Teacher {
    protected String name;
    protected double baseSalary;
    protected Double salary;

    public Teacher(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract public double getSalary();

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getName() {
        return name;
    }
}