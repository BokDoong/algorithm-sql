#백준 20327 배열돌리기 6
from copy import deepcopy
N,R=map(int,input().split())
room=[list(map(int,input().split()))for _ in range(2**N)]
dx=[0,1,0,-1]
dy=[1,0,-1,0]
dx2=[1,0,-1,0]
dy2=[0,1,0,-1]

do=[]
for _ in range(R):
    k,l=map(int,input().split())
    do.append([k,l])

#연산
#1 상하 반전 2 좌우반전 3오른쪽 90도 회전 4 왼쪽 90도 회전
#5 배열 상하반전 #6 배열 좌우반전 #7 배열 오른쪽 90도 #8 배열 90도 회전

def cal(k,l):
    global room
    # 배열 부분요소
    if k<=4:
        if l==0:
            return
        else:
            #시작점 정하기
            for x in range(0,2**N,2**l):
                for y in range(0,2**N,2**l):
                    #1번연산-->상하반전
                    if k==1:
                        for a in range(2**(l-1)):
                            for b in range(2**l):
                                room[x+a][y+b],room[x+2**l-a-1][y+b]=room[x+2**l-a-1][y+b],room[x+a][y+b]

                    #2번연산-->좌우반전
                    elif k==2:
                        for b in range(2**(l-1)):
                            for a in range(2**l):
                                room[x+a][y+b],room[x+a][y+2**l-b-1]=room[x+a][y+2**l-b-1],room[x+a][y+b]

                    #3번연산-->오른쪽 90
                    elif k==3:
                        #먼저 임시로 배열을 받아준다.
                        tmp=[]
                        for a in range(2**l):
                            temp=[]
                            for b in range(2**l):
                                temp.append(room[x+a][y+b])
                            tmp.append(temp)
                        new=[[0]*2**l for _ in range(2**l)]
                        for a in range(2**l):
                            for b in range(2**l):
                                new[b][2**l-a-1]=tmp[a][b]

                        for a in range(2**l):
                            for b in range(2**l):
                                room[x+a][y+b]=new[a][b]


                    #4번연산-->왼쪽 90
                    elif k==4:
                        #먼저 임시로 배열을 받아준다.
                        tmp=[]
                        for a in range(2**l):
                            temp=[]
                            for b in range(2**l):
                                temp.append(room[x+a][y+b])
                            tmp.append(temp)
                        new=[[0]*2**l for _ in range(2**l)]
                        for a in range(2**l):
                            for b in range(2**l):
                                new[2**l-b-1][a]=tmp[a][b]

                        for a in range(2**l):
                            for b in range(2**l):
                                room[x+a][y+b]=new[a][b]


    #배열전체
    elif k>=5 and k<=8:
        #우선 배열을 먼저 받아보자
        ba=[]
        for x in range(0, 2 ** N, 2 ** l):
            temp=[]
            for y in range(0, 2 ** N, 2 ** l):
                tmp=[[0]*2**l for _ in range(2**l)]
                for a in range(2**l):
                    for b in range(2**l):
                        tmp[a][b]=room[x+a][y+b]

                temp.append(tmp)
            ba.append(temp)
        ba_x=len(ba)
        ba_y=len(ba[0])


        #배열 상하반전
        if k==5:
            for a in range(ba_x//2):
                for b in range(ba_y):
                    ba[a][b],ba[ba_x-a-1][b]=ba[ba_x-a-1][b],ba[a][b]


        #배열 좌우반전
        elif k==6:
            for b in range(ba_y//2):
                for a in range(ba_x):
                    ba[a][b],ba[a][ba_y-b-1]=ba[a][ba_y-b-1],ba[a][b]
        #배열 오른쪽 90도 회전
        elif k==7:
            new=deepcopy(ba)
            for a in range(ba_x):
                for b in range(ba_y):
                    new[b][ba_x-a-1]=ba[a][b]
            ba=new

        #베열 왼쪽 90도 회전
        elif k==8:
            new=deepcopy(ba)
            for a in range(ba_x):
                for b in range(ba_y):
                    new[ba_y-b-1][a]=ba[a][b]
            ba=new

        #다 계산하고 넣어주기
        for a in range(ba_x):
            for b in range(ba_y):

                now = ba[a][b]

                put_x = (2 ** l) * a
                start_y = (2 ** l) * b
                put_y = start_y
                p = 0

                for x in range(2 ** l):
                    for y in range(2 ** l):
                        put = now[x][y]
                        room[put_x][put_y] = put
                        put_y += 1
                        p += 1
                        if p == 2 ** l:
                            put_y = start_y
                            p = 0
                            put_x+=1


for i in range(R):
    k,l=do[i]
    cal(k,l)

for i in range(2**N):
    for j in range(2**N):
        print(room[i][j],end=' ')
    print()