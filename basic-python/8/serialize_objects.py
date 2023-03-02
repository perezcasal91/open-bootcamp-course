import pickle
from to_str import Toy


def main():
    toy = Toy('car', 5.5)
    filePath = './/open-bootcamp-course/basic-python/8/data.bin'

    writeSerializableData(toy, filePath)

    serializableToy = readSerializableData(filePath)

    print(serializableToy)


def writeSerializableData(data, path):
    file = open(path, 'wb')
    pickle.dump(data, file)
    file.close()


def readSerializableData(path):
    file = open(path, 'rb')
    data = pickle.load(file)
    file.close()
    return data


if __name__ == '__main__':
    main()
