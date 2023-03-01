def verifyLeapYear():
    year = int(input('Introduce the year: '))
    div = year / 100
    if (year % 4 == 0 and div != int(div)):
        print('The year is a leap year')
    else:
        print('The year is not a leap year')


def leapYear():
    print('Options:')
    print(' 1 = Verify is a year is leap on no')
    print(' 2 = Exit')
    print()
    option = input('Introduce an option: ')
    while (option != '2'):
        verifyLeapYear()
        option = input('Introduce an option: ')


leapYear()
