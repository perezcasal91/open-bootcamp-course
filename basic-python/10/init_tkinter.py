import time
import tkinter as tk
from tkinter import ttk
from tkinter import Menu
from tkinter.messagebox import showerror, showwarning, showinfo, askyesno
from tkinter import filedialog
from tkinter import colorchooser


def main():
    global window
    window = tk.Tk()
    init()
    menu()
    menuButton()
    separator()
    optionsMenu()
    separator()
    messageBox()
    separator()
    fileDialog()
    separator()
    colorChooser()
    separator()
    indeterminateProgressBar()
    determinateProgressBar()
    separator()
    comboBox()
    separator()
    radioButton()
    separator()
    entryValues()
    show()


def init():
    window.iconbitmap('.//open-bootcamp-course/basic-python/10/icon.ico')
    window.title('Init with Tkinter')

    # Window Size
    width = 640
    height = window.winfo_screenheight()

    # Centering the Window
    left = int((window.winfo_screenwidth() - width) / 2)
    top = int((window.winfo_screenheight() - height) / 2)

    # Changing the attributes
    window.geometry(f'{width}x{height}+{left}+{top}')
    window.resizable(0, 0)
    window.attributes('-topmost', 1)


def menu():
    # Creating a Menu Bar
    menuBar = Menu(window)
    window.config(menu=menuBar)

    # Creating a File Menu
    fileMenu = Menu(
        menuBar, tearoff=0
    )

    # Adding items to the File Menu
    fileMenu.add_command(label='New')
    fileMenu.add_command(label='Open')
    fileMenu.add_separator()

    # Creating the Sub Menu Preferences
    preferencesSubMenu = Menu(
        fileMenu, tearoff=0
    )

    # Adding items to the Sub Menu Preferences
    preferencesSubMenu.add_command(label='Options')
    preferencesSubMenu.add_command(label='Settings')

    # Inserting the Sub Menu Preferences into the File Menu
    fileMenu.add_cascade(
        label="Preferences",
        menu=preferencesSubMenu,
        underline=0
    )

    # Adding items to the File Menu
    fileMenu.add_separator()
    fileMenu.add_command(
        label='Exit',
        command=exit
    )

    # Inserting the File Menu inside the Menu Bar
    menuBar.add_cascade(
        label="File",
        menu=fileMenu,
        underline=0
    )

    # Creating a Help Menu
    helpMenu = Menu(
        menuBar, tearoff=0
    )

    # Adding labels to the Help Menu
    helpMenu.add_command(label='Contact')
    helpMenu.add_command(label='About')

    # Inserting the Help Menu inside the Menu Bar
    menuBar.add_cascade(
        label="Help",
        menu=helpMenu,
        underline=0
    )


def exit():
    # Creating a Yes Or No Message Box
    result = askyesno(
        title='Exit',
        message='Are you sure you want to Exit?'
    )
    if result:
        window.destroy()


def menuButton():
    """
    Creating a Menu Button Countries
    """

    # Creating the Label
    countryLabel = ttk.Label(
        window,
        text='Country:'
    )
    countryLabel.pack(padx=5, pady=5)

    # Creating the Menu Button
    countryMenuButton = ttk.Menubutton(
        window,
        text='--Select--'
    )

    # Countries
    countries = ('Cuba', 'EEUU', 'France')

    # Creating the options for the Menu Button
    options = tk.Menu(
        countryMenuButton, tearoff=0
    )

    # Creating a Variable for the selected Values
    global selectedCountry
    selectedCountry = tk.StringVar()

    # Filling the options
    for country in countries:
        options.add_radiobutton(
            label=country,
            value=country,
            variable=selectedCountry,
            command=countryChange
        )

    # Adding the options to the Menu Button
    countryMenuButton['menu'] = options
    countryMenuButton.pack(padx=5, pady=5)


def countryChange():
    print("selected:", selectedCountry.get())


def optionsMenu():
    """
    Creating a Options Menu Languages
    """
    # Creating the Label
    languageLabel = ttk.Label(
        window,
        text='Language'
    )
    languageLabel.pack(padx=5, pady=5)

    # Languages
    languages = ('Spanish', 'English', 'French')

    # Creating a Variable for the selected Values
    global selectedLanguage
    selectedLanguage = tk.StringVar()

    # Creating the Option Menu
    languageOptionMenu = ttk.OptionMenu(
        window,
        selectedLanguage,
        '--Select--',
        *languages,
        command=languageChange
    )
    languageOptionMenu.pack(padx=5, pady=5)


def languageChange(*args):
    print("selected:", selectedLanguage.get())


def messageBox():
    # Creating an Information Message Button
    infoMessage = ttk.Button(
        window,
        text='Show Information Message',
        command=lambda: showinfo(
            title='Information',
            message='This is an Information message.'
        )
    )
    infoMessage.pack(padx=5, pady=5)

    # Creating an Warning Message Button
    warningMessage = ttk.Button(
        window,
        text='Show Warning Message',
        command=lambda: showwarning(
            title='Warning',
            message='This is an Warning message.'
        )
    )
    warningMessage.pack(padx=5, pady=5)

    # Creating an Error Message Button
    errorMessage = ttk.Button(
        window,
        text='Show Error Message',
        command=lambda: showerror(
            title='Error',
            message='This is an Error message.'
        )
    )
    errorMessage.pack(padx=5, pady=5)


