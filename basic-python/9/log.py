import logging


def main():

    basicConfig(logging.DEBUG)
    logging.info('Staring the application')
    info()
    warning()
    error()
    critical()
    debug()
    exception()


def basicConfig(config):
    logging.basicConfig(level=config)


def info():
    logging.info('Init with info')


def warning():
    logging.warning('Init with warning')


def error():
    logging.error('Init with error')


def critical():
    logging.critical('Init with critical')


def debug():
    logging.debug('Init with debug')


def exception():
    logging.exception('Init with exception')


if __name__ == '__main__':
    main()
