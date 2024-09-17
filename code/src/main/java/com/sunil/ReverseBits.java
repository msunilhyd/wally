package com.sunil;

public class ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i=0; i<32; i++) { // length of the word is 32
            res <<= 1; // this is like multiplying the number with 10 in decimal. Here we left shift it as in multiplying by 2
            res += (n&1); // add number after taking its & with 1
            n >>= 1; // divide number by 2 to get next digit
        }
        return res;
    }
}
