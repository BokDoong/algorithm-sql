import heapq

def solution(genres, plays):
    # 장르별 곡, 조회수 정보
    songsInfo = {}
    totalInfo = {}
    for i in range(len(genres)):
        if genres[i] in songsInfo:
            totalInfo[genres[i]] += plays[i]
            heapq.heappush(songsInfo[genres[i]], (plays[i]*-1, i))
        else:
            totalInfo[genres[i]] = plays[i]
            tmp = []
            heapq.heappush(tmp, (plays[i]*-1, i))
            songsInfo[genres[i]] = tmp
    
    # 하나씩 뽑기
    answer = []
    totalInfo = sorted(totalInfo.items(), key = lambda item:-item[1])
    for info, cnt in totalInfo:
        if len(songsInfo[info]) == 1:
            answer.append(heapq.heappop(songsInfo[info])[1])
        elif len(songsInfo[info]) >= 2:
            answer.append(heapq.heappop(songsInfo[info])[1])
            answer.append(heapq.heappop(songsInfo[info])[1])
    return answer