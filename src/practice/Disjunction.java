package practice;

public class Disjunction {
    public static void main(String[] args) {
        boolean a = Boolean.parseBoolean(args[0]);
        boolean b = Boolean.parseBoolean(args[1]);

        boolean disjunction = a || b;
        System.out.println("理論和は、" + disjunction);
    }
}
