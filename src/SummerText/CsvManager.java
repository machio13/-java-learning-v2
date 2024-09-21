package SummerText;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvManager {
    private String csvFile;

    public CsvManager(String csvFile) {
        this.csvFile = csvFile;
    }

    public void displayCsv() {
        CsvReader csvReader = new CsvReader(csvFile);
        csvReader.readCsv();
    }
    public void addNewEntry() {
        Scanner scanner = new Scanner(System.in);

        // 銘柄名を入力
        System.out.print("銘柄名>");
        String productName = scanner.nextLine();

        // 銘柄コードを入力（4桁の数字のみ許可）
        String ticker;
        while (true) {
            System.out.print("銘柄コード>");
            ticker = scanner.nextLine();

            // 4桁で、第1桁・第3桁は数字、第2桁・第4桁は英字または数字（英字はBEOIQVZのみ）で構成されているかを確認
            if (ticker.matches("^[0-9][BEOIQVZ0-9][0-9][BEOIQVZ0-9]$")) {
                break;  // 条件に一致すればループを抜ける
            } else {
                System.out.println("不適切です。やり直してください。");
            }
        }


        // 上場市場を入力（Prime、Standard、Growthのみ許可）
        String market;
        while (true) {
            System.out.print("上場市場（Prime、Standard、Growth)>");
            market = scanner.nextLine();
            if (market.equalsIgnoreCase("Prime") || market.equalsIgnoreCase("Standard") || market.equalsIgnoreCase("Growth")) {
                market = market.substring(0, 1).toUpperCase() + market.substring(1).toLowerCase();  // 入力を正しい形式に整形
                break;
            } else {
                System.out.println("不適切です。やり直してください。");
            }
        }

        // 発行済み株式数を入力（数値のみ許可）
        String sharesIssued;
        while (true) {
            System.out.print("発行済み株式数>");
            sharesIssued = scanner.nextLine();
            if (sharesIssued.matches("\\d+")) {  // 数字のみ許可
                break;
            } else {
                System.out.println("不適切です。やり直してください。");
            }
        }

        // CSVファイルに新しいデータを追記
        try (FileWriter writer = new FileWriter(csvFile, true)) {  // trueを指定して追記モードに
            writer.write(ticker + "," + productName + "," + market + "," + sharesIssued + "\n");
            System.out.println("新規データが追加されました！");
        } catch (IOException e) {
            System.out.println("エラーが発生しました: " + e.getMessage());
        }
    }
}
