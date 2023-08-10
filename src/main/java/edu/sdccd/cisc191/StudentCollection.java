package edu.sdccd.cisc191;
import java.util.ArrayList;
import java.util.List;
/**
 * (5)
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
