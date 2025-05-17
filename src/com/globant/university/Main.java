package com.globant.university;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Campus campus = new Campus();

        while (true) {
            System.out.println("\n===== University System Menu =====");
            System.out.println("1. Show all teachers");
            System.out.println("2. Show all classes");
            System.out.println("3. Create a new student and add to an existing class");
            System.out.println("4. Create a new class and assign existing teacher and students");
            System.out.println("5. Search classes by student ID");
            System.out.println("0. Exit");
            System.out.print("\nPlease choose an option: ");

            int option = keyboard.nextInt();
            keyboard.nextLine();

            switch (option) {
                case 1 -> campus.printTeachers();
                case 2 -> campus.printClases();
                case 3 -> campus.createStudentAddToClass();
                case 4 -> campus.createClass();
                case 5 -> campus.findClassesByStudentId();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
