package practice;

import java.math.*;

public class Pythagoras {
    public static void main(String[] args) {
        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);

        double pythagoras = Math.sqrt(Math.pow(num1, 2) + (Math.pow(num2, 2)));
        System.out.println("斜面の長さは" + pythagoras);
    }
}
