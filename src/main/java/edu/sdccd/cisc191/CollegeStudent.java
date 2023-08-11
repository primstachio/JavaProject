package edu.sdccd.cisc191;
/**
 * (MODULE 3) Object-Oriented Programming
 * Demonstrates inheritance. Extends Student and adds major property.
 */
public class CollegeStudent extends Student {
    private String major;
    public CollegeStudent(String SSID, String firstName, String lastName, double currentGPA, String major) {
        super(SSID, firstName, lastName, currentGPA);
        this.major = major;
    }
    public String getMajor() { return major; }
    @Override
    public void displayStudentInfo() {
        super.displayStudentInfo();
        System.out.println("MAJOR: " + major);
    }
    public boolean isGraduationEligible() { return getCurrentGPA() >= 2.0; }
}
