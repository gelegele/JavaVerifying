package ryo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static void compareTime() {
        Integer SIZE = 1000000;
        // リストとMapを準備
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < SIZE; i++) {
            list.add(i, i);
            map.put(i, i);
        }

        Date start = new Date();
        Integer searchKey = SIZE - 1;
        for (Integer data : list) {
            if (searchKey.equals(data)) {
                Date found = new Date();
                System.out.println(found.getTime() - start.getTime());
                break;
            }
        }

        Date startMap = new Date();
        Integer value = map.get(searchKey);
        Date foundMap = new Date();
        System.out.println(foundMap.getTime() - startMap.getTime());
    }
}
