def solution(array, commands):
    answer = []
    for start, end, idx in commands:
        nums = array[start-1:end]
        nums.sort()
        answer.append(nums[idx-1])
    
    return answer