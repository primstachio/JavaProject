package edu.sdccd.cisc191;
/**
 * (3) OOP
 */
public class Student {
    // Attributes of the Student class
    private String SSID;
    private String firstName;
    private String lastName;
    private double currentGPA;
    public Student(String SSID, String firstName, String lastName, double currentGPA) {
        this.SSID = SSID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentGPA = currentGPA;
    }
    public String getSSID() {
        return SSID;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public double getCurrentGPA() {
        return currentGPA;
    }
    public void displayStudentInfo() {
        System.out.println("SSID: " + SSID);
        System.out.println("NAME: " + firstName + " " + lastName);
        System.out.println("GPA: " + currentGPA);
        System.out.println();
    }
}