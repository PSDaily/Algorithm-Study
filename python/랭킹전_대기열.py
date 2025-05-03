import sys
input = sys.stdin.readline

from collections import defaultdict

p, m = map(int, input().split())

players = []
for _ in range(p):
    l, n = input().split()
    players.append((int(l), n))

rooms = []

for level, nickname in players:
    entered = False
    for room in rooms:
        standard = room['standard']
        players_list = room['players']
        if len(players_list) < m and (standard - 10 <= level <= standard + 10):
            players_list.append((level, nickname))
            entered = True
            break
    if not entered:
        rooms.append({'standard': level, 'players': [(level, nickname)]})

for room in rooms:
    players_list = room['players']
    players_list.sort(key=lambda x: x[1])
    if len(players_list) == m:
        print("Started!")
    else:
        print("Waiting!")
    for level, nickname in players_list:
        print(level, nickname)
        
