# Mode of work with files

# r - read (Read the file only)
# a - append (Start to write at the end of itself)
# w - write (Overwrite all the file, start to write at the beguinig of itself)
# x - create ()
# t - text (Is for text)
# b - binary (Is for binary)
# + - plus

# Most used
# r, w+, a+

import sys

filePath = sys.path[0].replace('"\"', '/') + "/users.txt"


def main():
    # Exe 1
    resultFor = listUsersUsingFor()
    for user in resultFor:
        print(f'User: {user}')

    # Exe 2
    resultFor = listUsersUsingWhile()
    for user in resultFor:
        print(f'User: {user}')


def listUsersUsingFor():
    file = open(filePath, 'r')
    resultList = []

    for line in file:
        stripLine = line.strip()

        if (stripLine.startswith('#') or stripLine.startswith('_') or len(stripLine) == 0):
            continue

        resultList.append(stripLine.split(':')[0])

    file.close()

    return resultList


def listUsersUsingWhile():
    file = open(filePath, 'r')
    allLines = file.readlines()
    file.close()
    resultList = []

    for line in allLines:
        stripLine = line.strip()

        if (stripLine.startswith('#') or stripLine.startswith('_') or len(stripLine) == 0):
            continue

        resultList.append(stripLine.split(':')[0])

    return resultList


if __name__ == '__main__':
    main()
