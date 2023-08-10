package edu.sdccd.cisc191;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
// (5)
class StudentCollectionTest {
    private StudentCollection studentCollection;
    @BeforeEach
    void setUp() {
        studentCollection = new StudentCollection();
    }
    @Test
    void addStudent() {
        Student student = new Student("123", "John", "Doe", 3.8);
        studentCollection.addStudent(student);
        List<Student> students = studentCollection.getAllStudents();
        assertTrue(students.contains(student));
    }
    @Test
    void removeStudent() {
        Student student = new Student("123", "John", "Doe", 3.8);
        studentCollection.addStudent(student);
        studentCollection.removeStudent(student);
        List<Student> students = studentCollection.getAllStudents();
        assertFalse(students.contains(student));
    }
    @Test
    void findBySSID() {
        Student student = new Student("123", "John", "Doe", 3.8);
        studentCollection.addStudent(student);
        Student foundStudent = studentCollection.findBySSID("123");
        assertNotNull(foundStudent);
        assertEquals(student, foundStudent);
    }
    @Test
    void findBySSIDNotFound() {
        Student student = new Student("123", "John", "Doe", 3.8);
        studentCollection.addStudent(student);
        Student foundStudent = studentCollection.findBySSID("456");
        assertNull(foundStudent);
    }
    @Test
    void findByGPA() {
        Student student1 = new Student("123", "John", "Doe", 3.8);
        Student student2 = new Student("456", "Jane", "Smith", 3.8);
        studentCollection.addStudent(student1);
        studentCollection.addStudent(student2);
        List<Student> foundStudents = studentCollection.findByGPA(3.8);
        assertTrue(foundStudents.contains(student1));
        assertTrue(foundStudents.contains(student2));
    }
    @Test
    void findByGPANotFound() {
        Student student1 = new Student("123", "John", "Doe", 3.8);
        Student student2 = new Student("456", "Jane", "Smith", 3.7);
        studentCollection.addStudent(student1);
        studentCollection.addStudent(student2);
        List<Student> foundStudents = studentCollection.findByGPA(4.0);
        assertTrue(foundStudents.isEmpty());
    }
}
