# Main
main = list(input())
sub = []
t = int(input())

for _ in range(t):
  commands = list(input().split())
  if commands[0] == 'P':
    main.append(commands[1])
  elif commands[0] == 'L':
    if len(main) > 0:
      sub.append(main.pop())
  elif commands[0] == 'D':
    if len(sub) > 0:
      main.append(sub.pop())
  elif commands[0] == 'B':
    if len(main) > 0:
      main.pop()
      
main.extend(reversed(sub))
print(''.join(main))