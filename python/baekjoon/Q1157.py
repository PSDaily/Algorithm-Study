word=input().upper()
counts={}

for i in range(len(word)):
    ch=word[i]
    counts[ch]=counts.get(ch,0)+1
    
max_count=max(counts.values())
frequent= [k for k, v in counts.items() if v == max_count]

if len(frequent) > 1:
    print('?')
else:
    print(frequent[0])
