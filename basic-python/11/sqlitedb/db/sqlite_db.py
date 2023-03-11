import sqlite3
import logging


class SqliteDB:
    _connection = None
    _cursor = None
    _rows = None

    def __init__(self, filePath):
        self._connection = sqlite3.connect(filePath)
        self._cursor = self._connection.cursor()

    # Create Table
    def createTable(self, tableName, primaryKey=str, fields=dict()):
        if self._existTable(tableName) == False:
            query = f'CREATE TABLE {tableName} ( '

            if len(primaryKey) > 0:
                query += f'{primaryKey} integer primary key, '

            count = 1
            for field in fields:
                if count < len(fields):
                    query += f'{field} {fields[field]}, '
                else:
                    query += f'{field} {fields[field]} )'
                count += 1

            self._execute(query)
        else:
            print(f'The table: {tableName} already exits.')

    # Drop Table
    def dropTable(self, tableName):
        query = f'DROP TABLE {tableName}'
        self._execute(query)

    # Insert
    def insert(self, tableName, data=dict()):
        query = f'INSERT INTO {tableName} '

        fields = ''
        for field in data.keys():
            fields += f'{field}, '

        query += f'({fields[:-2]}) VALUES ('

        values = tuple(data.values())
        for i in range(0, len(values)):
            if i < len(values) - 1:
                query += '?, '
            else:
                query += '?)'

        self._execute(query, (values))

    # Update
    def update(self, tableName, oldValues=dict(), newValues=dict()):
        query = f'UPDATE {tableName} SET '

        fields = ''
        for field in newValues.keys():
            fields += f'{field}=?, '

        query += f'{fields[:-2]} WHERE '

        count = 1
        for old in oldValues:
            if count < len(oldValues):
                query += f"{old}='{oldValues[old]}' AND "
            else:
                query += f"{old}='{oldValues[old]}'"
            count += 1

        values = tuple(newValues.values())
        self._execute(query, values)

    # Update By Id
    def updateById(self, tableName, id, newValues=dict()):
        query = f'UPDATE {tableName} SET '

        fields = ''
        for field in newValues.keys():
            fields += f'{field}=?, '

        query += f"{fields[:-2]} WHERE {self._getId(tableName)}='{id}'"

        values = tuple(newValues.values())
        self._execute(query, values)

    # Delete
    def delete(self, tableName, oldValues):
        query = query = f'DELETE FROM {tableName} WHERE '

        count = 1
        for old in oldValues:
            if count < len(oldValues):
                query += f"{old}='{oldValues[old]}' AND "
            else:
                query += f"{old}='{oldValues[old]}'"
            count += 1

        self._execute(query)

    # Delete By Id
    def deleteById(self, tableName, id):
        query = f"""DELETE FROM {tableName}
                WHERE {self._getId(tableName)}='{id}'"""
        return self._execute(query)

    # Fecth All
    def fecthAll(self, tableName, where=dict()):
        query = f'SELECT * FROM {tableName}'

        if (len(where) > 0):
            query += ' WHERE '
            count = 1
            for field in where:
                if count < len(where):
                    query += f"{field}='{where[field]}' AND "
                else:
                    query += f"{field}='{where[field]}'"
                count += 1

        return self._fecthAll(query)

    # Fecth One
    def fecthOne(self, tableName, where=dict()):
        query = f'SELECT * FROM {tableName}'

        if (len(where) > 0):
            query += ' WHERE '
            count = 1
            for field in where:
                if count < len(where):
                    query += f"{field}='{where[field]}' AND "
                else:
                    query += f"{field}='{where[field]}'"
                count += 1

        return self._fecthOne(query)

    # Fecth One By Id
    def fecthOneById(self, tableName, id):
        query = f"""SELECT * FROM {tableName}
                WHERE {self._getId(tableName)}='{id}'"""

        return self._fecthOne(query)

    # Private Methods

    def _existTable(self, tableName):
        query = f"""SELECT name FROM sqlite_master
        WHERE type='table' AND name='{tableName}' """

        return False if self._fecthAll(query) == [] else True

    def _fecthAll(self, query=str):
        return self._execute(query).fetchall()

    def _fecthOne(self, query):
        return self._execute(query).fetchone()

    def _getId(self, tableName):
        query = f"PRAGMA table_info('{tableName}')"
        self._execute(query)

        for row in self._rows:
            if (row[-1] == 1):
                return row[1]

    def _execute(self, query, values=tuple()):
        if (len(values) > 0):
            self._cursor.execute(query, values)
            self._connection.commit()
        else:
            self._rows = self._cursor.execute(query)
            self._connection.commit()
            return self._rows

    def close(self):
        self._cursor.close()
        self._connection.close()
