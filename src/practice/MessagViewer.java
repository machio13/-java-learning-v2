package practice;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class MessagViewer {
    public static void main(String[] args) {
        Path path = Path.of("Message.txt");
        File path1 = path.toFile();

        try (FileReader reader = new FileReader(path1, StandardCharsets.UTF_8)) {
            for (int data; (data = reader.read()) != -1;) {
                System.out.print((char) data);
            }
        }catch (FileNotFoundException e) {
            System.out.println("ファイルが見つかりません");
        }catch (IOException e){
            System.out.println("dataが読み込めません");
        }
    }
}
