package edu.sdccd.cisc191;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
/**
 * (10)
 * suicide-rates-by-country.csv
 * https://github.com/liadkeller/Suicides-Data-Analysis-DSE200X/blob/master/suicide-rates-by-country.csv
 */
public class StreamAPI {
    public static void main(String[] args) {
        List<SuicideRates> stats = new CsvToBeanBuilder<SuicideRates>(new InputStreamReader(StreamAPI.class.getResourceAsStream("/suicide-rates-by-country.csv")))
                .withType(SuicideRates.class)
                .build()
                .parse();
        long streamTime = computeSuicideRateStream(stats);
        long loopTime = computeSuicideRateLoop(stats);
        System.out.println("RESULT: (LOOP) " + loopTime + "ms");
        System.out.println("RESULT: (STREAM) " +  streamTime + "ms");
    }
    public static long computeSuicideRateStream(List<SuicideRates> stats) {
        System.out.println("\n-----Stream-----");
        long startTime = System.currentTimeMillis();
        Map<String, Double> countryToRateSum = stats.stream()
                .filter(stat -> stat.getCountry() != null && !stat.getCountry().isEmpty()) // Exclude null or empty values.
                .collect(Collectors.groupingBy(SuicideRates::getCountry, Collectors.summingDouble(SuicideRates::getRate)));
        countryToRateSum.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        return System.currentTimeMillis() - startTime;
    }
    public static long computeSuicideRateLoop(List<SuicideRates> stats) {
        System.out.println("\n-----Loop-----");
        long startTime = System.currentTimeMillis();
        Map<String, Double> countryToDeaths = new TreeMap<>();
        for(SuicideRates stat: stats) {
            if(countryToDeaths.containsKey(stat.getCountry())) {
                countryToDeaths.put(stat.getCountry(), countryToDeaths.get(stat.getCountry()) + stat.getRate());
            } else {
                countryToDeaths.put(stat.getCountry(), stat.getRate());
            }
        }
        for(Map.Entry<String,Double> entry: countryToDeaths.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return System.currentTimeMillis() - startTime;
    }
}
