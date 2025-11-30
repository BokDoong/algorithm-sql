import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static int[][] human;

    static PriorityQueue<PC> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.endTime));
    static PriorityQueue<PC> freePCs = new PriorityQueue<>(Comparator.comparingInt(p -> p.idx));
    
    static List<Integer> pcUsageCounts = new ArrayList<>();

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        human = new int[N][2];

        for ( int i = 0 ; i < N ; i++ ) {

            st = new StringTokenizer(br.readLine());
            human[i][0] = Integer.parseInt(st.nextToken());
            human[i][1] = Integer.parseInt(st.nextToken());
            
        }
        
    }

    static void sortHuman() {
        Arrays.sort(human, Comparator.comparingInt((int[] h) -> h[0]));
    }

    static class PC {

        int idx;
        int endTime;

        PC(int idx, int endTime ) {
            this.idx = idx;
            this.endTime = endTime;
        }

        void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        int getIdx() {
            return this.idx;
        }

        int getEndTime() {
            return this.endTime;
        }

        @Override
        public String toString() {
            return "idx : " + idx + ", endTime : " + endTime;
        }
        
    }

    static void solve() {

        for ( int n = 0 ; n < N ; n++ ) {

            int startTime = human[n][0];
            int endTime = human[n][1];

            // 들어갈 수 있는 PC 찾기
            while ( !minHeap.isEmpty() && minHeap.peek().getEndTime() <= startTime ) {
                PC freePC = minHeap.poll();
                freePCs.add(freePC);
            }

            // 들어갈 수 없으면 
            if ( freePCs.isEmpty() ) {

                // 새로 추가
                PC newPC = new PC(pcUsageCounts.size(), endTime);
                pcUsageCounts.add(1);
                minHeap.add(newPC);
                
            }
            // 들어갈 수 있으면
            else {
                
                // 가장 최소번호에 넣기
                PC minPC = freePCs.poll();
                int count = pcUsageCounts.get(minPC.getIdx());
                pcUsageCounts.set(minPC.getIdx(), count+1);

                // 종료시간 업데이트하고 다시 넣기
                minPC.setEndTime(endTime);
                minHeap.add(minPC);
                
            }
            
        }
        
    }
    
    public static void main(String[] args) throws IOException {

        input();
        sortHuman();
        solve();

        System.out.println(pcUsageCounts.size());
        for ( int c : pcUsageCounts ) {
            System.out.print(c + " ");
        }
        
    }
    
}
