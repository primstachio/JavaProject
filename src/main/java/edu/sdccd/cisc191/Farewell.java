package edu.sdccd.cisc191;
/**
 * (MODULE 9) Concurrency
 * Farewell of students, whether they graduate or are expelled.
 * Adapted from Tasha Frankie and Allan Schougaard's Warehouse module.
 */
public class Farewell extends Thread {
    private String SSID;
    private HighSchool highschool;
    private int numberOfStudentsLeaving;
    public Farewell(String givenSSID, HighSchool givenHighSchool, int givenNumberOfStudentsLeaving) {
        SSID = givenSSID;
        highschool = givenHighSchool;
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
