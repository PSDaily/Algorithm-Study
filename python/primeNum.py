from itertools import permutations
import math

# 소수 판정 함수
'''
- 2미만은 소수 아님: false
- 2는 소수: true
- 짝수 걸러내기(2를 제외한 짝수): false
- 홀수는 나눗셈 검사(루트 x의 정수부를 구하고, 그 이하의 홀수로 나눠보고 나누어 떨어지면 합성수: false)
'''


def is_prime(x: int) -> bool:
    if x < 2:
        return False
    if x == 2:
        return True
    if x % 2 == 0:
        return False
    r = int(math.isqrt(x))
    for d in range(3, r + 1, 2):
        if x % d == 0:
            return False
    return True


def solution(numbers: str) -> int:
    nums = list(numbers)
    made = set()
    answer = 0

    # 길이 1~n까지 모든 순열로 정수 만들기
    for k in range(1, len(nums) + 1):
        for p in permutations(nums, k):
            made.add(int(''.join(p)))

    answer = sum(1 for v in made if is_prime(v))

    return answer