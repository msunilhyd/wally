package meta;

public class EncryptedWords {

    public static void main(String[] args) {
        System.out.println(encrypt("abxklc"));
    }

    public static String encrypt(String s) {
        if (s.isEmpty())
            return s;

        int mid = s.length() / 2;
        char middleChar = s.charAt(mid);
        String leftString = s.substring(0, mid);
        String rightString = s.substring(mid+1, s.length());

        return middleChar + encrypt(leftString) + encrypt(rightString);
    }
}
