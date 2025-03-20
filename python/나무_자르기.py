import sys
input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))

max_height = max(trees)
min_height = 0

while min_height <= max_height:
    mid = (max_height + min_height) // 2
    cut = 0
    for tree in trees:
        if tree > mid:
            cut += tree - mid
    if cut >= m:
        min_height = mid + 1
    else:
        max_height = mid - 1

print(max_height)
