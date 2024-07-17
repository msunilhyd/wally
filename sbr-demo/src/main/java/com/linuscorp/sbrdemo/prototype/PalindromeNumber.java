package com.linuscorp.sbrdemo.prototype;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }

    public static boolean isPalindrome(int num) {
        String str = "";
        int temp = num;
        while(temp > 0) {
            int digit = temp % 10;
            str = str + digit;
            temp = temp / 10;
        }
        System.out.println(str);
        System.out.println(num+"");
        return str.equalsIgnoreCase(num+"");
    }
}
