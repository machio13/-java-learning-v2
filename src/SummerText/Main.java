package SummerText;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        System.out.println("株式管理システムを開始します");
        while (isRunning) {
            System.out.println("操作するメニューを選んでください");
            System.out.println("1. 銘柄マスタ一覧表示");
            System.out.println("2. 銘柄マスタ新規登録");
            System.out.println("3. 取引入力");
            System.out.println("4. 取引一覧の表示");
            System.out.println("9. アプリケーションを終了します");
            System.out.print("入力してください:");
            String userInput = scanner.nextLine();
            String csvFile = "/Users/k.a_/IdeaProjects/java-learning-v2/src/SummerText/Master.csv";

            switch (userInput) {
                case "9" -> {
                    System.out.println("9. アプリケーションを終了します");
                    isRunning = false;
                }
                case "1" -> {
                    System.out.println("1. 銘柄マスタ一覧表示");
                    List<Stock> stockList = CsvReader.readCsv(csvFile);
                    Stock.displayStockList(stockList);
                    System.out.println("---");
                }
                case "2" -> {
                    System.out.println("2. 銘柄マスタ新規登録");
                    NewEntry newEntry = new NewEntry(csvFile);
                    newEntry.addNewEntry();
                    System.out.println("---");
                }
                case "3" -> {
                    System.out.println("3. 取引入力");
                    TradeData tradeData = new TradeData();
                    tradeData.userInputTradeData();
                    System.out.println("---");
                }
                case "4" -> {
                    System.out.println("4. 取引一覧表示");
                    System.out.println("---");
                }
                default -> {
                    System.out.println("数字以外の入力です。やり直してください。");
                    System.out.println("---");
                }
            }
        }
    }
}
