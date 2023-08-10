package edu.sdccd.cisc191;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import java.io.*;

public class TestJavaProject {
    @Test // (3)
    void testStudent() {
        Student student = new Student("1234", "John", "Doe", 3.75);
        assertEquals("1234", student.getSSID());
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals(3.75, student.getCurrentGPA(), 0.01); // Allow small delta for floating-point comparison.
    }
    @Test // (1)
    void addStudent() {
        StudentMenu studentMenu = new StudentMenu();
        String input = "TestSSID\nTestFirstName\nTestLastName\n3.75\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        studentMenu.addStudent();
        System.setIn(System.in);
        assertEquals(1, studentMenu.getStudentCount());
    }




}






