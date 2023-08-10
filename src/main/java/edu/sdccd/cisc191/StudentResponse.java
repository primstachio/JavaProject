package edu.sdccd.cisc191;
/**
 * (4) I/O Streams
 */
public class StudentResponse {
    private int SSID;
    private String lastName;
    private String firstName;
    public StudentResponse(int SSID, String lastName, String firstName)
    {
        this.SSID = SSID;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public int getSSID()
    {
        return SSID;
    }
    public void setSSID(int SSID)
    {
        this.SSID = SSID;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    @Override
    public String toString()
    {
        return "STUDENT[SSID =" + SSID + ", LAST NAME ='" + lastName + "', FIRST NAME ='" + firstName + "']";
    }
}
