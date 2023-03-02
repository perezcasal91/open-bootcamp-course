"""
This module is secuencial as script
"""


def sum(a, b):
    """
    Return the sum of two numbers
    """
    return a + b


def subtract(a, b):
    """
    Return the subtraction of two numbers
    """
    return a - b


def division(a, b):
    """
    Return the division of two numbers, 
    b can not be 0, division by zero is not allowed.
    """
    if (b != 0):
        return a / b


def multiplication(a, b):
    """
    Return the multiplication of two numbers
    """
    return a * b
