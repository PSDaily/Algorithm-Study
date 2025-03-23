import sys
input = sys.stdin.readline

n, m, l, k = map(int, input().split())
stars = [tuple(map(int, input().split())) for _ in range(k)]

max_count = 0

for i in range(k):
    x_start = stars[i][0]
    for j in range(k):
        y_start = stars[j][1]
        cnt = 0
        x_end = x_start + l
        y_end = y_start + l
        for (x, y) in stars:
            if x_start <= x <= x_end and y_start <= y <= y_end:
                cnt += 1
        
        max_count = max(max_count, cnt)

print(k - max_count)
