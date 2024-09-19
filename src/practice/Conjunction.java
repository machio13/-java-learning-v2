package practice;

public class Conjunction {
    public static void main(String[] args) {
        boolean a = Boolean.parseBoolean(args[0]);
        boolean b = Boolean.parseBoolean(args[1]);

        boolean conjunction = a && b;
        System.out.println("理論積は" + conjunction);
    }
}
