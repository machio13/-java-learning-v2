package practice;

public class Triangle {
    public static void main(String[] args) {

        int num = Integer.parseInt(args[0]);

        for (int i = num; i >= 1; i--) {
            // iの値だけ*を出力
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // 改行
            System.out.println();
        }
    }
}
