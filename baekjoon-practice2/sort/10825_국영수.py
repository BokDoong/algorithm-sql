import sys
input = sys.stdin.readline

N = int(input().rstrip())
students = []
for _ in range(N):
  students.append(list(input().split()))

students.sort(key = lambda x : (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
for student in students:
  print(student[0])