class Vehicle:
    _color = None
    _wheels = None
    _doors = None

    def __init__(self, color, wheels, doors):
        self._color = color
        self._wheels = wheels
        self._doors = doors

    def getColor(self):
        return self._color

    def getWheels(self):
        return self._wheels

    def getDoors(self):
        return self._doors

    def setColor(self, color):
        self._color = color

    def setWheels(self, wheels):
        self._wheels = wheels

    def setDoors(self, doors):
        self._doors = doors


class Car(Vehicle):
    _speed = None
    _cilindryc = None

    def __init__(self, color, wheels, doors, speed, cilindryc):
        super().__init__(color, wheels, doors)
        self._speed = speed
        self._cilindryc = cilindryc

    def getSpeed(self):
        return self._speed

    def getCilindryc(self):
        return self._cilindryc

    def setSpeed(self, speed):
        self._speed = speed

    def setCilindryc(self, cilindryc):
        self._cilindryc = cilindryc


c = Car('Black', 4, 6, 200, 4)
print(c.getColor())
print(c.getWheels())
print(c.getDoors())
print(c.getSpeed())
print(c.getCilindryc())
