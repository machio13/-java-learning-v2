package SummerText;

import SummerText.Stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    // CSVファイルを読み込むメソッド
    public static List<Stock> readCsv(String filePath) {
        List<Stock> stockList = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // ヘッダー行を読み飛ばす
            br.readLine();

            // CSVファイルを1行ずつ読み込む
            while ((line = br.readLine()) != null) {
                String[] stockData = line.split(cvsSplitBy);
//                String marketType = Stock.convertMarketType(stockData[2]);
                Market marketType = Market.fromCode(stockData[2]);
                stockList.add(new Stock(stockData[0], stockData[1], marketType, stockData[3]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockList;
    }
}
