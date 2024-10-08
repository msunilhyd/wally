package easy;

public class LongestCommonPrefix {

    /*
    Write a function to give the longest common prefix string of an array of strings
    ["flower", "flow", "flight"]
    ans = "fl"
     */
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

   public static String longestCommonPrefix(String[] strs) {
       if (strs.length == 0)
           return "";
       int length = strs[0].length();
       for (int i=0; i<strs.length; i++) {
           length = Math.min(length, strs[i].length());
           for (int j=0; j<length; j++) {
               if (strs[0].charAt(j) != strs[i].charAt(j))
                   length = j;
           }
       }
       return strs[0].substring(0, length);
   }
}
