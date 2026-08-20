import java.util.*;

class Solution {
    
  public String solution(String m, String[] musicinfos) {

    String answer = "(None)";
    int maxLength = -1;
    String target = normalize(m);

    for (int i = 0; i < musicinfos.length; i++) {
      // 재생된 시간
      String[] info = musicinfos[i].split(",");
      String music = normalize(info[3]);
      int duration = toMinutes(info[1]) - toMinutes(info[0]);

      // 재생된 음악
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < duration/music.length(); j++) {
        sb.append(music);
      }
      sb.append(music.substring(0, duration%music.length()));

      // 포함하는지 체크 > 재생된 시간이 더 길다면 갱신
      if (sb.toString().contains(target) && maxLength < duration) {
          maxLength = duration;
          answer = info[2];
      }
    }

    return answer;
  }

  public int toMinutes(String hhmm) {
    return Integer.parseInt(hhmm.split(":")[0]) * 60 + Integer.parseInt(hhmm.split(":")[1]);
  }

  // C, C#, D, D#, E, F, F#, G, G#, A, A#, B 
  public String normalize(String str) {
    return str.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
  }
}