def solution(sizes):
    '''
    입력으로 들어온 w, h 중에서 더 큰걸 w로 설정
    그때 그때 max_w와 max_h 설정
    answer = max_w * max_h
    '''
    max_w, max_h = 0, 0
    answer = 0

    for w, h in sizes:
        if w < h:
            w, h = h, w
        if w > max_w:
            max_w = w
        if h > max_h:
            max_h = h

    answer = max_w * max_h
    return answer