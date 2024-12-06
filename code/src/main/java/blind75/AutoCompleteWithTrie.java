package blind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class AutoCompleteWithTrie {

    private TrieNodee root;

    public AutoCompleteWithTrie() {
        root = new TrieNodee(' ');
    }

    public void insert(String word) {
////        if (search(word) == true)
//            return;
//
//        TrieNodee current = root;
//        TrieNodee pre;
//        for (char ch : word.toCharArray()) {
//            pre = current;
//        }
    }
}

class TrieNodee {
    char data;
    LinkedList<TrieNodee> children;
    TrieNodee parent;
    boolean isEnd;

    public TrieNodee(char c) {
        data = c;
        children = new LinkedList<TrieNodee>();
        isEnd = false;
    }

    public TrieNodee getChild(char c) {
        if (children != null) {
            for (TrieNodee node : children) {
               if (node.data == c)
                   return node;
            }
        }
        return null;
    }

    private List<String> getWords() {
        List<String> list = new ArrayList();
        if (isEnd)
            list.add(toString());
        if (children != null) {
            for (int i=0; i<children.size(); i++) {
                if (children.get(i) != null)
                    list.addAll(children.get(i).getWords());
            }
        }
        return list;
    }

    public String toString() {
        if (parent == null)
            return "";
        else
            return parent.toString() + new String(new char[] {data});
    }
}
