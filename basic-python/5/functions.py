# Function without parameter
def example():
    pass


# Function with parameter
def example(parameter):
    pass


# Nested Functions
def mainFunction():
    def nested():
        pass
    nested()


# Funtion with Variable
variable = 'local'


def localFunction(var):
    print(var)


localFunction(variable)


# Function with Global Variable
def globalFunction():
    global var
    var = 'global'
    print(var)


globalFunction()
print(var)


# Function with optional parameters
def optionalParameter(parameter='optional'):
    print(parameter)


optionalParameter()
optionalParameter("test")


# Function with variable parameters


# Using the * , we pass a tuple
def variableTupleParameters(*args):
    print(args)


variableTupleParameters(1, 2, 3)


# Using the ** , we pass a dictionary
def variableDictionaryParameters(**kargs):
    print(kargs)


variableDictionaryParameters(num1=1, num2=2, num3=3)


# Function with Return Several Values
def operationsStr(a, b):
    return 'sum:' + str(a + b), 'substrat:' + str(a - b), 'division:' + str(a // b), 'multiply:' + str(a * b)

# All the resutl in the same variable
result = operationsStr(4, 2)
print(result)

def operations(a, b):
    return a + b, a - b, a // b, a * b

# All the result in separeted variables
sum, substrat, division, multiply = operations(4, 2)
print(sum)
print(substrat)
print(division)
print(multiply)

# Only one reseult
sum, _, _, _ = operations(4, 2)
print(sum)

# Anonymous Functions
anonymousSum = lambda a,b: a + b
print(anonymousSum(3,2))