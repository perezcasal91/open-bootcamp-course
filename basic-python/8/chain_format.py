# Chain Format

num = 5
text = 'Hello'
val = 5.5

# 1 Using the %
print('The number is %d and the text is %s and have %.1f' % (num, text, val))

# 2 Using the srt format
print('The number is {} and the text is {} and have {}'.format(num, text, val))

# 3 Using the chain format
print(f'The number is {num} and the text is {text} and have {val}')
