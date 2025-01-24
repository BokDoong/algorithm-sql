import java.util.HashMap;
import java.util.Map;

public class Trie {

    private Node head;

    public Trie() {
        head = new Node();
    }

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean endOfWord;
    }

    public void insert(String word) {
        Node node = this.head;

        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new Node());
            }
            node = node.children.get(word.charAt(i));
        }

        node.endOfWord = true;
    }

    public boolean search(String word) {
        Node node = this.head;

        for (int i = 0; i < word.length(); i++) {
            if (node.children.containsKey(word.charAt(i))) {
                node = node.children.get(word.charAt(i));
            } else {
                return false;
            }
        }

        return node.endOfWord;
    }
}
