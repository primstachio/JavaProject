package edu.sdccd.cisc191;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * (8)
 */
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String SSID;
    private String firstName;
    private String lastName;
    private double currentGPA;
    public StudentEntity(String SSID, String firstName, String lastName, double currentGPA) {
        this.SSID = SSID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentGPA = currentGPA;
    }
    public StudentEntity() { }
    public Long getId() { return id; }
    public String getSSID() { return SSID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getCurrentGPA() { return currentGPA; }
}
