def solution(participant, completion):
    participantDict = {}
    for p in participant:
        if p in participantDict:
            participantDict[p] += 1
        else:
            participantDict[p] = 1
    
    for c in completion:
        if c in participantDict and participantDict[c] == 1:
            del participantDict[c]
        else:
            participantDict[c] -= 1
            
    return list(participantDict.keys())[0]