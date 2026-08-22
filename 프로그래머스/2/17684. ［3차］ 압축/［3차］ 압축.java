import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 사전 초기화: A~Z → 1~26
        Node head = new Node(0);
        int size = 26;
        for (char c = 'A'; c <= 'Z'; c++) {
            head.connectNode(new Node(c, c - 'A' + 1));
        }

        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        while (idx < msg.length()) {
            Node node = head;

            while (true) {
                // 입력 소진 → 등록 없이 종료
                if (idx == msg.length()) {
                    answer.add(node.idx);
                    return answer.stream().mapToInt(Integer::intValue).toArray();
                }

                Node nextNode = node.containNextNode(msg.charAt(idx));
                if (nextNode == null) {
                    answer.add(node.idx);
                    break;
                }
                idx++;
                node = nextNode;
            }

            // 최장 일치 + 다음 글자를 사전에 등록
            size++;
            node.connectNode(new Node(msg.charAt(idx), size));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Node {
        List<Node> nextNodes;
        char val;
        int idx;

        public Node(int idx) {
            this.nextNodes = new ArrayList<>();
            this.idx = idx;
        }

        public Node(char val, int idx) {
            this.nextNodes = new ArrayList<>();
            this.val = val;
            this.idx = idx;
        }

        public void connectNode(Node node) {
            this.nextNodes.add(node);
        }

        public Node containNextNode(char val) {
            for (Node nextNode : nextNodes) {
                if (nextNode.val == val) return nextNode;
            }
            return null;
        }
    }
}