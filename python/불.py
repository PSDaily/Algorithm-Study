import sys
input = sys.stdin.readline
from collections import deque

r, c = map(int, input().split())
l = [list(input().rstrip()) for _ in range(r)]
q = deque()

# 지훈이를 먼저 큐에 넣어주기 위해 for문 2번 나눠서 -> 지훈이를 먼저 움직인게 문제였음 

for i in range(r):
    for j in range(c):
        if l[i][j] == 'F':
            q.append((i,j,-1))

for i in range(r):
    for j in range(c):
        if l[i][j] == 'J':
            q.append((i,j,0))
            break

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

while q:
    x, y, time_or_fire = q.popleft()
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < r and 0 <= ny < c:
            if time_or_fire == -1:
                if l[nx][ny] != '#' and l[nx][ny] != 'F':
                    l[nx][ny] = 'F'
                    q.append((nx,ny,-1))
            else:
                if l[nx][ny] == '.':
                    l[nx][ny] = 'J'
                    q.append((nx,ny,time_or_fire+1))

        elif time_or_fire != -1:
            print(time_or_fire+1)
            exit()

print("IMPOSSIBLE")
    
