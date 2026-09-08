// StudentDirectory.java
// Ronald Bryant
// 11/02/2025
// Class/application which represents a student directory


package edu.fscj.cop3330c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

class StudentDirectory implements Iterable<Student> {
    private List<Student> students;

    public StudentDirectory() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Optional<Student> findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();

        // Adding students to the directory
        directory.addStudent(new Student("Alice", 20));
        directory.addStudent(new Student("Bob", 22));
        directory.addStudent(new Student("Charlie", 19));

        // Iterating over the students using Iterator pattern
        System.out.println("Student List:");
        for (Student student : directory) {
            System.out.println(student);
        }

        // Finding a student by name using Optional
        String searchName = "Bob";
        Optional<Student> studentOpt = directory.findStudentByName(searchName);

        // Handling the Optional result
        studentOpt.ifPresentOrElse(
                student -> System.out.println("Found student: " + student),
                () -> System.out.println("Student with name " +
                        searchName + " not found.")
        );

        // Searching for a non-existing student
        String nonExistingName = "David";
        Optional<Student> nonExistingStudentOpt =
                directory.findStudentByName(nonExistingName);
        nonExistingStudentOpt.ifPresentOrElse(
                student -> System.out.println("Found student: " + student),
                () -> System.out.println("Student with name " +
                        nonExistingName + " not found.")
        );
    }
}