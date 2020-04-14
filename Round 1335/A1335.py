n = int(input())
for i in range(n):
    a = int(input())
    if( a%2 == 0 ):
        a-=1
        print(a//2)
    else:
        print(a//2)
