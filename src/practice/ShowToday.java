package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShowToday {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String formattedToday = today.format(formatter);
        System.out.println("今日は" + formattedToday + "です。");
    }
}