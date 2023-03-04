from getpass import getpass
def main():
    user = input('Intraduce the user: ')
    password = getpass('Introduce the password: ')

    print(f'The user is {user} and the password {password}')

if __name__ == '__main__':
    main()