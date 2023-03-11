from entity.group_entity import Group


class Student:
    _id = int()
    _name = str()
    _lastname = str()
    _age = int()
    _group = None

    def getId(self):
        return self._id

    def getName(self):
        return self._name

    def getLastname(self):
        return self._lastname

    def getAge(self):
        return self._age

    def getGroup(self):
        return self._group

    def setId(self, id):
        self._id = id

    def setName(self, name):
        self._name = name

    def setLastname(self, lastname):
        self._lastname = lastname

    def setAge(self, age):
        self._age = age

    def setGroup(self, group=Group):
        self._group = group

    def __str__(self):
        return f'{self.getName()} {self.getLastname()} {self.getAge()} {self.getGroup()}'

    def __repr__(self):
        return f'{self.getName()} {self.getLastname()} {self.getAge()} {self.getGroup()}'

    class StudentBuilder:
        _student = None

        def __init__(self):
            self._student = Student()

        def setId(self, id):
            self._student.setId(id)
            return self

        def setName(self, name):
            self._student.setName(name)
            return self

        def setLastname(self, lastname):
            self._student.setLastname(lastname)
            return self

        def setAge(self, age):
            self._student.setAge(age)
            return self

        def setGroup(self, group):
            self._student.setGroup(group)
            return self

        def build(self):
            return self._student
