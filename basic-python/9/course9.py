def main():

    oneWay()
    otherWay()

def oneWay():

    head()
    country = input('Introduce the name of the country: ')

    countryList = set()

    while country != '0':
        countryList.add(country)
        country = input('Introduce the name of the country: ')

    resultList = sorted(countryList)
    print(list(resultList))

def otherWay():

    head()
    countries = input('Introduce the countries: ').replace(' ', '').split(',')

    countryList = set(countries)

    resultList = sorted(countryList)

    print(list(resultList))


def head():
    print('Country List')
    print('Press 0 when you has done')

if __name__ == '__main__':
    main()
