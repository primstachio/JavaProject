package edu.sdccd.cisc191;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// (6)
class StudentLinkedListTest {
    private StudentLinkedList studentLinkedList;
    @BeforeEach
    void setUp() {
        studentLinkedList = new StudentLinkedList();
    }
    @Test
    void addStudent() {
        Student student = new Student("123", "John", "Doe", 3.8);
        studentLinkedList.addStudent(student);
        Student foundStudent = studentLinkedList.findStudentBySSID("123");
        assertNotNull(foundStudent);
        assertEquals(student, foundStudent);
    }
    @Test
    void removeStudent() {
        Student student = new Student("123", "John", "Doe", 3.8);
        studentLinkedList.addStudent(student);
        studentLinkedList.removeStudent(student);
        Student foundStudent = studentLinkedList.findStudentBySSID("123");
        assertNull(foundStudent);
    }
    @Test
    void findStudentBySSID() {
        Student student1 = new Student("123", "John", "Doe", 3.8);
        Student student2 = new Student("456", "Jane", "Smith", 3.9);
        studentLinkedList.addStudent(student1);
        studentLinkedList.addStudent(student2);
        Student foundStudent = studentLinkedList.findStudentBySSID("456");
        assertNotNull(foundStudent);
        assertEquals(student2, foundStudent);
    }
    @Test
    void findStudentBySSIDNotFound() {
        Student student = new Student("123", "John", "Doe", 3.8);
        studentLinkedList.addStudent(student);
        Student foundStudent = studentLinkedList.findStudentBySSID("456");
        assertNull(foundStudent);
    }
    // (7) vv
    @Test
    void findStudentByLastName() {
        Student student1 = new Student("123", "John", "Doe", 3.8);
        Student student2 = new Student("456", "Jane", "Smith", 3.9);
        studentLinkedList.addStudent(student1);
        studentLinkedList.addStudent(student2);
        Student foundStudent = studentLinkedList.findStudentByLastName("Smith");
        assertNotNull(foundStudent);
        assertEquals(student2, foundStudent);
    }
    @Test
    void findStudentByLastNameNotFound() {
        Student student = new Student("123", "John", "Doe", 3.8);
        studentLinkedList.addStudent(student);
        Student foundStudent = studentLinkedList.findStudentByLastName("Smith");
        assertNull(foundStudent);
    }
    @Test
    void sortByGPA() {
        Student student1 = new Student("123", "John", "Doe", 3.8);
        Student student2 = new Student("456", "Jane", "Smith", 3.9);
        studentLinkedList.addStudent(student2);
        studentLinkedList.addStudent(student1);
        studentLinkedList.sortByGPA();
        Student firstStudent = studentLinkedList.getAllStudents().get(0);
        assertEquals(student2, firstStudent);
    }
}
