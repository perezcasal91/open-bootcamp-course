import math

print('Calculate Body Mass Indez')
print()
weight = float(input('Please enter your weight in Kg:'))
height = float(input('Please enter your height in Ms:'))

bodyMassIndex = weight / (height ** 2)

print()
print('Your BMI is:', math.ceil(bodyMassIndex))
