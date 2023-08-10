package edu.sdccd.cisc191;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentEntityTest {
    @Test
    void createStudentEntity() {
        StudentEntity studentEntity = new StudentEntity("1234", "John", "Doe", 4.0);
        assertEquals("1234", studentEntity.getSSID());
        assertEquals("John", studentEntity.getFirstName());
        assertEquals("Doe", studentEntity.getLastName());
        assertEquals(4.0, studentEntity.getCurrentGPA());
    }
}
// Add tests for read and insert classes