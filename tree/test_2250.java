package BaekJoon_Study.tree;

import java.util.Scanner;

public class test_2250 {
    static int N, maxLevel, loc = 1;
    static Node[] nodes;
    static int[] levelMax, levelMin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        nodes = new Node[N + 1];
        levelMin = new int[N + 1];
        levelMax = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(-1, i, -1, -1);
            levelMax[i] = 0;
            levelMin[i] = N;
        }
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();

            nodes[data].left = left;
            nodes[data].right = right;
            if (left != -1) {
                nodes[left].parent = data;
            }
            if (right != -1) {
                nodes[right].parent = data;
            }
        }

        //루트 찾기
        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (nodes[i].parent == -1) {
                root = i;
                break;
            }
        }

        //중위 순회
        inorder(root, 1);

        int ans = 0;
        int ansIdx = 0;
        //각 레벨별로 너비 구함
        for (int i = 1; i <= maxLevel; i++) {
            int diff = levelMax[i] - levelMin[i] + 1;
            if (ans < diff) {
                ans = diff;
                ansIdx = i;
            }
        }

        System.out.print(ansIdx + " " + ans);
    }

    //중위 순회
    static void inorder(int root, int level) {
        Node cur = nodes[root];

        //최대깊이 갱신
        maxLevel = Math.max(maxLevel, level);

        //왼쪽 노드
        if (cur.left != -1) {
            inorder(cur.left, level + 1);
        }

        //각 레벨에서 오른쪽+왼쪽 노드
        levelMin[level] = Math.min(levelMin[level], loc);
        levelMax[level] = loc++;

        //오른쪽노드
        if (cur.right != -1) {
            inorder(cur.right, level + 1);
        }

    }

    public static class Node {
        int parent, data, left, right;

        public Node(int parent, int data, int left, int right) {
            this.parent = parent;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
