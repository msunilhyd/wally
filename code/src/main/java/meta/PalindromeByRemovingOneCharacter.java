package meta;

public class PalindromeByRemovingOneCharacter {

    public static void main(String[] args) {
        System.out.println(find("lirill"));
    }

    private static int find(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                if (isPalindrome(str, left+1, right))
                    return left;
                if (isPalindrome(str, left, right-1))
                    return right;
                else
                    return -1;
            }
        }
        return -2;
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
