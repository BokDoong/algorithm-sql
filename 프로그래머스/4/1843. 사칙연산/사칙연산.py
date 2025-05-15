# 최댓값, 최솟값
M, m = {}, {}

def solution(arr):
    # 숫자, 연산자
    nums = [int(x) for x in arr[::2]]
    ops = [x for x in arr[1::2]]
    # 최대값, 최소값
    for i in range(len(nums)):
        M[(i,i)] = nums[i]
        m[(i,i)] = nums[i]
        
    # DP
    for d in range(1, len(nums)):
        for i in range(len(nums)):
            j = i + d
            if j >= len(nums):
                continue
                
            maxCandidates, minCandidates = [], []
            for k in range(i+1, j+1):
                if ops[k-1] == '-':
                    mx = M[(i, k-1)] - m[(k, j)]
                    mn = m[(i, k-1)] - M[(k, j)]
                    maxCandidates.append(mx)
                    minCandidates.append(mn)
                else:
                    mx = M[(i,k-1)] + M[(k,j)]
                    mn = m[(i,k-1)] + m[(k,j)]
                    maxCandidates.append(mx)
                    minCandidates.append(mn)
                    
            M[(i,j)] = max(maxCandidates)
            m[(i,j)] = min(minCandidates)
    return M[(0, len(nums)-1)]