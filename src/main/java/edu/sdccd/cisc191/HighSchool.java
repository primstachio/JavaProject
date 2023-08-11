package edu.sdccd.cisc191;
import java.util.ArrayList;
/**
 * (MODULE 9) Concurrency
 * A HighSchool enrolls and farewells students.
 * Adapted from Tasha Frankie and Allan Schougaard's Warehouse module.
 */
public class HighSchool {
    private ArrayList<StudentConcurrency> school = new ArrayList<StudentConcurrency>();
    public synchronized int getNumberOfStudentsEnrolled()
    {
        return school.size();
    }
    public synchronized void receive(StudentConcurrency studentConcurrency)
    {
        System.out.println("High school receive(" + studentConcurrency + ") running in Thread: " + Thread.currentThread().getName());
        school.add(studentConcurrency);
    }
    public synchronized StudentConcurrency ship() throws OutOfStockException
    {
        System.out.println("High school ship() running in Thread: " + Thread.currentThread().getName());
        if (!school.isEmpty()) { return school.remove(school.size()-1); }
        else throw new OutOfStockException();
    }
}
