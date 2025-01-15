package datastructure;

import java.util.HashMap;
import java.util.Map;

public class Tries {
    static class Node {
        // 자식 노드
        Map<Character, Node> childNode = new HashMap<Character, Node>();
        // 문자열의 끝인지 확인
        boolean isEntry;
    }

    static class Trie {

        // 루트 노드
        Node rootNode = new Node();

        // 문자열 저장
        void insert(String word) {
            // 루트부터 탐색 시작
            Node node = this.rootNode;

            // 차례로 내려가며 자식 노드에 해당 문자로 시작하는 노드가 있는지 확인
            for (int i = 0; i < word.length(); i++) {
                node = node.childNode.computeIfAbsent(word.charAt(i), key -> new Node());
            }

            // 마지막이면 끝 표시
            node.isEntry = true;
        }

        // 문자열 검색
        boolean search(String word) {
            // 루트부터 탐색 시작
            Node node = this.rootNode;

            // 하나씩 탐색
            for (int i = 0; i < word.length(); i++) {
                // 자식 노드 중에 있으면 갖고오고, 아님 Null
                node = node.childNode.getOrDefault(word.charAt(i), null);
                if (node == null) {
                    return false;
                }
            }

            // 탐색 끝났으면 : isEntry 가 참이면 단어가 있는 것임, 거짓이면 없는 것
            return node.isEntry;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("frog");
        trie.insert("frodo");
        trie.insert("frozen");
        trie.insert("cat");
        trie.insert("catalog");

        System.out.println(trie.search("cat"));
        System.out.println(trie.search("frodo"));
        System.out.println(trie.search("frod"));
    }
}

