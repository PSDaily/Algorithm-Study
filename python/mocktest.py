def solution(answers):
    answer = []

    supo1 = [1, 2, 3, 4, 5]
    supo2 = [2, 1, 2, 3, 2, 4, 2, 5]
    supo3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    scores = [0, 0, 0]

    # 이제 돌아가면서 채점하자
    for idx, answer in enumerate(answers):
        if answer == supo1[idx % len(supo1)]:
            scores[0] += 1
        if answer == supo2[idx % len(supo2)]:
            scores[1] += 1
        if answer == supo3[idx % len(supo3)]:
            scores[2] += 1

    # 최고득점자를 가리자!
    max_score = max(scores)

    # 채점 결과를 출력
    answer = [ i+1 for i, score in enumerate(scores) if score == max_score ]

    return answer