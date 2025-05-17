package com.globant.university;

import com.globant.university.teachers.FullTimeTeacher;
import com.globant.university.teachers.PartTimeTeacher;
import com.globant.university.teachers.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Campus {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<UniversityClass> classes;

    Scanner keyboard = new Scanner(System.in);

    public Campus() {
        initializeTeachers();
        initializeStudents();
        initializeClasses();
    }

    private void initializeTeachers() {
        teachers = new ArrayList<>();
        teachers.add(new FullTimeTeacher("Olaf Stapledon", 1000, 3));
        teachers.add(new FullTimeTeacher("Mary Shelley", 1000, 6));
        teachers.add(new PartTimeTeacher("William Gibson", 20, 36));
        teachers.add(new PartTimeTeacher("Bruce Sterling", 20, 40));
    }

    private void initializeStudents() {
        students = new ArrayList<>();
        students.add(new Student("Rick Deckard", 17));
        students.add(new Student("Roy Batty", 20));
        students.add(new Student("Motoko Kusanagi", 18));
        students.add(new Student("Tetsuo Shima", 19));
        students.add(new Student("Kaneda Shotaro", 20));
        students.add(new Student("Thomas Anderson", 17));
        Collections.sort(students);
    }

    private void initializeClasses() {
        classes = new ArrayList<>();
        UniversityClass uClass = new UniversityClass("Fundamentals of Computer Programming I", 101, teachers.getFirst(), students.get(0));
        uClass.addStudent(students.get(1));
        uClass.addStudent(students.get(3));
        classes.add(uClass);
        UniversityClass uClass1 = new UniversityClass("Design and Analysis of Data Structures and Algorithms", 102, teachers.get(1), students.get(1));
        uClass1.addStudent(students.get(2));
        uClass1.addStudent(students.get(4));
        classes.add(uClass1);
        UniversityClass uClass2 = new UniversityClass("Software Testing and Quality Assurance", 103, teachers.get(2), students.get(3));
        uClass2.addStudent(students.get(5));
        uClass2.addStudent(students.get(1));
        classes.add(uClass2);
        UniversityClass uClass3 = new UniversityClass("Database Systems", 104, teachers.get(3), students.get(5));
        uClass3.addStudent(students.get(2));
        uClass3.addStudent(students.get(0));
        classes.add(uClass3);
    }

    public void printTeachers(){
        for(Teacher teacher: teachers){
            System.out.println(teacher);
        }
    }

    public void printClases(){
        System.out.println("\nThis is a list of all the classes that are available:\n");

        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i+1) + ". " + classes.get(i).getClassName());
        }
        System.out.print("\nPick the option for the class you’d like to learn more about: ");
        int option = keyboard.nextInt()-1;
        keyboard.nextLine();

        if(option >= 0 && option < classes.size()){
            System.out.println(classes.get(option));
        }else {
            System.out.println("Invalid option");
        }
    }

    public void createStudentAddToClass(){
        while (true){
            System.out.print("\nStudent creation:\n"
                    + "Please enter the student's name: ");
            String studentName = keyboard.nextLine();
            System.out.print("Please enter the student's age: ");
            int studentAge = keyboard.nextInt();
            keyboard.nextLine();
            System.out.print("\nIs the information correct?\n" +
                    "Student name: " + studentName + " Age: " + studentAge + "\n" +
                    "Please confirm with a Yes/No: ");
            String answer = keyboard.nextLine();
            if(answer.equalsIgnoreCase("yes")){
                if(studentAge>0){
                    Student newStudent = new Student(studentName,studentAge);
                    students.add(newStudent);
                    System.out.println("You successfully created the student " + studentName +", with ID number " + newStudent.getId());
                    while (true){
                        System.out.println("\nThis is a list of all the courses available for student enrollment:\n");
                        for (int i = 0; i < classes.size(); i++) {
                            System.out.println((i+1) + ". " + classes.get(i).getClassName());
                        }
                        System.out.print("\nPlease select the course option in which you would like to enroll the student: ");
                        int option = keyboard.nextInt()-1;
                        keyboard.nextLine();
                        if(option >= 0 && option < classes.size()){
                            UniversityClass chosenClass = classes.get(option);
                            chosenClass.addStudent(newStudent);
                            System.out.println(studentName + " has been successfully enrolled in – " + chosenClass.getClassName());
                            return;
                        }else {
                            System.out.println("Invalid option for class selection");
                        }
                    }
                }else{
                    System.out.println("The age is not valid");
                }
            } else if (answer.equalsIgnoreCase("no")) {
                continue;
            }else{
                System.out.println("The answer is not valid, please try again.");
            }
        }
    }

    public void createClass(){

        String className = chooseClassName();
        int classroom = chooseClassroom();
        Teacher teacherForClass = chooseTeacher();
        List<Student> studentsInClass = chooseStudents();
        Collections.sort(studentsInClass);

        while (true){
            System.out.print("\nIs the information correct?\n" +
                    "Class name: " + className + "\n" +
                    "Classroom: " + classroom + "\n" +
                    "Teacher: " + teacherForClass.getName()+ "\n" +
                    "Students: " + studentsInClass + "\n" +
                    "Please confirm with a Yes/No: ");

            String answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("yes")){
                UniversityClass newUniversityClass = new UniversityClass(className,classroom,teacherForClass,studentsInClass);
                classes.add(newUniversityClass);
                System.out.println("Class created successfully!");
                return;
            } else if (answer.equalsIgnoreCase("no")){
                UniversityClass newUniversityClass = classChangeOptions(className,classroom,teacherForClass,studentsInClass);
                classes.add(newUniversityClass);
                System.out.println("\nClass created successfully!");
                return;
            } else {
                System.out.println("Invalid response, try again");
            }
        }

    }

    private String chooseClassName() {
        System.out.print("\nClass creation:\nPlease enter the class name: ");
        return keyboard.nextLine();
    }

    protected int chooseClassroom(){
        while (true){
            System.out.print("Please enter the classroom number (105-110) : ");
            int classroomNumber = keyboard.nextInt();
            keyboard.nextLine();
            if (classroomNumber >= 105 && classroomNumber<=110){
                return classroomNumber;
            }else {
                System.out.println("Invalid classroom number");
            }
        }
    }

    protected Teacher chooseTeacher(){
        while (true){
            System.out.println("Select an Instructor");
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println((i+1) + ". " + teachers.get(i).getName());
            }
            System.out.print("\nPlease choose the instructor option for this course: ");
            int teacherOption = keyboard.nextInt()-1;
            keyboard.nextLine();
            if(teacherOption >= 0 && teacherOption < teachers.size() ){
                return teachers.get(teacherOption);
            }else{
                System.out.println("The teacher option is not valid");
            }
        }
    }

    protected List<Student> chooseStudents(){
        System.out.println("Student selection");
        List<Student> studentsInClass = new ArrayList<>();

        while (true) {
            for (Student student : students) {
                if (studentsInClass.contains(student)) {
                    continue;
                }
                System.out.println(student);
            }
            System.out.print("\nPlease select the student for this class by their ID: ");
            int studentOption = keyboard.nextInt();
            keyboard.nextLine();
            if (studentOption >= 0 && studentOption < students.size()) {
                Student choseStudent = students.get(studentOption);
                studentsInClass.add(choseStudent);
                while (true){
                    System.out.print( choseStudent.getName() + " was added successfully. Do you want to add another student? Yes/No: ");
                    String addAnother = keyboard.nextLine();
                    if(addAnother.equalsIgnoreCase("no")){
                        return studentsInClass;
                    } else if (addAnother.equalsIgnoreCase("yes")) {
                        break;
                    }else{
                        System.out.println("The answer is not valid, please try again.");
                    }
                }
            } else {
                System.out.println("The student option is not valid");
            }
        }
    }

    protected UniversityClass classChangeOptions(String className, int classroom, Teacher teacherForClass, List<Student> studentsInClass){
        while (true){
            System.out.println(
                    "\nChoose what you want to change from the class:\n" +
                            "   1. Class name\n" +
                            "   2. Classroom\n" +
                            "   3. Teacher\n" +
                            "   4. Students\n" +
                            "   5. Everything\n\n" +
                            "   0. nothing");
            System.out.print("Enter the option: ");
            int change = keyboard.nextInt();
            keyboard.nextLine();

            switch (change){
                case 1 -> className = chooseClassName();
                case 2 -> classroom = chooseClassroom();
                case 3 -> teacherForClass = chooseTeacher();
                case 4 -> studentsInClass = chooseStudents();
                case 5 -> {
                    className = chooseClassName();
                    classroom = chooseClassroom();
                    teacherForClass = chooseTeacher();
                    studentsInClass = chooseStudents();
                    Collections.sort(studentsInClass);}
                default -> {
                    System.out.println("invalid option");
                    continue;}
            }

            System.out.print("\nIs the information correct?\n" +
                    "Class name: " + className + "\n" +
                    "Classroom: " + classroom + "\n" +
                    "Teacher: " + teacherForClass.getName()+ "\n" +
                    "Students: " + studentsInClass + "\n" +
                    "Please confirm with a Yes/No: ");

            String answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("yes")){
                return new UniversityClass(className,classroom,teacherForClass,studentsInClass);
            } else if (answer.equalsIgnoreCase("no")){
                continue;
            } else {
                System.out.println("invalid response");
            }
        }
    }

    public void findClassesByStudentId(){
        List<String> listClassNames = new ArrayList<>();
        System.out.println("Student selection");
        while (true) {
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.print("\nPlease enter the ID of the student you are interested in: ");
            int id = keyboard.nextInt();
            keyboard.nextLine();
            if (id >= 0 && id < students.size()) {
                for(UniversityClass universityClass : classes){
                    for (Student student:universityClass.getStudents()){
                        if(id == student.getId()){
                            listClassNames.add(universityClass.getClassName());
                            break;
                        }
                    }
                }
                System.out.println(
                        "\nStudent: " + students.get(id).getName() +
                        "\nClases: " + listClassNames);
                return;
            }else{
                System.out.println("The id is not valid");
            }
        }
    }

}
