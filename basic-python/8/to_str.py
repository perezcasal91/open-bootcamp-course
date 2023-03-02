class Toy:
    _name = None
    _price = None

    def __init__(self, name, price):
        self._name = name
        self._price = price
    
    def __str__(self):
        return f'My name is {self._name} and my price is {self._price}'
    
    def __repr__(self):
        return f'Toy(name:{self._name}, price:{self._price})'
    

t = Toy('car', 5.5)
print(str(t))
print(repr(t))