package edu.sdccd.cisc191;
/**
 * (MODULE 3) Object-Oriented Programming
 * Demonstrates inheritance. Extends Student and adds gradeLevel property.
 */
public class HighSchoolStudent extends Student {
    private int gradeLevel;
    public HighSchoolStudent(String SSID, String firstName, String lastName, double currentGPA, int gradeLevel) {
        super(SSID, firstName, lastName, currentGPA);
        this.gradeLevel = gradeLevel;
    }
    public int getGradeLevel() { return gradeLevel; }
    @Override
    public void displayStudentInfo() {
        super.displayStudentInfo();
        System.out.println("GRADE: " + gradeLevel);
    }
    public boolean isPromotionEligible() { return gradeLevel < 12; }
}
