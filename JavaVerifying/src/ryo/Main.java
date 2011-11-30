package ryo;

import java.math.BigDecimal;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        parse();
    }

    private static void parse() {
        String s = "9";
        int integerMax = 0;
        int longMax = 0;
        while (Boolean.TRUE) {
            boolean success = false;
            try {
                Integer.parseInt(s);
                success = true;
                integerMax++;
            } catch (NumberFormatException e) {
            }
            try {
                Long.parseLong(s);
                success = true;
                longMax++;
            } catch (NumberFormatException e) {
            }
            try {
                BigDecimal bd = new BigDecimal(s);
                if (bd.toString().length() == 20) {
                    System.out.println("BigDecimal は " + bd.toString());
                    break;
                }
                success = true;
            } catch (NumberFormatException e) {
            }
            if (!success) {
                break;
            }
            s += "9";
        }
        System.out.println("Integer max is " + integerMax);
        System.out.println("Long max is " + longMax);

        BigDecimal bd2 = new BigDecimal("a");
    }
}
