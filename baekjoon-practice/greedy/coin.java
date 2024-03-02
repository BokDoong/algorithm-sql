package BaekJoon_Study.greedy;

import java.util.Scanner;

public class coin {

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        //main
        int answer = 0;
        answer += money/500;
        money %= 500;

        answer += money/100;
        money %= 100;

        answer += money/50;
        money %= 50;

        answer += money / 10;

        //output
        System.out.println(answer);
    }
}
