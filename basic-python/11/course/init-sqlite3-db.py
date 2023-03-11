import sqlite3


def main():
    connection = sqlite3.connect(
        './/open-bootcamp-course/basic-python/11/init_sqlite.db')
    cursor = connection.cursor()

    cursor.execute('DROP TABLE users')

    cursor.execute(
        'CREATE TABLE users(id integer primary key, name text(50) not null, username text(50) not null, password text not null)')
    connection.commit()

    insert = '''INSERT INTO users(name, username, password) VALUES (?, ?, ?)'''
    cursor.execute(insert, ('Elio', 'elio', 'pass'))
    cursor.execute(insert, ('Day', 'day', 'pass'))
    cursor.execute(insert, ('Eli', 'eli', 'pass'))

    select = '''SELECT * FROM users WHERE id=?'''
    rows = cursor.execute(select, ('1'))
    print(rows.fetchone())

    connection.commit()
    cursor.close()
    connection.close()


if __name__ == '__main__':
    main()
