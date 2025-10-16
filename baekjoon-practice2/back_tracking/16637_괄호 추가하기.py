import sys
input = sys.stdin.readline

def calculate(num1, op, num2):
    if op == '+':
        return num1 + num2
    elif op == '-':
        return num1 - num2
    else:  # op == '*'
        return num1 * num2

def solve(idx, current_value):
    global result, numbers, operators
    
    # 모든 숫자를 다 사용한 경우
    if idx >= len(numbers):
        result = max(result, current_value)
        return
    
    # 현재 연산자 위치
    op_idx = idx - 1
    
    if op_idx < 0:
        # 첫 번째 숫자인 경우
        solve(idx + 1, numbers[idx])
        return
    
    # 1. 괄호를 추가하지 않는 경우: 왼쪽부터 순서대로 계산
    next_value = calculate(current_value, operators[op_idx], numbers[idx])
    solve(idx + 1, next_value)
    
    # 2. 괄호를 추가하는 경우: 오른쪽 연산을 먼저 계산
    if idx + 1 < len(numbers):
        # 오른쪽 연산 먼저 수행
        right_value = calculate(numbers[idx], operators[idx], numbers[idx + 1])
        # 현재 값과 오른쪽 계산 결과를 연산
        next_value = calculate(current_value, operators[op_idx], right_value)
        # 오른쪽 연산을 이미 수행했으므로 idx + 2로 이동
        solve(idx + 2, next_value)

N = int(input().strip())
expression = input().rstrip()

# 숫자와 연산자를 분리
numbers = []
operators = []

for i in range(N):
    if i % 2 == 0:
        numbers.append(int(expression[i]))
    else:
        operators.append(expression[i])

result = float('-inf')
solve(0, 0)
print(result)
