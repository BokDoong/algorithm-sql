results = []
dwarfs = []
for _ in range(9):
  dwarfs.append(int(input()))
  
def dfs(depth, start):
  if depth == 7:
    if sum(results) == 100:
      for num in sorted(results):
        print(num)
      exit()
    else:
      return

  for i in range(start, 9):
    results.append(dwarfs[i])
    dfs(depth+1, start+1)
    results.pop()
    
dfs(1,1)