# Normal Class
from abc import ABC, abstractmethod


class Person:
    _name = None
    _age = None

    def __init__(self, name, age):
        self._name = name
        self._age = age

    def setName(self, name):
        self._name = name

    def setAge(self, age):
        self._age = age

    def getName(self):
        return self._name

    def getAge(self):
        return self._age


p = Person('elio', 31)
print(p.getName())


# Inherit
class Employee(Person):
    _work = None

    def __init__(self, name, age, work):
        super().__init__(name, age)
        self._work = work

    def setWork(self, work):
        self.work = work

    def getWork(self):
        return self._work


e = Employee('elio', 31, 'unemployee')
print(e.getName())
print(e.getWork())


# Static Class
class StaticClass:
    _static = None

    def setStatic():
        StaticClass._static = 'static'

    def getStatic():
        return StaticClass._static


StaticClass.setStatic()
print(StaticClass.getStatic())


# Abstract Class
class Animal(ABC):
    @abstractmethod
    def sound(self):
        pass


class Dog(Animal):
    def sound(self):
        print('wau')


d = Dog()
d.sound()


class Cat(Animal):
    def sound(self):
        print('miau')


c = Cat()
c.sound()


# Class Composition
class Motor:
    _type = "Diesel"

    def getType(self):
        return self._type

    def setType(self, type):
        self._type = type


class Wheel:
    _count = 4

    def getCount(self):
        return self._count

    def setCount(self, count):
        self._count = count


class Window:
    _count = 6

    def getCount(self):
        return self._count

    def setCount(self, count):
        self._count = count


class Body:
    _wheels = Wheel()
    _windows = Window()

    def getWheels(self):
        return self._wheels

    def getWindows(self):
        return self._windows


class Car:
    _body = Body()
    _motor = Motor()

    def getBody(self):
        return self._body

    def getMotor(self):
        return self._motor
    

c = Car()
print(c.getBody().getWheels().getCount())
print(c.getBody().getWindows().getCount())
print(c.getMotor().getType())
c.getMotor().setType('Gass')
print(c.getMotor().getType())

class Category:
    _id = 0
    _name = 'Grocery'

class Provider:
    _id = 0
    _name = "Walmart"

class Product:
    _id = 0
    _price = 10.5
    _size = 3
    _type = 'secundary'
    _category = Category()
    _provider = Provider()


prod = Product()
print(prod._category._name)