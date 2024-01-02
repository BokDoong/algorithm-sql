package Book;

import java.util.Arrays;
import java.util.HashSet;

public class Programmers_87377 {

    private static class Node {
        public final long x, y;

        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static long maxX = Long.MIN_VALUE, minX = Long.MAX_VALUE;
    static long maxY = Long.MIN_VALUE, minY = Long.MAX_VALUE;

    public static String[] solution(int[][] line) {
        HashSet<Node> nodes = new HashSet<>();

        // 1. line의 원소 수만큼 반복
        for (int i=0; i<line.length-1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                // 2. 교점 구하기 -> 집합에 넣기, 정수인지 체크
                Node intersection = calculateIntersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if(intersection != null) {
                    nodes.add(intersection);
                }
            }
        }

        // 3. 집합내 원소의 x,y 최대,최소값 구하기 -> 출력 배열 만들기
        nodes.forEach(Programmers_87377::checkXY);
        int height = (int)(maxY - minY + 1);
        int width = (int)(maxX - minX + 1);

        char[][] arr = new char[height][width];
        for(char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 4. 집합내 원소 자리에 *로 바꾸기
        // 4-1. (y, x) 로 접근
        nodes.forEach(node -> {
            // 4-2. maxY - y
            int targetY = (int)(maxY - node.y);
            // 4-3. x - maxX
            int targetX = (int)(node.x - minX);

            arr[targetY][targetX] = '*';
        });


        // 결과 출력
        String[] answer = new String[arr.length];
        for (int i=0; i<answer.length; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;
    }

    static Node calculateIntersection(long a, long b, long e, long c, long d, long f) {
        double x = (double)(b*f - e*d) / (a*d - b*c);
        double y = (double)(e*c - a*f) / (a*d - b*c);

        // 평행한지 검사
        if(a*d - b*c == 0) {
            return null;
        }

        // 정수인지 검사
        if(x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Node((long) x, (long) y);
    }

    static void checkXY(Node node) {
        minX = Math.min(node.x, minX);
        minY = Math.min(node.y, minY);
        maxX = Math.max(node.x, maxX);
        maxY = Math.max(node.y, maxY);
    }
}