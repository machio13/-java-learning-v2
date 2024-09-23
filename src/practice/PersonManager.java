package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonManager {
    public static void main(String[] args) {
        System.out.println("人物のデータを管理します\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("1人目の情報を登録してください");
        System.out.print("名前> ");
        String name1 = scanner.nextLine();
        System.out.print("誕生日> ");
        String birthDay1 = scanner.nextLine();
        LocalDate birthDay = LocalDate.parse(birthDay1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.print("性別> ");
        String gender1 = scanner.nextLine();
    }
}
