from functools import reduce


def main():

    entry = input('Enter the list of numbers: ').split(' ')

    numberList = mapping(entry)

    evenList = filtering(numberList)

    resultSum = reducing(evenList)

    print(resultSum)


def mapping(entry):
    return map(lambda x: int(x), entry)


def filtering(numbers):
    return filter(lambda x: x % 2 != 0, numbers)


def reducing(numbers):
    return reduce(lambda x, y: x + y, numbers)


if __name__ == '__main__':
    main()
