import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
locations = [list(map(int, input().split())) for _ in range(n)]

dxy = [(1, 0), (0, -1), (-1, 0), (0, 1)]

all_points = []

for x, y, d, g in locations:
    directions = [d]
    for generation in range(g):
        for i in range(len(directions)-1, -1, -1):
            directions.append((directions[i] + 1) % 4)
    
    all_points.append((x, y))
    for direction in directions:
        all_points.append((all_points[-1][0] + dxy[direction][0], all_points[-1][1] + dxy[direction][1]))
        

all_points = set(all_points)

answer = 0
for i in range(100):
    for j in range(100):
        if (i, j) in all_points and (i+1, j) in all_points and (i, j+1) in all_points and (i+1, j+1) in all_points:
            answer += 1
print(answer)
