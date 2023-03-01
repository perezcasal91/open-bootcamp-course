# And
print('x and y', True and True)
print('x and y', True and False)
print('x and y', False and True)
print('x and y', False and False)
print()
# Or
print('x or y', True and True)
print('x or y', True and False)
print('x or y', False and True)
print('x or y', False and False)
print()
# XOR
print('x xor y', True and True)
print('x xor y', True and False)
print('x xor y', False and True)
print('x xor y', False and False)
# Variable
a = 5
b = 7
# If
if (a < 6) and (b > 3):
    print(True)
elif (a > 6) or (b < 7):
    print(False)
# While
count = 0
# Normal Scenario
while (count < 3):
    print(count)
    count += 1
# Print even
while (count < 3):
    if (count % 2 == 0):
        print(count)
    count += 1
# Break
while (count < 3):
    if (count == 1):
        print(count)
        break
    count += 1
# Continue
while (count < 3):
    count += 1
    if (count == 1):
        print(count)
        continue
    print('Is not 1')
# For
# List
list = [1, 2, 3]
for num in list:
    print(num)
# Tuple
tuple = (1, 2, 3)
for num in tuple:
    print(num)
# Range
for num in range(0, 2):
    print(num)
for index in range(len(list)):
    print(list[index])
# Break
for num in range(0, 2):
    if (num == 1):
        print(num)
        break
# In
if 1 in list:
    print(1)
# Not In
if 4 not in list:
    print(4)
# Sorted
sortedList = sorted(list)
print(sortedList)
reversedList = sorted(list, reverse=True)
# Match
value = 2
match value:
    case 1:
        print('case 1')
    case 2:
        print('case 2')
    case 3:
        print('case 3')
