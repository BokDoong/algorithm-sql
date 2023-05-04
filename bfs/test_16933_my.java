package BaekJoon_Study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class test_16933_my {

    static class Node{
        int y;
        int x;
        int drill;
        int count;
        boolean afternoon;
        Node(int y,int x,int drill,int count,boolean afternoon){
            this.y=y;
            this.x=x;
            this.drill=drill;
            this.count=count;
            this.afternoon=afternoon;
        }
    }

    static int max;
    static char map[][];
    static int xx[]= {-1,1,0,0};
    static int yy[]= {0,0,-1,1};
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        max=Integer.parseInt(st.nextToken());
        map=new char[n][m];

        for(int i=0;i<n;i++) {
            String line=br.readLine();
            for(int j=0;j<m;j++) {
                map[i][j]=line.charAt(j);
            }
        }

        bfs();
    }

    public static void bfs() {
        boolean visited[][][]=new boolean[map.length][map[0].length][max+1];

        visited[0][0][0]=true;

        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(0,0,0,1,true));
        while(!queue.isEmpty()) {
            Node temp=queue.poll();
            int prevY=temp.y;
            int prevX=temp.x;
            int drill=temp.drill;
            int count=temp.count;
            boolean afternoon=temp.afternoon;
            if(prevY==map.length-1&&prevX==map[0].length-1) {
                System.out.println(count);
                return;
            }
            for(int i=0;i<xx.length;i++) {
                int nextY=prevY+yy[i];
                int nextX=prevX+xx[i];

                if(nextY<0||nextX<0||nextY>=map.length||nextX>=map[0].length) continue;

                //낮과 밤이 반전된 형태
                boolean reverse=!afternoon;

                //빈칸이라면
                if(map[nextY][nextX]=='0') {
                    //방문한 적이 없다면
                    if(visited[nextY][nextX][drill]==false) {
                        //count 를 1 증가시키고, 낮과 밤을 반전시켜서 queue에 add
                        queue.add(new Node(nextY,nextX,drill,count+1,reverse));
                        visited[nextY][nextX][drill]=true;  //방문처리
                    }
                }
                //벽이라면
                else {
                    //벽을 한 번 더 부술 수 있고 낮이라면
                    if(drill+1<=max&&afternoon) {
                        //방문하지 않았다면
                        if(visited[nextY][nextX][drill+1]==false) {
                            //벽을 부수고, count를 1 증가시키고 낮과 밤을 반전시켜서 queue에 add
                            queue.add(new Node(nextY,nextX,drill+1,count+1,reverse));
                            //방문처리
                            visited[nextY][nextX][drill+1]=true;
                        }
                    }
                    //벽을 한 번 더 부술 수 있고 밤이라면
                    else if(drill+1<=max&&!afternoon) {
                        // 그냥 현재 좌표를 다시 한 번 queue에 add. 낮과 밤은 반전, count 증가.
                        queue.add(new Node(prevY,prevX,drill,count+1,reverse));

                    }
                }



            }
        }
        System.out.println(-1);
    }
}

