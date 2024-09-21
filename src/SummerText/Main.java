package SummerText;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> menuList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        menuList.add("銘柄マスタ一覧表示");
        menuList.add("銘柄マスタ新規登録");
        menuList.add("アプリケーションを終了します");

        System.out.println("株式管理システムを開始します");
        while (true) {
            System.out.println("操作するメニューを選んでください");
            System.out.println("1. " + menuList.get(0));
            System.out.println("2. " + menuList.get(1));
            System.out.println("9. " + menuList.get(2));
            System.out.print("入力してください:");
            String userInputStr = scanner.nextLine();

            int userInputNum = Integer.parseInt(userInputStr);
            String csvFile = "/Users/k.a_/IdeaProjects/java-learning-v2/src/SummerText/Master.csv";

            if (userInputNum == 9) {
                System.out.println(menuList.get(2));
                break;
            }
            else if (userInputNum == 1) {
                System.out.println("「" + menuList.get(0) + "」" + "が選択されました");
                System.out.println("銘柄マスタを表示します");

                CsvManager csvManager = new CsvManager(csvFile);
                csvManager.displayCsv();
                System.out.println("---");
            }
            else if (userInputNum == 2) {
                System.out.println("「" + menuList.get(1) + "」" + "が選択されました");
                System.out.println("新規株式銘柄マスタを登録します");
                CsvManager csvManager = new CsvManager(csvFile);
                csvManager.addNewEntry();
                System.out.println("---");
            }
            else {
                System.out.println("\"" + userInputStr + "\"" + "に対応するメニューは存在しません。");
            }
        }
    }
}
