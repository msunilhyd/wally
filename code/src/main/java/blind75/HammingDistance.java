package blind75;

public class HammingDistance {

    public static void main(String[] args) {
        int n = 0010101101;
        int count = 0;

        while (n != 0) {
            int isOne = n & 1;
            if (isOne == 1)
                count++;
            n = n >> 1;
        }

        System.out.println(count);
    }
}
