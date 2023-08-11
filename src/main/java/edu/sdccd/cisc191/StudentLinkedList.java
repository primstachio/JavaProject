package edu.sdccd.cisc191;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
/**
 * (MODULE 6) Linked Data Structures and Recursion
 *            Linked list used to store students.
 *            Recursion implemented through iterative process of traversing through linked list
 *                  in the searching and sorting methods.
 * (MODULE 7) Searching and Sorting
 *            Methods for searching and sorting provided based on student attributes.
 */
public class StudentLinkedList {
    private LinkedList<Student> students = new LinkedList<>();
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }
    public Student findStudentBySSID(String ssid) {
        for (Student student : students) {
            if (student.getSSID().equals(ssid)) {
                return student;
            }
        }
        return null;
    }
    public Student findStudentByLastName(String lastName) {
        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                return student;
            }
        }
        return null;
    }
    public void sortByGPA() {
        Collections.sort(students, Comparator.comparingDouble(Student::getCurrentGPA).reversed());
    }
    public List<Student> getAllStudents() {
        return new LinkedList<>(students); // Return a copy of the list to prevent direct modification
    }
}
