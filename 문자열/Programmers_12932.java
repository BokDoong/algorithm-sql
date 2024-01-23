package Book;

public class Programmers_12932 {

    static int[] solution(long n) {

        String nums = Long.toString(n);
        String reversed = new StringBuilder(nums).reverse().toString();
        char[] arr = reversed.toCharArray();

        int[] answer = new int[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[i] - '0';
        }

        return answer;
    }
}
