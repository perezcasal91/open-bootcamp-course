
def main():
    filePath = './/open-bootcamp-course/basic-python/8/users.txt' 
    data = ['nobody', 'demo', 'user']
    writeFile(filePath, 'w', data)


def writeFile(path, mode, data):
    file = open(path, mode)
    for line in data:
        if not str(line).endswith('\n'):
            line += '\n'

        file.write(line)

    file.close()
if __name__ == '__main__':
    main()