t = int(input())
for _ in range(t):
    l, r = list(map(int, input().split()))
    for i in range(l, r+1):
        data = []
        for num in str(i):
            data.append(num)
    data.sort()
    print(data)
