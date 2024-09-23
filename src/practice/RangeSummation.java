package practice;

public class RangeSummation {
    public static void main(String[] args) {

        int sum = 0;
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        for (int i = num1; i <= num2; i++) {
            if (i == num1) {
                if (i > 0) {
                    System.out.print("");
                }else {
                    System.out.print("-");
                }
            }
            else if (i > num1) {
                if(i < 0) {
                    System.out.print("-");
                }else {
                    System.out.print("+");
                }
            }
            System.out.print(Math.abs(i));
            sum += i;
        }
        System.out.print("=" + sum);
    }
}