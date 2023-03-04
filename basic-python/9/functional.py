from functools import reduce


def main():

    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    # Filter Using a function
    filterUsingFunction(numbers)
    # Filter Using a lambda
    filterUsingLambda(numbers)
    # Map Using a function
    mapUsingFunction(numbers)
    # Map Using a lambda
    mapUsingLambda(numbers)
    # Reduce Using a function
    reduceUsingFunction(numbers)
    # Reduce Using a lambda
    reduceUsingLambda(numbers)


# Filters
def filterUsingFunction(numbers):
    result = filter(even, numbers)
    print('Filter Using Function:', list(result))


def even(x):
    return x % 2 == 0


def filterUsingLambda(numbers):
    result = filter(lambda x: x % 2 == 0, numbers)
    print('Filter Using Lambda:', list(result))


# Map
def mapUsingFunction(numbers):
    result = map(square, numbers)
    print('Map Using Function:', list(result))


def square(x):
    return x * x


def mapUsingLambda(numbers):
    result = map(lambda x: x * x, numbers)
    print('Map Using Lambda:', list(result))


# Reduce
def reduceUsingFunction(numbers):
    result = reduce(sum, numbers)
    print('Reduce Using Function:', result)


def sum(a, b):
    # See how it works
    print(f'a={a} - b={b}')
    return a + b


def reduceUsingLambda(numbers):
    result = reduce(lambda a, b: a + b, numbers)
    print('Reduce Using Lambda:', result)


if __name__ == '__main__':
    main()
