package com.globant.university.teachers;

import java.text.DecimalFormat;

public class PartTimeTeacher extends Teacher {
    private int activeHoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, int activeHoursPerWeek) {
        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }


    @Override
    public double getSalary() {
        return baseSalary * activeHoursPerWeek;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "\nTeacher: "+ name + "\n" +
                "Hours of the week: " + activeHoursPerWeek + "\n" +
                "Salary: $" + df.format(getSalary());
        }
    }

