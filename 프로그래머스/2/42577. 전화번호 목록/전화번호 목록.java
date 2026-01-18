import java.io.*;
import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        
        String[] phoneBook = new String[phone_book.length];
        for (int i = 0; i < phone_book.length; i++) {
            phoneBook[i] = phone_book[i].replace(" ", "");
        }
        
        Arrays.sort(phoneBook);
        
        // 인접한 두 번호 비교
        for (int i = 0; i < phoneBook.length-1; i++) {
            
            boolean isEnd = true;
            for (int j = 0; j < Math.min(phoneBook[i].length(), phoneBook[i+1].length()); j++) {
                if (phoneBook[i].charAt(j) != phoneBook[i+1].charAt(j)) {
                    isEnd = false;
                    break;
                }
            }
            
            if (isEnd) {
                return false;
            }
        }
        
        return true;
    }
}