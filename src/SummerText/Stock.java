package SummerText;

import java.util.List;

public class Stock {
    String ticker;
    String productName;
    String market;
    String sharesIssued;

    // コンストラクタ
    public Stock(String ticker, String productName, String market, String sharesIssued) {
        this.ticker = ticker;
        this.productName = productName;
        this.market = market;
        this.sharesIssued = sharesIssued;
    }

    // Marketの変換メソッド
    public static String convertMarketType(String marketCode) {
        return switch (marketCode) {
            case "P" -> "Prime";
            case "S" -> "Standard";
            case "G" -> "Growth";
            default -> "Unknown";
        };
    }

    // ProductNameを33文字以内に整形するメソッド
    public static String formatProductName(String productName) {
        if (productName.length() > 23) {
            return productName.substring(0, 23) + "...";
        }
        return productName;
    }

    // データを表示するメソッド
    public static void displayStockList(List<Stock> stockList) {
        // ヘッダーの表示
        System.out.println("|========|=============================|=============|==============|");
        System.out.printf("|%-8s|%-29s|%-13s|%-14s|%n", "Ticker", "Product Name", "Market", "Shares Issued");
        System.out.println("|--------|-----------------------------|-------------|--------------|");

        // データ行の表示
        for (Stock stock : stockList) {
            String formattedName = Stock.formatProductName(stock.productName);
            System.out.printf("|  %-6s|%-29s|%-13s|%-14s|%n", stock.ticker, formattedName, stock.market, stock.sharesIssued);
        }

        System.out.println("|========|=============================|=============|==============|");
    }
}
