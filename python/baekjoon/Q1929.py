m,n=map(int,input().split())

for i in range(m,n+1):
    if i<2:
        continue
    for j in range(2,i):
        if i%j==0:
            break
    else:
        print(i)