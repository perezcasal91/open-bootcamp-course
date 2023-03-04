import _thread
import time


def main():
    global stop
    stop = False

    _thread.start_new_thread(currentTime, ('one', 1))
    _thread.start_new_thread(currentTime, ('two', 5))

    print('Init with Threads')

    while stop == False:
        pass


def currentTime(name, delay):
    global stop
    count = 0

    while count < 5:
        time.sleep(delay)
        print(f'Thread: {name} - {time.ctime(time.time())}')
        count += 1

    if count == 5 and name == 'two':
        stop = True


if __name__ == '__main__':
    main()
