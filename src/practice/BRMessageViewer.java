package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class BRMessageViewer {
    public static void main(String[] args) {
        File file = new File("Message.txt");
        Path path = file.toPath();

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            for (String line; (line = br.readLine()) != null;){
                System.out.println(line);
            }
        }catch (NoSuchFileException e){
            System.out.println("ファイルが見つかりません");
        }catch (IOException e) {
            System.out.println("データを読み込めません");
        }
    }
}
