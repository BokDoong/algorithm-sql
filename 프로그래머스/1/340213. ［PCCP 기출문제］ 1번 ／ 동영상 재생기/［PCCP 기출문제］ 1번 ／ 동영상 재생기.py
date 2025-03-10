def solution(video_len, pos, op_start, op_end, commands):
    # 스킵
    def skip(t):
        if op_start <= t < op_end:
            return op_end
        return t
    
    # 시간 계산
    def strToSec(s):
        mm, ss = map(int, s.split(":"))
        return mm*60+ss
    
    # 시간으로
    def secToStr(t):
        mm, ss = divmod(t,60)
        return f'{mm:02d}:{ss:02d}'
    
    # 계산
    video_len, pos, op_start, op_end = map(strToSec, [video_len, pos, op_start, op_end])
    pos = skip(pos)
    for com in commands:
        if com == "prev":
            pos = max(0, pos-10)
        else:
            pos = min(video_len, pos+10)
        pos = skip(pos)
    
    answer = secToStr(pos)
    return answer