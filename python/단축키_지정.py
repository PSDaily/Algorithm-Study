import sys
input = sys.stdin.readline

n = int(input().strip())
l = [input().rstrip() for _ in range(n)]

used = set()

for i in range(n):
    splitted = l[i].split()
    flag = False

    for j in range(len(splitted)):
        first_char = splitted[j][0].lower()
        if first_char not in used:
            used.add(first_char)
            splitted[j] = f"[{splitted[j][0]}]{splitted[j][1:]}"
            l[i] = " ".join(splitted)
            flag = True
            break

    if not flag:
        for j in range(len(l[i])):
            char = l[i][j].lower()
            if char != ' ' and char not in used:
                used.add(char)
                l[i] = l[i][:j] + f"[{l[i][j]}]" + l[i][j+1:]
                break

for line in l:
    print(line)
