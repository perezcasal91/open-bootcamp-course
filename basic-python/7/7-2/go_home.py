import time


def timeToGoHome():
    hour = time.localtime().tm_hour
    restMin = 60 - time.localtime().tm_min
    restSec = 60 - time.localtime().tm_sec

    if (hour > 19):
        print('Is time to go Home, you are past', (hour - 19), restMin, restSec)
    elif (hour > 7 and hour < 19):
        restHour = 19 - hour
        print('Remaining time to go home', restHour, restMin, restSec)
