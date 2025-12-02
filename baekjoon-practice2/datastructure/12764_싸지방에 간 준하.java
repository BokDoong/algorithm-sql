// static PriorityQueue<PC> freePCs = new PriorityQueue<>(Comparator.comparingInt(p -> p.idx));

import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] usageTimes;

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        usageTimes = new int[N][2];

        for ( int i = 0 ; i < N ; i++ ) {
            st = new StringTokenizer(br.readLine());
            usageTimes[i][0] = Integer.parseInt(st.nextToken());
            usageTimes[i][1] = Integer.parseInt(st.nextToken());
        }
        
    }

    static void sortUsageTimes() {
        Arrays.sort(usageTimes, Comparator.comparingInt(ut -> ut[0]));
    }

    static class PC {

        int idx;
        int endTime;

        PC ( int idx, int endTime ) {
            this.idx = idx;
            this.endTime = endTime;
        }

        void setEndTime( int endTime ) {
            this.endTime = endTime;
        }
        
    }

    static List<Integer> pcUsages = new ArrayList<>();
    static PriorityQueue<PC> canUse = new PriorityQueue<>(Comparator.comparingInt(pc -> pc.idx));
    static PriorityQueue<PC> cannotUse = new PriorityQueue<>(Comparator.comparingInt(pc -> pc.endTime));

    static void solve() {

        for ( int n = 0 ; n < N ; n++ ) {

            // 시작&끝 시간
            int startTime = usageTimes[n][0];
            int endTime = usageTimes[n][1];

            // 쓸 수 있는 PCs 선별
            while ( !cannotUse.isEmpty() && cannotUse.peek().endTime <= startTime ) {
                canUse.add(cannotUse.poll());
            }
            
            // 쓸 수 있는 PC 있다면 사용
            if ( !canUse.isEmpty() ) {
                
                PC willUse = canUse.poll();
                willUse.setEndTime(endTime);
                cannotUse.add(willUse);

                int pcUsage = pcUsages.get(willUse.idx);
                pcUsages.set(willUse.idx, pcUsage + 1);

            }
            // 없으면 새로 추가
            else {
                
                PC willUse = new PC(pcUsages.size(), endTime);
                cannotUse.add(willUse);
                pcUsages.add(1);
                
            }
            
        }
        
    }

    static void output() {
        System.out.println(pcUsages.size());
        for ( int pu : pcUsages ) {
            System.out.print(pu + " ");
        }
    }
    
    public static void main(String[] args) throws IOException {

        input();
        sortUsageTimes();
        solve();
        output();
        
    }
    
}
