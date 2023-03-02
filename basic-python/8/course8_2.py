import pickle

class Vehicle:
    _model = None
    _color = None
    _wheels = None
    _doors = None

    def __init__(self, model, color, wheels, doors):
        self._model = model
        self._color = color
        self._wheels = wheels
        self._doors = doors
    
    def __str__(self):
        return f'Vehicle(model:{self._model}, color:{self._color}, wheels:{self._wheels}, doors:{self._doors})'


def main():
    filePath = './/open-bootcamp-course/basic-python/8/course8_2.bin'
    v = Vehicle('xyz', 'black', 4, 6)
    serializeData(filePath, v)
    serializeV = unserializeData(filePath)
    print(serializeV)

def serializeData(path, data):
    file = open(path, 'wb')
    pickle.dump(data, file)
    file.close()

def unserializeData(path):
    file = open(path, 'rb')
    data = pickle.load(file)
    file.close()
    return data

if __name__ == '__main__':
    main()