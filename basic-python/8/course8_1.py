import os.path as op


def main():
    filePath = './/open-bootcamp-course/basic-python/8/course8_1.txt'

    createFile(filePath)

    data = ['Line 1', 'Line 2', 'Line 3']
    writeFile(filePath, 'w', data)

    data = ['Line 4', 'Line 5', 'Line 6']
    writeFile(filePath, 'a', data)

    resultData = readFile(filePath, 'r')
    for line in resultData:
        print(line)


def createFile(path):
    if not op.isfile(path):
        open(path, 'x').close()


def writeFile(path, mode, data):
    file = open(path, mode)

    for line in data:
        if not str(line).endswith('\n'):
            line += '\n'
        file.write(line)

    file.close()


def readFile(path, mode):
    file = open(path, mode)
    data = file.readlines()
    file.close()
    resultData = []

    for line in data:
        resultData.append(str(line).strip())

    return resultData


if __name__ == '__main__':
    main()
