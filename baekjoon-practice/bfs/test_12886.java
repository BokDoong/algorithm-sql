package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_12886 {

    static boolean[][] visited = new boolean[1501][1501];

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();

        //main
        int result = bfs(new Stone(f, s, t)) ? 1 : 0;

        //output
        System.out.println(result);
    }

    static boolean bfs(Stone stone) {

        if((stone.first + stone.second + stone.third) % 3 != 0)
            return false;

        Queue<Stone> queue = new LinkedList<>();
        queue.add(stone);
        visited[stone.first][stone.second] = true;

        while (!queue.isEmpty()) {
            Stone now = queue.poll();
            int f = now.first;
            int s = now.second;
            int t = now.third;

            if(f==s && s==t)
                return true;

            if(f!=s) {
                int nf = f > s ? f - s : f * 2;
                int ns = f > s ? s * 2 : s - f;
                if (!visited[nf][ns]) {
                    queue.add(new Stone(nf, ns, t));
                    visited[nf][ns] = true;
                }
            }

            if(f!=t) {
                int nf = f > t ? f - t : f * 2;
                int nt = f > t ? t * 2 : t - f;
                if (!visited[nf][nt]) {
                    queue.add(new Stone(nf, s, nt));
                    visited[nf][nt] = true;
                }
            }

            if(s!=t) {
                int ns = s > t ? s - t : s * 2;
                int nt = s > t ? t * 2 : t - s;
                if (!visited[ns][nt]) {
                    queue.add(new Stone(f, ns, nt));
                    visited[ns][nt] = true;
                }
            }
        }

        return false;
    }


    static class Stone {
        int first;
        int second;
        int third;

        public Stone(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
