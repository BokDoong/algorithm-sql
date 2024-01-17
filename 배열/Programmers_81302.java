package Book;

public class Programmers_81302 {

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] result = solution(places);
    }

    static final int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static final int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    static public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = checkRoom(places[i]);
        }

        return answer;
    }

    static private int checkRoom(String[] room) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (room[y].charAt(x) == 'P') {
                    // 상하좌우 확인
                    if(!firstCheck(room, x, y))
                        return 0;

                    // 대각선 확인
                    if (!secondCheck(room, x, y)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    // 상하좌우
    static private boolean firstCheck(String[] room, int x, int y) {
        // 0~3 돌리기
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                // P 이면 끝.
                if (room[ny].charAt(nx) == 'P')
                    return false;
                // O 이면 같은 방향의 맨해튼 거리 2인 지점까지 검사 -> P 이면 끝
                if (room[ny].charAt(nx) == 'O') {
                    if (ny + dy[d] >= 0 && nx + dx[d] >= 0 && ny + dy[d] < 5 && nx + dx[d] < 5) {
                        if (room[ny + dy[d]].charAt(nx + dx[d]) == 'P') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // 대각선 애들
    static private boolean secondCheck(String[] room, int x, int y) {
        // 5~8 돌리기
        for (int d = 5; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                // P 이면 -> 주위 확인, 둘 다 X 가 아니면 false
                if (room[ny].charAt(nx) == 'P') {
                    if (room[ny].charAt(x) != 'X' || room[y].charAt(nx) != 'X') {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
