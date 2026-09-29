#include <bits/stdc++.h>

using namespace std;

int maxDiff;
vector<int> answer;
vector<int> lion;
bool flag;

// 차이 계산 : 0이면 진거임
int calculate(vector<int>& aPeach) {
    int l = 0, a = 0;
    for (int i = 0; i < 11; i++) {
        if (aPeach[i] == 0 && lion[i] == 0) continue;
        if (lion[i] > aPeach[i]) l += (10 - i);
        else a += (10 - i);
    }
    return l - a;
}

// idx 끝이거나, n개에 다다르면 끝
// idx 순회하며 0 or apeach[idx]++
void backTracking(vector<int>& aPeach, int idx, int nowN, int n) {
    
    if (idx == 10 || nowN == n) {
        lion[10] = n - nowN;
        int diff = calculate(aPeach);
        if (diff > 0) {
            if (diff > maxDiff) {
                flag = true;
                maxDiff = diff;
                answer = lion;
            } else if (diff == maxDiff) {
                for (int i = 10; i > -1; i--) {
                    if (answer[i] < lion[i]) {
                        answer = lion;
                        break;
                    }
                    if (answer[i] > lion[i]) break;
                }
            }
        }
        lion[10] = 0;
        return;
    }
    
    backTracking(aPeach, idx+1, nowN, n);
    if (aPeach[idx] + 1 + nowN <= n) {
        lion[idx] = aPeach[idx]+1;
        backTracking(aPeach, idx+1, aPeach[idx] + 1 + nowN, n);
        lion[idx] = 0;
    }
}

vector<int> solution(int n, vector<int> info) {
    answer.clear();
    maxDiff = -1;
    
    lion.assign(11, 0);
    flag = false;
    backTracking(info, 0, 0, n);
    
    if (flag) {
        return answer;
    } else {
        return {-1};
    }
}