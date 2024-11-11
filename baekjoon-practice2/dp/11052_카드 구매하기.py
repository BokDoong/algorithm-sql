import copy

# Input
target = int(input())
card = [0]
card.extend(list(map(int,input().split())))
result = copy.deepcopy(card)

# Main
for n in range(2, target+1):
  for i in range(1, n):
    result[n] = max(result[n], card[i]+result[n-i])
  
# Output
print(result[target])