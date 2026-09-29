#include <bits/stdc++.h>

using namespace std;

// Map<차량번호, 시간(분)>에 차량마다 주차 시간 모두 더하기
// - Map<차량번호, 입차시간(분)>에 차량마다 입차한 시간 넣어두고 OUT이면 꺼내서 쓰고 > 없애기
// - Map<차량번호, 입차시간(분)>에 남아있다면 23:59에서 빼기

// Map<차량번호, 시간(분)>에서 하나씩 빼서 계산하기

map<string, int> recordMap;
map<string, int> answer;

void initialize(vector<string>& records) {
    
    map<string, int> inTimeMap;
    for (int i = 0; i < records.size(); i++) {
        string time = records[i].substr(0,5);
        string carNum = records[i].substr(6, 4);
        string log = records[i].substr(11, records[i].size() - 11);
        
        int minutes = stoi(time.substr(0, 2))*60 + stoi(time.substr(3, 5));
        if (log == "IN") {
            inTimeMap[carNum] = minutes;
        } else {
            if (recordMap.count(carNum) == 1) recordMap[carNum] += minutes - inTimeMap[carNum];
            else recordMap[carNum] = minutes - inTimeMap[carNum];
            inTimeMap.erase(carNum);
        }
    }
    
    for (auto [k, v] : inTimeMap) {
        if (recordMap.count(k) == 1) recordMap[k] += (23*60 + 59) - v;
        else recordMap[k] = (23*60 + 59) - v;
    }
}

// fees : 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
// records : 시각(시:분)	차량 번호	내역
vector<int> solution(vector<int> fees, vector<string> records) {
    recordMap.clear();
    initialize(records);
    
    int basicTime = fees[0];
    int basicFee = fees[1];
    int unitTime = fees[2];
    int unitFee = fees[3];
    
    answer.clear();
    for (auto [k, v] : recordMap) {
        if (v < basicTime) answer[k] = basicFee;
        else {
            int extraUnit = 0;
            if ((v - basicTime)%unitTime > 0) extraUnit += 1;
            extraUnit += ((v - basicTime)/unitTime);
            answer[k] = basicFee + (unitFee*extraUnit);
        }
    }
    
    vector<int> realAnswer;
    for (auto [k, v] : answer) realAnswer.push_back(v);
    return realAnswer;
}