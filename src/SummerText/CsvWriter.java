package SummerText;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private String csvFile;

    public CsvWriter(String csvFile) {
        this.csvFile = csvFile;
    }

    // CSVファイルにデータを追記するメソッド
    public void writeToCsv(String ticker, String productName, String market, String sharesIssued) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {  // trueを指定して追記モードに
            bw.write(ticker + "," + productName + "," + market + "," + sharesIssued + "\n");
            System.out.println("新規データが追加されました！");
        } catch (IOException e) {
            System.out.println("エラーが発生しました: " + e.getMessage());
        }
    }
}
