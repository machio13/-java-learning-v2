package SummerText;

import java.util.Scanner;

public class NewEntry {
    private String csvFile;
    String productName;
    String ticker;
    String market;
    String sharesIssued;

    public NewEntry(String csvFile) {
        this.csvFile = csvFile;
    }

    public void addNewEntry () {
        Scanner scanner = new Scanner(System.in);

        // 銘柄名を入力
        while (true) {
            System.out.print("銘柄名>");
            productName = scanner.nextLine();
            if (productName.matches("[a-zA-Z0-9 .()]*")){
                break;
            } else {
                continue;
            }
        }
        // 銘柄コードを入力（4桁の数字のみ許可）
        while (true) {
            System.out.print("銘柄コード>");
            ticker = scanner.nextLine();

            // 4桁で、第1桁・第3桁は数字、第2桁・第4桁は英字または数字（英字はBEOIQVZのみ排除）
            if (ticker.matches("^\\d{4}$|^[0-9][A-Z[^BEOIQVZ]0-9][0-9][A-Z[^BEOIQVZ]0-9]$")) {
                break;
            } else {
                System.out.println("不適切です。やり直してください。");
            }
        }
        // 上場市場を入力（Prime、Standard、Growthのみ許可）
        while (true) {
            System.out.print("上場市場（Prime、Standard、Growth)>");
            market = scanner.nextLine();
            if (market.equals("Prime") || market.equals("Standard") || market.equals("Growth")) {
                market = market.substring(0, 1).toUpperCase();  // 入力を正しい形式に整形
                break;
            } else {
                System.out.println("不適切です。やり直してください。");
            }
        }
        // 発行済み株式数を入力（数値のみ許可
        while (true) {
            System.out.print("発行済み株式数>");
            sharesIssued = scanner.nextLine();
            if (sharesIssued.matches("\\d+")) {  // 数字のみ許可
                break;
            } else {
                System.out.println("不適切です。やり直してください。");
            }
        }
        // CsvWriterクラスを使用してCSVファイルにデータを追記
        CsvWriter csvWriter = new CsvWriter(csvFile);
        csvWriter.writeToCsv(ticker, productName, market, sharesIssued);
    }
}
