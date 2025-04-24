def solution(number, k):
    stack = []
    for n in number:
        while k > 0 and len(stack) > 0 and stack[-1] < n:
            k -= 1
            stack.pop()
        stack.append(n)
    if k:
        return ''.join(stack[:-k])
    else:
        return ''.join(stack)