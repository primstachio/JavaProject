package edu.sdccd.cisc191;
/**
 * (MODULE 9) Concurrency
 * Enroll(er)s enroll students into a HighSchool.
 * Adapted from Tasha Frankie and Allan Schougaard's Warehouse module.
 */
public class Enroll extends Thread {
    private String SSID;
    private HighSchool highschool;
    private int numberOfStudentsToEnroll;
    public Enroll(String givenName, HighSchool givenHighSchool, int givenNumberOfStudentsToEnroll)
    {
        SSID = givenName;
        highschool = givenHighSchool;
        numberOfStudentsToEnroll = givenNumberOfStudentsToEnroll;
    }
    @Override
    public void run()
    {
        System.out.println(SSID + " running in Thread: " + Thread.currentThread().getName());
        for (int i = 0; i < numberOfStudentsToEnroll; i++)
        {
            StudentConcurrency studentConcurrency = new StudentConcurrency();
            synchronized (highschool)
            {
                highschool.receive(studentConcurrency);
            }
        }
        System.out.println(SSID + " ended.");
    }
}
