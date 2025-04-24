import sys
input = sys.stdin.readline

from collections import defaultdict
from bisect import bisect_left

level_dict = defaultdict(list)
levels = []

n, m = map(int, input().split())

for _ in range(n):
    nickname, level = input().rstrip().split()
    if level_dict[int(level)]:
        continue
    level_dict[int(level)] = nickname
    levels.append(int(level))

for _ in range(m):
    character_level = int(input().rstrip())
    index = bisect_left(levels, character_level)
    print(level_dict[levels[index]])

