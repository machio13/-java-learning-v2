package practice;

import java.time.LocalDate;

public class ShowDaysLater {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int lateDays = Integer.parseInt(args[0]);

        System.out.println(today.minusDays(lateDays));
    }
}
