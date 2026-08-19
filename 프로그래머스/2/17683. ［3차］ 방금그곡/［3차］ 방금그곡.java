import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String target = normalize(m);
        String answer = "(None)";
        int maxDuration = -1;

        for (String musicInfo : musicinfos) {
          String[] info = musicInfo.split(",");
          int start = toMinutes(info[0]);
          int end = toMinutes(info[1]);
          int duration = end - start;
          String melody = normalize(info[3]);

          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < duration / melody.length(); i++) sb.append(melody);
          sb.append(melody, 0, duration % melody.length());

          if (sb.toString().contains(target) && duration > maxDuration) {
            maxDuration = duration;
            answer = info[2];
          }
        }

        return answer;
    }
    
    
    int toMinutes(String hhmm) {
        return Integer.parseInt(hhmm.substring(0, 2)) * 60 + Integer.parseInt(hhmm.substring(3, 5));
    }

    String normalize(String s) {
        return s.replace("C#", "c").replace("D#", "d").replace("F#", "f")
                .replace("G#", "g").replace("A#", "a").replace("E#", "e").replace("B#", "b");
    }
    
}