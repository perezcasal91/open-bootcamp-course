from db.sqlite_db import SqliteDB
from entity.student_entity import Student
from repository.group_repository import GroupRepository


class StudentRepository:
    _database = None
    _filePath = None
    _tableName = None
    _groupRepository = None

    def __init__(self):
        self._filePath = './/open-bootcamp-course/basic-python/11/sqlite/db/sqlite.db'
        self._database = SqliteDB(self._filePath)
        self._tableName = 't_student'
        self._groupRepository = GroupRepository()

    def save(self, student=Student):
        data = self._studentToDict(student)
        self._database.insert(self._tableName, data)
        self._setId(student, data)
        return student

    def update(self, oldStudent=Student, newStudent=Student):
        newValues = self._studentToDict(newStudent)
        if oldStudent.getId() > 0:
            self._database.updateById(
                self._tableName, oldStudent.getId(), newValues)
        else:
            oldValues = self._studentToDict(oldStudent)
            self._database.update(self._tableName, oldValues, newValues)

    def delete(self, student=Student):
        if student.getId() > 0:
            self._database.deleteById(self._tableName, student.getId())
        else:
            oldValues = self._studentToDict(student)
            self._database.delete(self._tableName, oldValues)

    def findAll(self):
        data = self._database.fecthAll(self._tableName)
        groupList = list()
        for values in data:
            groupList.append(self._setValuesToStudent(values))
        return groupList

    def findAllByName(self, name):
        where = self._setNameToDict(name)
        data = self._database.fecthAll(self._tableName, where)
        groupList = list()
        for values in data:
            groupList.append(self._setValuesToStudent(values))
        return groupList

    def findOneById(self, id):
        values = self._database.fecthOneById(self._tableName, id)
        return self._setValuesToStudent(values)

    def findOneByName(self, name):
        where = self._setNameToDict(name)
        values = self._database.fecthOne(self._tableName, where)
        return self._setValuesToStudent(values)

    def _studentToDict(self, student=Student):
        studentDict = dict()

        if student.getName() != '':
            studentDict['name'] = student.getName()

        if student.getLastname() != '':
            studentDict['lastname'] = student.getLastname()

        if student.getAge() != 0:
            studentDict['age'] = student.getAge()

        if student.getGroup().getName() != '':
            if student.getGroup().getId() > 0:
                groupid = student.getGroup().getId()
            else:
                groupid = self._groupRepository.findOneByName(
                    student.getGroup().getName()).getId()

            studentDict['groupid'] = groupid

        return studentDict

    def _setNameToDict(self, name):
        values = {
            'name': name
        }

        return values

    def _setId(self, student=Student, data=dict()):
        id = self._database.fecthOne(self._tableName, data)[0]
        student.setId(id)

    def _setValuesToStudent(self, values=tuple()):
        student = Student()

        student.setId(values[0])
        student.setName(values[1])
        student.setLastname(values[2])
        student.setAge(values[3])
        student.setGroup(self._groupRepository.findOneById(values[4]))

        return student
