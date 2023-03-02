"""
Scopes

System Path : sys.path -> Is all the path a module level
Globals : Is all a global level the script can reach
Locals : Is all a local level a class or function can reach 
"""
import pprint
import sys

# Print the scopes before
sys.path.append('any/route')
pprint.pprint('System Path')
pprint.pprint(sys.path)
pprint.pprint('Globals')
pprint.pprint(globals())


def test(a):
    print(a)
    pprint.pprint('Locals')
    pprint.pprint(locals())


test(1)
