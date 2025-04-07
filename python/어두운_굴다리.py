import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
x = list(map(int, input().split()))

left = 0
right = n

def possible(mid):
    if x[0] > mid:
        return False
    if x[-1] + mid < n:
        return False
    for i in range(1, m):
        if x[i] - x[i-1] > mid*2:
            return False
    return True

while left + 1 < right:
    mid = (left + right) // 2
    if possible(mid):
        right = mid
    else:
        left = mid

    
print(right)
