package meta;

import java.awt.print.Pageable;

public class RotationalCipher {

    public static void main(String[] args) {
        System.out.println(find("Zebra-493", 3));
    }

    private static String find(String str, int rotationFactor) {
        int ordA = 'A';
        int orda = 'a';
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append((Character.getNumericValue(c) + rotationFactor) % 10);
            } else if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    int temp = (c - ordA + rotationFactor) % 26;
                    sb.append((char)(temp + ordA));
                }
                else if (Character.isLowerCase(c)) {
                    int temp = (c - orda + rotationFactor) % 26;
                    sb.append((char)(temp + orda));
                }
            } else
                sb.append(c);
        }
        return sb.toString();
    }
}
