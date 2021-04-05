# python3


def fibonacci_number_naive(n):
    assert 0 <= n <= 45

    if n <= 1:
        return n

    return fibonacci_number_naive(n - 1) + fibonacci_number_naive(n - 2)
def fibonacci_number(n):
    arr = [0,1]
    for i in range(2,n+1):
        arr.append(arr[i - 1] + arr[i - 2])
    return arr[n];

    return 0;



if __name__ == '__main__':
    input_n = int(input())
    print(fibonacci_number(input_n))
