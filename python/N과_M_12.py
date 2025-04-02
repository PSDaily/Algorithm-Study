import sys
input = sys.stdin.readline

from itertools import combinations_with_replacement

n, m = map(int, input().split())
l = set(map(int, input().split()))

cand = list(combinations_with_replacement(l, m))
ans = []

for el in cand:
    ans.append(sorted(el))

for el in sorted(ans):
    print(*el)