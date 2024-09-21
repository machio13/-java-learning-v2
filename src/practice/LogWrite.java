package practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWrite {
    static void logApplicationStartTime() {
        String LOG_FILE = "/Users/k.a_/IdeaProjects/java-learning-v2/src/practice/Log.txt";  // ログファイルのパス
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 現在の日時を取得
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(formatter);

        // ログファイルに書き込み
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(LOG_FILE), StandardOpenOption.CREATE,   // ファイルが存在しない場合は作成
                StandardOpenOption.APPEND     // ファイルに追記モード
        )) {
            writer.write("アプリケーション起動時刻: " + formattedDateTime + "\n");
            System.out.println("起動時間を記録しました: " + formattedDateTime);
        } catch (IOException e) {
            System.out.println("ログファイルへの書き込みに失敗しました: " + e.getMessage());
        }
    }
}
