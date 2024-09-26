package SummerText;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TradeData {
    private LocalDateTime tradedDateTime;
    private String tradeName;
    private String side;
    private String quantity;
    private BigDecimal price;
    private LocalDateTime inputDateTime;

    public void userInputTradeData() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm");

        while (true) {
            System.out.print("取引日時(yyyy-MM-dd/HH:mm)>");
            String userInputTrade = scanner.nextLine();
            try {
                tradedDateTime = LocalDateTime.parse(userInputTrade, formatter);
                LocalDateTime today = LocalDateTime.now();

                if ((tradedDateTime.isBefore(today)) || (tradedDateTime.equals(today))) {
                    tradedDateTime.format(formatter);
                    break;
                }else {
                    System.out.println("日付が未来になっています。過去のデータを入力してください");
                }
            }catch (DateTimeException e) {
                System.out.println("正しい形式で入力し直してください(yyyy-MM-dd/HH:mm)");
            }
        }

        //銘柄を入力
        while (true) {
        System.out.print("銘柄>");
        tradeName = scanner.nextLine();
            if (tradeName.matches("[a-zA-Z0-9 .()]*")) {
                break;
            } else {
            }
        }
        //売買記録を入力
        while (true) {
            System.out.print("売買区分(Sell, Buy)>");
            side = scanner.nextLine();
            if (side.equals("Sell") || side.equals("Buy")) {
                break;
            }else {
                System.out.println("入力し直してください");
            }
        }
        //数量を入力
        String quantityStr;
        while (true) {
            System.out.print("数量>");
            quantityStr = scanner.nextLine();
            if (quantityStr.matches("\\d+")) {
                int quantityInt = Integer.parseInt(quantityStr);
                if (quantityInt % 100 == 0) {
                     quantity = String.valueOf(quantityInt);
                    break;
                }else {
                    System.out.println("入力し直してください");
                }
            }else {
                System.out.println("入力し直してください");
            }
        }
        //取引単価を入力
        while (true) {
            System.out.print("取引単価>");
            String userInputPrice = scanner.nextLine();
            if (userInputPrice.matches("\\d+")) {
                price = new BigDecimal(userInputPrice);
                DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
                decimalFormat.format(price);
                break;
            }else {
                System.out.println("入力し直してください");
            }
        }

        System.out.print("入力日時>");
        inputDateTime = LocalDateTime.now();
        String formattedNowTime = inputDateTime.format(formatter);
        System.out.println(formattedNowTime);

        TradeDataWriter tradeDataWriter = new TradeDataWriter("src/SummerText/TradeData.csv");
        tradeDataWriter.writerTradeData(tradedDateTime, tradeName, side, quantity, price, inputDateTime);

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