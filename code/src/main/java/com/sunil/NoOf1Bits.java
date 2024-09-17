package com.sunil;

public class NoOf1Bits {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += (n & 1); // check if last bit is 1
            n >>>= 1; // zero fill right shift on 1 bit
        }
        return result; // return the number of 1s
    }
}
