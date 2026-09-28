#include <bits/stdc++.h>

using namespace std;

// 사전 초기화
vector<string> dictionary;
void backTracking(string val, string alphabets) {
    if (val.size() == 5) return;
    for (int i = 0; i < 5; i++) {
        val.push_back(alphabets[i]);
        dictionary.push_back(val);
        backTracking(val, alphabets);
        val.pop_back();
    }
}

// 반복문으로 찾으면 될듯?
int solution(string word) {
    dictionary.clear();
    backTracking("", "AEIOU");
    for (int i = 0; i < dictionary.size(); i++) {
        if (word == dictionary[i]) return i+1;
    }
    return 0;
}