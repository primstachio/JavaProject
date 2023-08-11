package edu.sdccd.cisc191;
import java.util.ArrayList;
import java.util.List;
/**
 * (MODULE 5) Generics and Collections
 * List of students is a collection that uses generics to specify the Student elements it holds.
 * Implemented methods utilize the collection to manage instances of Student class.
 */
public class StudentCollection {
    private List<Student> students = new ArrayList<>();
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return a copy to prevent direct modification
    }
    public Student findBySSID(String ssid) {
        for (Student student : students) {
            if (student.getSSID().equals(ssid)) {
                return student;
            }
        }
        return null;
    }
    public List<Student> findByGPA(double gpa) {
        List<Student> matchingStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getCurrentGPA() == gpa) {
                matchingStudents.add(student);
            }
        }
        return matchingStudents;
    }
}
