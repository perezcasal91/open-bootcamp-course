from db.sqlite_db import SqliteDB
from entity.group_entity import Group


class GroupRepository:
    _database = None
    _filePath = None
    _tableName = None

    def __init__(self):
        self._filePath = './/open-bootcamp-course/basic-python/11/sqlite/db/sqlite.db'
        self._database = SqliteDB(self._filePath)
        self._tableName = 't_group'

    def save(self, group=Group):
        data = self._groupToDict(group)
        self._database.insert(self._tableName, data)
        self._setId(group, data)
        return group

    def update(self, oldGroup=Group, newGroup=Group):
        newValues = self._groupToDict(newGroup)
        if oldGroup.getId() > 0:
            self._database.updateById(
                self._tableName, oldGroup.getId(), newValues)
        else:
            oldValues = self._groupToDict(oldGroup)
            self._database.update(self._tableName, oldValues, newValues)

    def delete(self, group=Group):
        if group.getId() > 0:
            self._database.deleteById(self._tableName, group.getId())
        else:
            oldValues = self._groupToDict(group)
            self._database.delete(self._tableName, oldValues)

    def findAll(self):
        data = self._database.fecthAll(self._tableName)
        groupList = list()
        for values in data:
            groupList.append(self._setValuesToGroup(values))
        return groupList

    def findAllByName(self, name):
        where = self._setNameToDict(name)
        data = self._database.fecthAll(self._tableName, where)
        groupList = list()
        for values in data:
            groupList.append(self._setValuesToGroup(values))
        return groupList

    def findOneById(self, id):
        values = self._database.fecthOneById(self._tableName, id)
        return self._setValuesToGroup(values)

    def findOneByName(self, name):
        where = self._setNameToDict(name)
        values = self._database.fecthOne(self._tableName, where)
        return self._setValuesToGroup(values)

    def _groupToDict(self, group):
        groupDict = dict()

        if group.getName() != '':
            groupDict['name'] = group.getName()

        return groupDict

    def _setNameToDict(self, name):
        values = {
            'name': name
        }

        return values

    def _setId(self, group=Group, data=dict()):
        id = self._database.fecthOne(self._tableName, data)[0]
        group.setId(id)

    def _setValuesToGroup(self, values=tuple()):
        group = Group()

        group.setId(values[0])
        group.setName(values[1])

        return group
