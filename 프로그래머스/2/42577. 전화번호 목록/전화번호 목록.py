def solution(phone_book):
    phoneBook = sorted(phone_book)
    books = (False,{})
    for nums in phoneBook:
        node = books
        for i in range(len(nums)):    # 글자 하나씩 갖고오기, 123 : 1->2->3
            if node[0] == True:
                return False        # 이미 접두사인적이 있다면 끝
            else:
                num = nums[i]
                if num in node[1]:
                    node = node[1][num]
                else:
                    if i == len(nums)-1:          
                        node[1][num] = (True,{})
                    else:
                        node[1][num] = (False,{})
                    node = node[1][num]
    return True