def fileDialog():
    # Creating a Button to Open a Directory
    openDirectory = ttk.Button(
        window, text='Open Directory', command=selectDirectory)
    openDirectory.pack(padx=5, pady=5)

    # Creating a Button to Open a File
    openFile = ttk.Button(window, text='Open File', command=selectFile)
    openFile.pack(padx=5, pady=5)


def selectDirectory():
    directory = filedialog.askdirectory()
    showinfo(
        title='Selected Directory',
        message=directory
    )


def selectFile():
    fileTypes = (
        ('text files', '*.txt'),
        ('pdf files', '*.pdf'),
        ('All files', '*.*')
    )
    file = filedialog.askopenfilename(
        title='Open a File',
        filetypes=fileTypes
    )
    showinfo(
        title='Selected File',
        message=file
    )


def colorChooser():
    openColor = ttk.Button(window, text='Select Color', command=selectColor)
    openColor.pack(padx=5, pady=5)


def selectColor():
    color = colorchooser.askcolor()
    showinfo(
        title='Selected Color',
        message=color
    )


def indeterminateProgressBar():
    progressBar = ttk.Progressbar(
        window,
        length=200,
        mode='indeterminate',
        orient='horizontal',
        maximum=50)
    start = ttk.Button(window, text='Start', command=progressBar.start)
    start.pack(padx=5, pady=5)
    progressBar.pack(padx=5, pady=5)
    stop = ttk.Button(window, text='Stop', command=progressBar.stop)
    stop.pack(padx=5, pady=5)


def determinateProgressBar():
    global dProgressBar
    dProgressBar = ttk.Progressbar(
        window,
        length=200,
        mode='determinate',
        orient='horizontal',
        value=0
    )
    dProgressBar.pack(padx=5, pady=5)
    global dProgressLabel
    dProgressLabel = ttk.Label(
        window,
        text=f'Current progress: {dProgressBar["value"]}%'
    )
    start = ttk.Button(
        window,
        text='Start',
        command=startProgress
    )
    start.pack(padx=5, pady=5)
    stop = ttk.Button(
        window,
        text='Stop',
        command=stopProgress
    )
    stop.pack(padx=5, pady=5)
    dProgressLabel.pack(padx=5, pady=5)


def updateProgress():
    return f'Current progress: {dProgressBar["value"]}%'


def startProgress():
    if dProgressBar['value'] < 100:
        dProgressBar['value'] += 10
        dProgressLabel['text'] = updateProgress()
    else:
        showinfo(message='Progress Complete!.')


def stopProgress():
    dProgressBar.stop()
    dProgressLabel['text'] = updateProgress()


def comboBox():
    years = ('--Select--', 2020, 2021, 2022, 2023, 2024, 2025)
    global year
    year = tk.StringVar()
    combo = ttk.Combobox(
        window,
        height=50,
        justify='center',
        values=years,
        textvariable=year,
        state='readonly')
    combo.current(0)
    combo.bind('<<ComboboxSelected>>', selectYear)
    combo.pack(padx=5, pady=5)


def selectYear(event):
    if year.get() != '--Select--':
        showinfo(message=f'You year is: {year.get()}.')


def radioButton():
    global var1
    var1 = tk.StringVar()
    r1 = ttk.Radiobutton(
        window,
        text='Radio Button 1',
        value='R1',
        variable=var1,
        command=selectR1
    )
    r1.pack(padx=5, pady=5)
    global var2
    var2 = tk.StringVar()
    r2 = ttk.Radiobutton(
        window,
        text='Radio Button 2',
        value='R2',
        variable=var2,
        command=selectR2
    )
    r2.pack(padx=5, pady=5)
    r3 = ttk.Radiobutton(
        window,
        text='Radio Button 3',
        value='R3',
        variable=var2,
        command=selectR2
    )
    r3.pack(padx=5, pady=5)


def selectR1():
    showinfo(message=f'You are selected the Radio Button: {var1.get()}')


def selectR2():
    showinfo(message=f'You are selected the Radio Button: {var2.get()}')


def entryValues():
    usernameLabel = ttk.Label(window, text='Username')
    usernameLabel.pack(padx=3, pady=3)
    global username
    username = tk.StringVar()
    usernameEntry = ttk.Entry(window, textvariable=username)
    usernameEntry.pack(padx=3, pady=3)
    passwordLabel = ttk.Label(window, text='Password')
    passwordLabel.pack(padx=3, pady=3)
    global password
    password = tk.StringVar()
    passwordEntry = ttk.Entry(window, textvariable=password, show='*')
    passwordEntry.pack(padx=3, pady=3)
    showValues = ttk.Button(window, text='Show Values')
    showValues.bind('<Button 1>', showEntryValues)
    showValues.pack(padx=3, pady=3)


def showEntryValues(event):
    showinfo(
        title='Show Values',
        message=f'Username: {username.get()} and Password: {password.get()}'
    )


def separator():
    separator = ttk.Separator(window, orient='horizontal')
    separator.pack(fill='x')


def show():
    window.mainloop()


if __name__ == '__main__':
    main()
