package practice;

public class LogTime {
    public static void main(String[] args) {
        LogWrite logWrite = new LogWrite();
        logWrite.logApplicationStartTime();  // アプリケーションの起動時間を記録
        System.out.println("アプリケーションが起動しました。");
        // ここにアプリケーションの他の処理を実装
    }
}
