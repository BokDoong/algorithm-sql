def solution(nums):
    counts = len(nums) // 2
    nums = set(nums)
    types = len(nums)
    
    if types >= counts:
        return counts
    else:
        return types