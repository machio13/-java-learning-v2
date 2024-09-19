package practice;

public class Equality {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        boolean equality = (num1 == num2);
        System.out.println("答えは、" + equality);
    }
}
