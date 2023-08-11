package edu.sdccd.cisc191;
/**
 * (MODULE 10) Lambdas and StreamAPI
 * Convert a for loop over an array into Stream API using lambdas to filter or map.
 * Although not pertaining to strictly students, this applies to death rates by country.
 * Quickly available .csv file as these files are not the easiest to find.
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
    public String getCountry() { return country; }
    public double getRate() { return rate; }
}
