package SummerText;

import javax.imageio.IIOException;
import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputTradeData {
    private LocalDateTime tradedDateTime;
    private String tradeName;
    private String side;
    private String quantity;
    private BigDecimal price;
    private LocalDateTime inputDateTime;

    public void userInputTradeData() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd,HH:mm");

        String formattedUserInputTrade;
        while (true) {
            System.out.print("取引日時(yyyy-MM-dd,HH:mm)>");
            String userInputTrade = scanner.nextLine();
            formattedUserInputTrade = userInputTrade.formatted(formatter);
            LocalDateTime userInputTradeDay = LocalDateTime.parse(userInputTrade, formatter);
            LocalDateTime today = LocalDateTime.now();

            if ((userInputTradeDay.isBefore(today)) || (userInputTradeDay.equals(today))) {
                break;
            }else {
                System.out.println("日付が未来になっています。過去のデータを入力してください");
            }
        }

        //銘柄を入力
        System.out.print("銘柄>");
        String userInputName = scanner.nextLine();

        //売買記録を入力
        String userInputSide;
        while (true) {
            System.out.print("売買区分>");
            userInputSide = scanner.nextLine();

            if (userInputSide.equals("Sell") || userInputSide.equals("Buy")) {
                break;
            }else {
                System.out.println("入力し直してください");
            }
        }

        //数量を入力
        String userInputQuantity;
        while (true) {
            System.out.print("数量>");
            userInputQuantity = scanner.nextLine();

            if (userInputQuantity.matches("\\d+")) {
                break;
            }else {
                System.out.println("入力し直してください");
            }

        }

        //取引単価を入力
        System.out.print("取引単価>");
        String userInputPrice = scanner.nextLine();

        System.out.print("入力日時>");
        LocalDateTime nowTime = LocalDateTime.now();
        String formattedNowTime = nowTime.format(formatter);
        System.out.println(formattedNowTime);

        File tradeTimeCsv = new File("/Users/k.a_/IdeaProjects/java-learning-v2/src/SummerText/TradeData.csv");
        try (BufferedWriter br = new BufferedWriter(new FileWriter(tradeTimeCsv, true))){
            br.write( formattedUserInputTrade + "," + userInputName + "," + userInputSide + "," + userInputQuantity + "," + userInputPrice + "," + formattedNowTime + "\n");

            System.out.println("入力完了");
        }catch (IOException e) {
            System.out.println("エラーが発生しました: " + e.getMessage());
        }
    }

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