package edu.sdccd.cisc191;
/**
 * (10)
 * Although not pertaining to strictly students, this applies to death rates by country.
 * Easy and available .csv file as these files are not the easiest to find.
 */
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.sql.Date;
import java.text.DecimalFormat;

public class SuicideRates {
    @CsvDate(value = "yyyy")
    @CsvBindByName(column = "YEAR")
    private Date year;
    @CsvBindByName(column = "COUNTRY")
    private String country;
    @CsvBindByName(column = "SUICIDE RATE")
    private double rate;
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.#########");
        return String.format("SuicideRates[date=%s, country=%s, rate=%s]", year, country, decimalFormat.format(rate));
    }
    public Date getDate() { return year; }
    public void setDate(Date year) { this.year = year; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }
}
