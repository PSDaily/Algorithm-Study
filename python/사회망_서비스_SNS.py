import sys
input = sys.stdin.readline


sys.setrecursionlimit(10**9)

n = int(input())
graph = [[] for _ in range(n + 1)]
dp = [[0, 0] for _ in range(n + 1)] 

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n + 1)

def dfs(current):
    global dp
    visited[current] = True
    
    dp[current][1] += 1
    for child in graph[current]:
        if not visited[child]:
            dfs(child)
            dp[current][0] += dp[child][1]
            dp[current][1] += min(dp[child][0], dp[child][1])

dfs(1)
print(min(dp[1][0], dp[1][1]))