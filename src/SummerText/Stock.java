package SummerText;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class Stock {
    String ticker;
    String productName;
    Market market;
    String sharesIssued;

    // コンストラクタ
    public Stock(String ticker, String productName, Market market, String sharesIssued) {
        this.ticker = ticker;
        this.productName = productName;
        this.market = market;
        this.sharesIssued = sharesIssued;
    }
    // ProductNameを33文字以内に整形するメソッド
    public static String formatProductName(String productName) {
        if (productName.length() > 23) {
            return productName.substring(0, 23) + "...";
        }
        return productName;
    }

    public static String formatSharesIssued(String sharesIssued) {
        try {
            BigDecimal shares = new BigDecimal(sharesIssued);
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            return decimalFormat.format(shares);
        } catch (NumberFormatException e) {
            return sharesIssued;  // もし数値でない場合、そのまま返す
        }
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
            String formattedSharesIssued = Stock.formatSharesIssued(stock.sharesIssued);
            System.out.printf("|  %-6s|%-29s|%-13s|%-14s|%n", stock.ticker, formattedName, stock.market.getDisplayName(), formattedSharesIssued);
        }

        System.out.println("|========|=============================|=============|==============|");
    }
}
