import sys
input = sys.stdin.readline

n, m = map(int, input().split())
memo_keyword = set(input().rstrip() for _ in range(n))

for _ in range(m):
    keywords = input().rstrip().split(",")
    for keyword in keywords:
        if keyword in memo_keyword:
            memo_keyword.remove(keyword)
    
    print(len(memo_keyword))
        
    
