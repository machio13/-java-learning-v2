package SummerText;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TradeDataWriter {
    private String tradeDataFile;

    public TradeDataWriter(String tradeDataFile) {
        this.tradeDataFile = tradeDataFile;
    }

    public void writerTradeData(LocalDateTime tradedDateTime, String tradeName, String side, String quantity, BigDecimal price, LocalDateTime inputDateTime) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(tradeDataFile, true))){
            br.write( tradedDateTime + "," + tradeName + "," + side + "," + quantity + "," + price + "," + inputDateTime + "\n");

            System.out.println("ーーー入力完了ーーー");
        }catch (IOException e) {
            System.out.println("エラーが発生しました: " + e.getMessage());
        }
    }
}