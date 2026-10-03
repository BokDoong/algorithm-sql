#include <bits/stdc++.h>

using namespace std;

// 아예 안맞추거나 어피치보다 하나 더 맞춰야함

// maxDiff, result
int maxDiff = -1;
vector<int> result;

// 음수이면 어피치가 더 큰 것임.
int calculateDiff(vector<int>& lion, vector<int>& apeach) {
    int answer = 0;
    for (int i = 0; i < 10; i++) {
        if (lion[i] == 0 && apeach[i] == 0) continue;
        if (apeach[i] < lion[i]) answer += 10 - i;
        else answer -= 10 - i;;
    }
    return answer;
}


// 백트래킹
void backTracking(vector<int>& lion, vector<int>& apeach, int n, int depth) {
    
    // 끝
    if (depth == 10) {
        lion[10] = n;
        int diff = calculateDiff(lion, apeach);
        if (diff <= 0) {
            lion[10] = 0;
            return;
        }
        
        // - depth가 10이라면 diff 비교
        //   - maxDiff < diff: maxDiff 갱신, result 갱신
        //   - maxDiff == diff: result 역순으로 큰 것으로 갱신
        //   - maxDiff > diff: 끝
        if (diff > maxDiff) {
            maxDiff = diff;
            result = lion;
        } else if (diff == maxDiff) {
            for (int i = 10; i >= 0; i--) {
                if (lion[i] > result[i]) { result = lion; break; }
                if (lion[i] < result[i]) break;
            }
        }
        lion[10] = 0;
        return;
    }
    
    // - 백트래킹
    //   - 0으로
    //   - 어피치+1 > 백트래킹 > 0 복귀
    backTracking(lion, apeach, n, depth+1);
    if (n >= apeach[depth] + 1) {
        lion[depth] = apeach[depth] + 1;
        backTracking(lion, apeach, n - (apeach[depth] + 1), depth+1);  // 이렇게
        lion[depth] = 0;
    }
}

vector<int> solution(int n, vector<int> info) {
    maxDiff = -1;
    result.clear();
    result.assign(11, 0); 
    vector<int> lion(11, 0);
    backTracking(lion, info, n, 0);
    for (int i = 0; i < 11; i++) cout << result[i] << " ";
    if (maxDiff == -1) return {-1};
    return result;
}