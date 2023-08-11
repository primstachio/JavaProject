package edu.sdccd.cisc191;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import java.io.*;
/**
 * (MODULE 1) Interactive Console and 2D Array
 * (MODULE 3) Object-Oriented Programming
 */
public class StudentTest {
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
    @Test // (3)
    void testHighSchoolStudent() {
        HighSchoolStudent highSchoolStudent = new HighSchoolStudent("HS123", "John", "Doe", 4.0, 11);
        assertEquals("HS123", highSchoolStudent.getSSID());
        assertEquals("John", highSchoolStudent.getFirstName());
        assertEquals("Doe", highSchoolStudent.getLastName());
        assertEquals(4.0, highSchoolStudent.getCurrentGPA(), 0.01);
        assertEquals(11, highSchoolStudent.getGradeLevel());
        assertTrue(highSchoolStudent.isPromotionEligible());
    }
    @Test // (3)
    void testCollegeStudent() {
        CollegeStudent collegeStudent = new CollegeStudent("C123", "John", "Doe", 3.5, "Mathematics");
        assertEquals("C123", collegeStudent.getSSID());
        assertEquals("John", collegeStudent.getFirstName());
        assertEquals("Doe", collegeStudent.getLastName());
        assertEquals(3.5, collegeStudent.getCurrentGPA(), 0.01);
        assertEquals("Mathematics", collegeStudent.getMajor());
        assertTrue(collegeStudent.isGraduationEligible());
    }




}






