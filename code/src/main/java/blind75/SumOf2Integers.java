package blind75;

public class SumOf2Integers {

    public static void main(String[] args) {
        System.out.println(find(2, 3));
    }

    public static int find(int a, int b) {
        int carry;
        while (b != 0) {
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
