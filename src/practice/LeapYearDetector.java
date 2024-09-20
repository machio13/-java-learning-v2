package practice;

import java.time.Year;

public class LeapYearDetector {
    public static void main(String[] args) {
        String yearLeap = args[0].substring(0, 4);
        int year = Integer.parseInt(yearLeap);
        boolean detector = Year.of(year).isLeap();

        System.out.println(detector);
    }
}
