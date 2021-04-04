# python3


def money_change(money):
    result =0
    while money>0:
        if money>=10:
            money=money-10
        elif money>=5:
            money=money-5
        else:
            money=money-1
        result=result+1
    return result


if __name__ == '__main__':
    input_money = int(input())
    print(money_change(input_money))
