import sys
input = sys.stdin.readline

n = input().rstrip()

ans = 0
index = 0

while True:
    ans += 1
    for element in str(ans):
        if n[index] == element:
            index += 1
        if index == len(n):
            print(ans)
            exit()
        
