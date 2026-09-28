#include <bits/stdc++.h>

using namespace std;

bool visited[10];
set<int> primeNumbers;

bool isPrime(int x) {
    if (x < 2) return false;
    for (int i = 2; (int)i * i <= x; i++)
        if (x % i == 0) return false;
    return true;
}

void backTracking(string numbers, bool visited[], string value) {
    for (int i = 0; i < numbers.size(); i++) {
        if (visited[i]) continue;
        
        value.push_back(numbers[i]);
        visited[i] = true;
        int target = stoi(value);
        if (primeNumbers.count(target) == 0 && isPrime(target)) primeNumbers.insert(target);
        
        backTracking(numbers, visited, value);
        visited[i] = false;
        value.pop_back();
    }
}

int solution(string numbers) {
    primeNumbers.clear();
    memset(visited, false, sizeof visited);
    backTracking(numbers, visited, "");
    return primeNumbers.size();
}