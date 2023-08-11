package edu.sdccd.cisc191;
import java.io.InputStream;
import java.util.Scanner;
/**
 * (MODULE 4) I/O Streams
 */
public class StudentRequest {
    private int SSID;
    public StudentRequest(int SSID)
    {
        this.SSID = SSID;
    }
    public int getSSID()
    {
        return SSID;
    }
    public void setSSID(int SSID)
    {
        this.SSID = SSID;
    }
    @Override
    public String toString()
    {
        return "STUDENT[SSID=" + SSID +"]";
    }
}
