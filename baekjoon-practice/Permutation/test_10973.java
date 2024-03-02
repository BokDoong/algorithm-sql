package BaekJoon_Study.Permutation;

import java.util.Scanner;

public class test_10973 {
    public static boolean before_permutation(int[] a) {
        //바뀌는 자리 찾기
        int i = a.length-1;
        while (i>0 && a[i-1] <= a[i])
            i--;
        //모두 내림차순(마지막순열일때)
        if(i<=0)
            return false;

        //바꿀 숫자 찾기
        int j = a.length-1;
        while (a[j] >= a[i-1]) {
            j--;
        }

        //swap
        int tmp = a[i - 1];
        a[i-1] = a[j];  a[j] = tmp;

        //나머지 뒤집기
        j = a.length-1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;

            i++; j--;
        }

        return true;
    }

    public static void main(String args[]) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[N];

        String[] str = sc.nextLine().split(" ");
        for (int i = 0; i < str.length; i++)
            nums[i] = Integer.parseInt(str[i]);

        //main
        if (before_permutation(nums)) {
            for (int i = 0; i < N; i++) {
                System.out.print(nums[i]+" ");
            }
        }
        else
            System.out.println(-1);

        //output
    }
}
