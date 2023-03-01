class Student:
    _name = None
    _note = None

    def __init__(self, name, note):
        self._name = name
        self._note = note

    def getName(self):
        return self._name

    def getNote(self):
        return self._note

    def setName(self, name):
        self._name = name

    def setNote(self, note):
        self._note = note

    def approved(self):
        print('You score has been ', self._note)
        return print('Congratulations!!!, you are approved') if (self._note >= 60) else print('Sorry, you are not approved.')
    
sE = Student('Elio', 95)

print(sE.getName())
print(sE.getNote())
sE.approved()

sD = Student('Day', 59)

print(sD.getName())
print(sD.getNote())
sD.approved()

