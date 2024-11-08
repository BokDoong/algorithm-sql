# Input
words = input()
stack = []
result = []

# Main
w = 0
while w < len(words):
  if words[w] == '<':
    while len(stack) > 0:
      result.append(stack.pop())
    while words[w] != '>':
      result.append(words[w])
      w += 1
    result.append(words[w])
  elif words[w] == ' ':
    while len(stack) > 0:
      result.append(stack.pop())
    result.append(' ')
  else:
    stack.append(words[w])
      
  w += 1
  
while len(stack) > 0:
  result.append(stack.pop())
print(''.join(result))