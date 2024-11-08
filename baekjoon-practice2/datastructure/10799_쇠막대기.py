# Input
words = input()
w = 0
sticks = 0
result = 0

# Main
while w < len(words):
  if words[w] == '(':
    if words[w+1] == ')':
      result += sticks
      w += 1
    else:
      result += 1
      sticks += 1
  else:
    sticks -= 1 
  w += 1
  
print(result)