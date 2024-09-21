package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class FriendSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("UserList.txt");

        try {
            String userInput;
            System.out.print("メールアドレスを入力してください（終了するには 'exit' と入力）: ");

            while (!(userInput = scanner.nextLine()).equalsIgnoreCase("exit")) {
                boolean found = false;

                // ファイルの先頭に戻って再度読み込むために新しい BufferedReader を使います
                try (BufferedReader brNew = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
                    for (String line; (line = brNew.readLine()) != null;) {
                        String[] values = line.split(",");
                        if (values.length >= 2 && values[0].contains(userInput)) {  // 一部一致を確認
                            System.out.println("友達ですか？ " + values[1] + "さん");
                            found = true;
                        }
                    }
                }

                if (!found) {
                    System.out.println("見つかりませんでした。もう一度入力してください。");
                }

                System.out.print("メールアドレスを入力してください（終了するには 'exit' と入力）: ");
            }
            System.out.println("プログラムを終了します。");

        } catch (NoSuchFileException e) {
            System.out.println("ファイルが見つかりません: " + file.getName());
        } catch (IOException e) {
            System.out.println("ファイルの読み取り中にエラーが発生しました: " + e.getMessage());
        }
    }
}
