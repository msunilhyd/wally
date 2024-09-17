package com.sunil;

public class SumOfTwoBinaryIntegers {

    public int getSum(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        while (b != 0) {
            int carry = a & b; // if a nd b are both 1 then we have carry
            a = a ^ b; // if only a or b is 1 then a is 1
            b = carry << 1; // carry slide one bit
        }
        return a;
    }
}
