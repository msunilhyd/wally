package blind75;

import java.util.Arrays;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        String[] arr = {"Hello", "World"};
        System.out.println(Arrays.toString(decode(encode(arr))));
    }

    public static String encode(String[] arr) {
        String encodedString = String.join("-encode-", arr);
        return encodedString;
    }

    public static String[] decode(String str) {
        String[] arr = str.split("-encode-");
        return arr;
    }
}
