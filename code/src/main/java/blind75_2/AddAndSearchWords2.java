package blind75_2;


/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 104 calls will be made to addWord and search.
 */

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWords2 {

    private static Map<Character, Map> trie = new HashMap();

    public static void main(String[] args) {
        String[] words = {"sunil", "sudheer", "prash"};
        for (String word : words) {
            add(word, trie);
        }
        System.out.println(isExist("..i..", trie, 0));
    }

    private static boolean isExist(String word, Map<Character, Map> map, int index) {
        if (index == word.length()) {
            if (map.get('*') != null) {
                return true;
            } else
                return false;
        }
        char curr = word.charAt(index);
        if (curr == '.') {
            for (char c : map.keySet()) {
                if (isExist(word, map.get(c), index + 1))
                    return true;
            }
        } else {
            if (map.get(curr) != null)
                if (isExist(word, map.get(curr), index + 1))
                    return true;
        }
        return false;
    }

    private static void add(String word, Map<Character, Map> map) {
        Map<Character, Map> node = map;
        for (Character c : word.toCharArray()) {
            if (node.get(c) == null)
                node.put(c, new HashMap());
            node = node.get(c);
        }
        node.put('*', new HashMap());
    }

}
