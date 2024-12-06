package blind75;

import java.util.HashMap;
import java.util.Map;

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

public class AddAndSearchWords {

    private static Map<Character, Map> trie = new HashMap<>();

    public static void main(String[] args) {

        String[] wordsToAdd = {"bad", "dad", "mad"};
        for(String str : wordsToAdd) {
            add(str);
        }
        System.out.println(dfs("b..", trie, 0));
    }

    public static void add(String word) {
        Map<Character, Map> node = trie;
        for (int i=0; i<word.length(); i++) {
            char curr = word.charAt(i);
            if (!node.containsKey(curr))
                node.put(curr, new HashMap());
            node = node.get(curr);
        }
        node.put('*', new HashMap());
    }

    public static boolean dfs(String word, Map<Character, Map> map, int index) {
        if (index == word.length()) {
            if (map.get('*') != null)
                return true;
            else
                return false;
        }

        char curr = word.charAt(index);
        if (curr == '.') {
            for (char c : map.keySet()) {
               if (dfs(word, map.get(c), index + 1))
                   return true;
            }
        } else {
            if (map.get(curr) != null) {
                return dfs(word, map.get(curr), index + 1);
            } else
                return false;
        }
        return false;
    }
}


/*
Time and Space Complexity:

addWord Time Complexity:

O(m) where m is the length of the word. This is because we need to traverse each character in the word and add nodes as needed.
addWord Space Complexity:

O(m), where m is the length of the word. Each node in the Trie corresponds to a character, so adding a word requires creating m nodes (in the worst case).
search Time Complexity:

O(m) where m is the length of the word being searched. In the worst case, we have to check every character of the word and traverse through the Trie. The DFS search checks all possible paths in the Trie for each dot (.), but since there are at most 2 dots in the word, the complexity remains linear in terms of the word's length.
search Space Complexity:

O(m), where m is the length of the word being searched. The space is required for the recursive call stack in the DFS search.

 */