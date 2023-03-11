class Group:
    _id = int()
    _name = str()

    def getId(self):
        return self._id

    def getName(self):
        return self._name

    def setId(self, id):
        self._id = id

    def setName(self, name):
        self._name = name

    def __str__(self):
        return self._name

    def __repr__(self):
        return self._name

    class GroupBuilder:
        _group = None

        def __init__(self):
            self._group = Group()

        def setId(self, id):
            self._group.setId(id)
            return self

        def setName(self, name):
            self._group.setName(name)
            return self

        def build(self):
            return self._group
