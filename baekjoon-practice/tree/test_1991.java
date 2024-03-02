package BaekJoon_Study.tree;

import java.util.Scanner;

public class test_1991 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");

            tree.createNode(input[0], input[1], input[2]);
        }

        tree.preOrder(tree.root);
        sb.append("\n");

        tree.inOrder(tree.root);
        sb.append("\n");

        tree.postOrder(tree.root);
        System.out.println(sb);
    }

    public static class Node{
        String data;
        Node left;
        Node right;

        Node(String data){
            this.data = data;
        }
    }

    public static class Tree {
        Node root = new Node(".");

        void createNode(String data, String left, String right) {
            if (root.data.equals(".")) {
                if (!data.equals(".")) {
                    root = new Node(data);
                }
                if (!left.equals(".")) {
                    root.left = new Node(left);
                }
                if (!right.equals(".")) {
                    root.right = new Node(right);
                }
            }
            else
                find(root, data, left, right);
        }

        void find(Node node, String data, String left, String right) {
            if (node == null) {
                return;
            } else if (data.equals(node.data)) {
                if (!left.equals(".")) {
                    node.left = new Node(left);
                }
                if (!right.equals(".")) {
                    node.right = new Node(right);
                }
            } //찾는 노드에 도착하면 추가

            //못찾았으면
            find(node.left, data, left, right);
            find(node.right, data, left, right);
        }

        //전위 순회
        void preOrder(Node node) {
            sb.append(node.data);
            if (node.left != null) {
                preOrder(node.left);
            }
            if (node.right != null) {
                preOrder(node.right);
            }
        }

        //중위 순회
        void inOrder(Node node) {
            if (node.left != null) {
                inOrder(node.left);
            }
            sb.append(node.data);
            if (node.right != null) {
                inOrder(node.right);
            }
        }

        //후위 순회
        void postOrder(Node node) {
            if (node.left != null) {
                postOrder(node.left);
            }
            if (node.right != null) {
                postOrder(node.right);
            }
            sb.append(node.data);
        }
    }
}
