from repository.student_repository import StudentRepository
from entity.group_entity import Group
from entity.student_entity import Student


def main():
    
    gA = Group.GroupBuilder().setName('A').build()
    gB = Group.GroupBuilder().setName('B').build()

    sE = Student.StudentBuilder().setName('Elio').setLastname('Perez').setAge(31).setGroup(gA).build()
    sD = Student.StudentBuilder().setName('Day').setLastname('Leon').setAge(35).setGroup(gB).build()
    sU = Student.StudentBuilder().setGroup(gA).build()
    
    studentRepository = StudentRepository()

    studentRepository.update(sD, sU)

    print(studentRepository.findAll())


if __name__ == '__main__':
    main()
