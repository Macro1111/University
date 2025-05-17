package com.globant.university.teachers;

import java.text.DecimalFormat;

public class FullTimeTeacher extends Teacher {
    private int yearsExperience;

    public FullTimeTeacher(String name, double baseSalary, int yearsExperience) {
        super(name, baseSalary);
        this.yearsExperience = yearsExperience;
    }


    @Override
    public double getSalary() {
        return baseSalary * (1.1 * yearsExperience);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "\nTeacher: "+ name + "\n" +
                "Years of experience: " + yearsExperience + "\n" +
                "Salary: $" + df.format(getSalary());
    }
}