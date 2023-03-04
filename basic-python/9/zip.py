def main():
    # Using zip
    courses = ['java', 'python', 'css', 'html']
    order = [1, 2, 3, 4]

    resultZip = zip(courses, order)
    print('Zipped:', list(resultZip))

    # Using any
    numbers = [1 == 1, 2 == 3, 3 == 4]
    resultAny = any(numbers)
    print('Any:', resultAny)
    # Using all
    numbers = [1 == 1, 2 == 2, 3 == 3]
    resultAll = all(numbers)
    print('All: ', resultAll)
    # Using sum
    numbers = [1, 2, 3, 4, 5]
    print('Sum:', sum(numbers))
    # Using min
    print('Min:', min(numbers))
    # Using max
    print('Max:', max(numbers))
    # Using round
    num = 3.145667687
    print('Rounded to 3 values after the come:', round(num, 3))
    print('Rounded to 2 values after the come:', round(num, 2))
    print('Rounded to 1 values after the come:', round(num, 1))
    # Using pow
    print('Pow:', pow(3, 2))
    # Using sorted
    numbers = [6, 7, 3, 1, 4, 2,  5]
    print(sorted(numbers))
    print(sorted(numbers, reverse=True))
    print(sorted(numbers, reverse=True, key=lambda x: x > 2))

if __name__ == '__main__':
    main()
