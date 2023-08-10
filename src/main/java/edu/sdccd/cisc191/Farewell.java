package edu.sdccd.cisc191;
/**
 * (9) Farewell of students, whether they graduate or are expelled.
 */
public class Farewell extends Thread {
    private String SSID;
    private Highschool highschool;
    private int numberOfStudentsLeaving;
    public Farewell(String givenSSID, Highschool givenHighschool, int givenNumberOfStudentsLeaving) {
        SSID = givenSSID;
        highschool = givenHighschool;
        numberOfStudentsLeaving = givenNumberOfStudentsLeaving;
    }
    @Override
    public void run()
    {
        System.out.println(SSID + " running in Thread: " + Thread.currentThread().getName());
        int studentsFarewelled = 0;
        while (studentsFarewelled < numberOfStudentsLeaving) {
            try {
                StudentConcurrency studentConcurrency;
                synchronized (highschool) {
                    studentConcurrency = highschool.ship();
                }
                if (studentConcurrency != null) {
                    studentsFarewelled++;
                }
            } catch (OutOfStockException e)
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(SSID + " ended.");
    }
}
