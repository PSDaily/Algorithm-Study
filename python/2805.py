import sys

def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    trees = list(map(int, input().split()))

    low, high = 0, max(trees) #H의 범위
    H = 0

    while low <= high:
        mid = (low + high) // 2
        K = 0
        for h in trees: #지금 설정한 mid 값으로 나무 잘라보기
            if h >= mid:
                K += h - mid
        if  K == M: #개이득!
            H = mid
            break
        elif K > M: #환경 낭비 -> H를 늘려
            H = mid
            low = mid + 1
        else: #부족해!
            high = mid - 1

    print(H)

if __name__ == "__main__":
    main()