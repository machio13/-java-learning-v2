package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShowDaysLater {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int lateDays = Integer.parseInt(args[0]);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String formattedToday = today.format(formatter);
        String formattedAfterDay = today.plusDays(lateDays).format(formatter);

        System.out.println(formattedToday + "の" + lateDays + "日後は" + formattedAfterDay + "です。");
    }
}
