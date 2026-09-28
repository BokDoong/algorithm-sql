#include <bits/stdc++.h>

using namespace std;

// course에 담긴 원소들의 글자수에서 가장 많이 카운팅된 조합을 중복해서 리턴
// 2번 이상 나왔어야함.
// result는 알파벳순, 각 조합도 알파벳순

// orders 내에 문자를 알파벳 순으로 정렬
// Map<조합 문자, 횟수>
// orders 내에 문자 순회하며 > 백트래킹으로 전체 조합 계산 > Map에다가 카운팅

// course 순회하며 각 자릿수 > Map 순회하며 횟수가 2번 이상이면 가장 큰 길이 갱신 + 리스트 갱신, 같다면 추가 > 최종 결과 result에 추가
// results 알파벳 순으로 정렬 

void backTracking(string order, map<string, int>& cntMap, string val, int idx) {
    for (int i = idx; i < order.size(); i++) {
        val += order[i];
        if (val.size() != 1) cntMap[val]++;
        backTracking(order, cntMap, val, i+1);
        val.pop_back();
    }
}

void calculate(int length, map<string, int>& cntMap, vector<string>& answer) {
    int maxValue = 0;
    vector<string> tmpAnswer;
    
    for (auto& [k, v] : cntMap) {
        if (k.size() == length) {
            if (v > maxValue) {
                maxValue = v;
                tmpAnswer.clear();
                tmpAnswer.push_back(k);
            } else if (v == maxValue) {
                tmpAnswer.push_back(k);
            }
        }
    }
    
    if (maxValue > 1) {
        for (int i = 0; i < tmpAnswer.size(); i++) {
            answer.push_back(tmpAnswer[i]);
        }
    }
}

vector<string> solution(vector<string> orders, vector<int> course) {
    
    for (int i = 0; i < orders.size(); i++) {
        sort(orders[i].begin(), orders[i].end());
    }
    
    map<string, int> cntMap;
    for (int i = 0; i < orders.size(); i++) {
        backTracking(orders[i], cntMap, "", 0);
    }
    
    vector<string> answer;
    for (int i = 0; i < course.size(); i++) {
        calculate(course[i], cntMap, answer);
    }
    
    sort(answer.begin(), answer.end());
    return answer;
}