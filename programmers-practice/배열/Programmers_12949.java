package Book;

public class Programmers_12949 {

    static public int[][] solution(int[][] arr1, int[][] arr2) {
        int y = arr1.length;
        int x = arr2[0].length;
        int size = arr2.length;

        // 입력된 행렬의 크기를 고려한 결과 배열 초기화
        int[][] answer = new int[y][x];
        for (int dy = 0; dy < y; dy++) {
            for (int dx = 0; dx < x; dx++) {
                int result = 0;
                for (int i = 0; i < size; i++) {
                    result += arr2[i][dx] * arr1[dy][i];
                }
                answer[dy][dx] = result;
            }
        }

        return answer;
    }
}
