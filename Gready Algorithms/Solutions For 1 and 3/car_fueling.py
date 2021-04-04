# python3


def compute_min_number_of_refills(stops, n, l):
    numberOfRefills=0
    currentRefill=0
    while currentRefill<=n:
        lastRefill=currentRefill
        while currentRefill<=n and stops[currentRefill+1]-stops[lastRefill]<=l:
            currentRefill=currentRefill+1
        if currentRefill==lastRefill:
            return -1
        if currentRefill<=n:
            numberOfRefills=numberOfRefills+1
    return numberOfRefills


if __name__ == '__main__':
    input_d = int(input())
    input_m = int(input())
    input_n = int(input())
    input_stops =list(map(int, input().split()))
    input_stops.insert(0,0)
    input_stops.append(input_d)
    print(compute_min_number_of_refills(input_stops, input_n, input_m))
