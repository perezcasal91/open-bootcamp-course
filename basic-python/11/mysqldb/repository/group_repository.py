from db.postgres_db import PostgresDB
from entity.group_entity import Group


class GroupRepository:
    _database = None
    _DBNAME = None
    _USER = None
    _PASSWORD = None
    _HOST = None
    _PORT = None
    _TABLENAME = None

    def __init__(self):
        self._DBNAME = 'class_room'
        self._USER = 'postgres'
        self._PASSWORD = 'admin'
        self._HOST = 'localhost'
        self._PORT = 5432

        arguments = f"""dbname={self._DBNAME} user={self._USER}
        password={self._PASSWORD} host={self._HOST} port={self._PORT}"""

        self._database = PostgresDB(arguments)
        self._TABLENAME = 't_group'

    def save(self, group=Group):
        data = self._groupToDict(group)
        self._database.insert(self._TABLENAME, data)
        self._setId(group, data)
        return group

    def update(self, oldGroup=Group, newGroup=Group):
        newValues = self._groupToDict(newGroup)
        if oldGroup.getId() > 0:
            self._database.updateById(
                self._TABLENAME, oldGroup.getId(), newValues)
        else:
            oldValues = self._groupToDict(oldGroup)
            self._database.update(self._TABLENAME, oldValues, newValues)

    def delete(self, group=Group):
        if group.getId() > 0:
            self._database.deleteById(self._TABLENAME, group.getId())
        else:
            oldValues = self._groupToDict(group)
            self._database.delete(self._TABLENAME, oldValues)

    def findAll(self):
        data = self._database.fecthAll(self._TABLENAME)
        groupList = list()
        for values in data:
            groupList.append(self._setValuesToGroup(values))
        return groupList

    def findAllByName(self, name):
        where = self._setNameToDict(name)
        data = self._database.fecthAll(self._TABLENAME, where)
        groupList = list()
        for values in data:
            groupList.append(self._setValuesToGroup(values))
        return groupList

    def findOneById(self, id):
        values = self._database.fecthOneById(self._TABLENAME, id)
        return self._setValuesToGroup(values)

    def findOneByName(self, name):
        where = self._setNameToDict(name)
        values = self._database.fecthOne(self._TABLENAME, where)
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
        id = self._database.fecthOne(self._TABLENAME, data)[0]
        group.setId(id)

    def _setValuesToGroup(self, values=tuple()):
        group = Group()

        group.setId(values[0])
        group.setName(values[1])

        return group
