package BaekJoon_Study.BruteForce.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test_1759 {
    public static int L;
    public static int C;
    public static String[] result;
    public static String[] small = {"a","e","i","o","u"};
    public static List<String> small_alphabet = new ArrayList<>(Arrays.asList(small));


    public static void test(int now, int start, String[] arr) {
        if (now == L) {
            //자,모음 개수
            int so = 0, da = 0;
            for (int i = 0; i < L; i++) {
                if (small_alphabet.contains(result[i]))
                    so++;
                else
                    da++;
            }
            //조건
            if (so > 0 && da > 1) {
                for(int i=0; i<L; i++)
                    System.out.print(result[i]);
                System.out.println();
                return;
            }
            //아니면 return
            else
                return;
        }


        //arr = a,b,c,d,e,f
        //result = a,b,d
        for (int i = start; i < C; i++) {
            result[now] = arr[i];
            test(now+1, i+1, arr);
        }


    }

    //1.서로 다른 L개의 알파벳 소문자
    //2.최소 한개의 모음 + 최소 두개의 자음
    public static void main(String args[]) {
        //input
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        sc.nextLine();
        String[] arr = sc.nextLine().split(" ");


        //main
        Arrays.sort(arr);
        result = new String[L];
        test(0, 0, arr);


        //output
    }
}
