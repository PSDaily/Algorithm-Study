'''
나무 M미터가 필요
절단기의 높이 H
나무의 수 N
가져가는 나무의 길이 K = 나무의 높이 - H 의 합
M K의 크기를 비교
- M > K: H를 줄여
- M < K: H를 늘려!

출력: H

나무의 높이는 최대 1,000,000,000 그래서 완전탐색은 안돼!
'''

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


