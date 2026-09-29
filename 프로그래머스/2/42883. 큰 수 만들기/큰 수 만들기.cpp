#include <bits/stdc++.h>  

using namespace std;

// 일단 넣는데
// 앞에 나보다 작은 것들은 다뺀다. 뺀 개수에 더함.
// 끝나지 않았는데 k를 이미 뺐다면 뒤에꺼 그대로 붙이기
// 끝났는데 k보다 덜 제거했으면 맨 뒤에서 (k-현재 뺀수)만큼 제거하기

string solution(string number, int k) {
    string answer = "";
    
    int idx = 0;
    while (idx < number.size()) {
        int target = number[idx] - '0';
        bool isEnd = false;
        for (int i = answer.size()-1; i >= 0; i--) {
            if (answer[i] - '0' < target) {
                answer.pop_back();
                k--;
                if (k == 0) {
                    isEnd = true;
                    break;
                }
            } else {
                break;
            }
        }
        answer.push_back(number[idx]);
        if (isEnd) break;
        idx++;
    }
    
    idx++;
    while (idx < number.size()) {
        answer.push_back(number[idx]);
        idx++;
    }
    
    if (k > 0) {
        answer = answer.substr(0, answer.size() - k);
    }
    
    return answer;
}