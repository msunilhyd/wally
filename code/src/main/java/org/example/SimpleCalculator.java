package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;

public class SimpleCalculator {

    public static void main(String[] args) {
        String str = "(* 2 8)";
        System.out.println(calculate(str));
        // (+ 4 6) => 10
        // (* 2 8) => 16
        // (+ 5 (* 2 3)) => 11
    }

    public static int calculate(String str) {
        str = str.replace("(", "");
        str = str.replace(")", "");
        String[] arr = str.split(" ");
        String operand = arr[0];
        int a = Integer.parseInt(arr[1]);
        int b = Integer.parseInt(arr[2]);
        if (operand.equals("+"))
            return a + b;
        else if (operand.equals("-"))
            return a - b;
        else if (operand.equals("*"))
            return a * b;
        else if (operand.equals("/"))
            return a /b;
        return 0;
    }
}
