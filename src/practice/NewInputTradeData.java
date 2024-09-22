package SummerText;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputTradeData {
    private LocalDateTime tradedDateTime;  // 取引日時
    private String tradeName;              // 銘柄名
    private String side;                   // 売買区分
    private String quantity;               // 数量
    private BigDecimal price;              // 取引単価
    private LocalDateTime inputDateTime;   // 入力日時

    public void userInputTradeData() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm");

        // 取引日時を入力
        while (true) {
            System.out.print("取引日時(yyyy-MM-dd/HH:mm)>");
            String userInputTrade = scanner.nextLine();

            try {
                tradedDateTime = LocalDateTime.parse(userInputTrade, formatter);  // 取引日時を保存
                LocalDateTime today = LocalDateTime.now();

                if ((tradedDateTime.isBefore(today)) || (tradedDateTime.equals(today))) {
                    break;
                } else {
                    System.out.println("日付が未来になっています。過去のデータを入力してください");
                }
            } catch (DateTimeException e) {
                System.out.println("正しい形式で入力し直してください(yyyy-MM-dd/HH:mm)");
            }
        }

        // 銘柄名を入力
        System.out.print("銘柄>");
        tradeName = scanner.nextLine();  // 銘柄名を保存

        // 売買区分を入力
        while (true) {
            System.out.print("売買区分>");
            side = scanner.nextLine();  // 売買区分を保存

            if (side.equals("Sell") || side.equals("Buy")) {
                break;
            } else {
                System.out.println("入力し直してください");
            }
        }

        // 数量を入力
        while (true) {
            System.out.print("数量>");
            quantity = scanner.nextLine();  // 数量を保存

            if (quantity.matches("\\d+")) {
                break;
            } else {
                System.out.println("入力し直してください");
            }
        }

        // 取引単価を入力
        System.out.print("取引単価>");
        String userInputPrice = scanner.nextLine();
        price = new BigDecimal(userInputPrice);  // 取引単価をBigDecimalに変換して保存

        // 入力日時を現在の日時に設定
        inputDateTime = LocalDateTime.now();
        String formattedNowTime = inputDateTime.format(formatter);
        System.out.println("入力日時: " + formattedNowTime);

        // データをCSVに保存
        File tradeTimeCsv = new File("/Users/k.a_/IdeaProjects/java-learning-v2/src/SummerText/TradeData.csv");
        try (BufferedWriter br = new BufferedWriter(new FileWriter(tradeTimeCsv, true))) {
            br.write(tradedDateTime.format(formatter) + "," + tradeName + "," + side + "," + quantity + "," + price + "," + formattedNowTime + "\n");

            System.out.println("ーーー入力完了ーーー");
        } catch (IOException e) {
            System.out.println("エラーが発生しました: " + e.getMessage());
        }
    }

    // 各フィールドのgetterメソッド
    public LocalDateTime getTradedDateTime() {
        return tradedDateTime;
    }

    public String getTradeName() {
        return tradeName;
    }

    public String getSide() {
        return side;
    }

    public String getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getInputDateTime() {
        return inputDateTime;
    }
}
