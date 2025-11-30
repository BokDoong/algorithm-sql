import java.io.*;
import java.util.*;

class Main {

    static int R;
    static int C;
    static String[][] puzzles;
    
    static List<String> words = new ArrayList<>();

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        puzzles = new String[R][C];
        for ( int i = 0 ; i < R ; i++ ) {
            st = new StringTokenizer(br.readLine());
            puzzles[i] = st.nextToken().split("");
        }
        
    }

    static void extractWords() {

        // 행
        for ( int r = 0 ; r < R ; r++ ) {

            String tmpStr = "";
            String[] hang = puzzles[r];
                
            for ( int c = 0 ; c < C ; c++ ) {

                // 벽이라면
                if ( hang[c].equals("#") ) {

                    // 지금 크기 2보다 크다면 추가
                    if ( tmpStr.length() >= 2 ) {
                        words.add(tmpStr);
                    }

                    // 초기화
                    tmpStr = "";
                    
                } 
                // 아니라면 문자열 추가
                else {
                    tmpStr += hang[c];
                }
                
            }
            
            // 남아있는 것 추가
            if ( tmpStr.length() >= 2 ) {
                words.add(tmpStr);
            }
            
        }

        // 열
        for ( int c = 0 ; c < C ; c++ ) {

            String tmpStr = "";
                
            for ( int r = 0 ; r < R ; r++ ) {

                // 벽이라면
                if ( puzzles[r][c].equals("#") ) {

                    // 지금 크기 2보다 크다면 추가
                    if ( tmpStr.length() >= 2 ) {
                        words.add(tmpStr);
                    }

                    // 초기화
                    tmpStr = "";
                    
                } 
                // 아니라면 문자열 추가
                else {
                    tmpStr += puzzles[r][c];
                }
                
            }
            
            // 남아있는 것 추가
            if ( tmpStr.length() >= 2 ) {
                words.add(tmpStr);
            }
            
        }
        
    }

    public static void main(String[] args) throws IOException {

        input();
        extractWords();
        Collections.sort(words);
        System.out.println(words.get(0));
        
    }

}
