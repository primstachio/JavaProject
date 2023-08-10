package edu.sdccd.cisc191;
/**
 * (9)
 */
public class Enroll extends Thread {
    private String SSID;
    private Highschool highschool;
    private int numberOfStudentsToEnroll;
    public Enroll(String givenName, Highschool givenHighschool, int givenNumberOfStudentsToEnroll)
    {
        SSID = givenName;
        highschool = givenHighschool;
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
