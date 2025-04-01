import sys
input = sys.stdin.readline

from collections import defaultdict
import heapq

n, m, r = map(int, input().split())
# 인덱스 -1 까먹지 말기
items = list(map(int, input().split()))

# 이건 그냥 숫자가 노드번호
graph = defaultdict(list)
for _ in range(r):
    a, b, road_length = map(int, input().split())
    graph[a].append((b, road_length))
    graph[b].append((a, road_length))
    
ans = 0

for i in range(1, n + 1):
    cost_map = [int(1e9)] * (n + 1)
    q = []
    heapq.heappush(q, (0,i))
    cost_map[i] = 0
    while q:
        current_cost, current_node = heapq.heappop(q)
        if cost_map[current_node] < current_cost:
            continue
        for next_node, next_cost in graph[current_node]:
            if current_cost + next_cost < cost_map[next_node]:
                cost_map[next_node] = current_cost + next_cost
                heapq.heappush(q, (cost_map[next_node], next_node))
            
    temp = 0
    for index ,cost in enumerate(cost_map):
        if cost <= m:
            temp += items[index - 1]
            
    ans = max(ans, temp)

print(ans)