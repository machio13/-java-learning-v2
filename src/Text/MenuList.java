package Text;

import java.io.File;
import java.util.Scanner;

public class MenuList {

    public static void showMenuList(){
        Scanner scanner = new Scanner(System.in);


        boolean isRunning = true;
        while (isRunning) {
            System.out.println("株式取引管理システムを開始します。");
            System.out.println("1. 銘柄マスタ一覧表示");
            System.out.println("2. 銘柄マスタ新規登録");
            System.out.println("9. アプリケーションを終了する");
            System.out.print("入力してください：");
            String userInput = scanner.nextLine();

            switch (userInput) {

                case "9" -> {
                    System.out.println("9. アプリケーションを終了する");
                    System.out.println("---");
                    isRunning = false;
                }

                case "1" -> {
                    System.out.println("1. 銘柄マスタ一覧表示");
                    System.out.println("---");
                }

                case "2" -> {
                    System.out.println("2. 銘柄マスタ新規登録");
                    System.out.println("---");
                }

                default -> {
                    System.out.println("\"" + userInput + "\"" + "に対応するメニューは存在しません");
                    System.out.println("---");
                }
            }
        }
    }
}
