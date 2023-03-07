import tkinter as tk
from tkinter import ttk
from tkinter.messagebox import showinfo


def main():
    window = tk.Tk()
    window.title('Course 10 Exe 2')

    # Window Size
    width = 600
    height = 200

    # Centering the Window
    left = int((window.winfo_screenwidth() - width) / 2)
    top = int((window.winfo_screenheight() - height) / 2)

    # Changing the attributes
    window.geometry(f'{width}x{height}+{left}+{top}')
    window.resizable(0, 0)
    window.attributes('-topmost', 1)

    header = ttk.Label(window, text='This is an List Example')
    header.pack(fill='x', padx=5, pady=5)

    columns = ('name', 'username', 'email')

    elements = [
        ('Elio', 'elio', 'elio@mail.com'),
        ('Day', 'day', 'day@mail.com'),
        ('Eli', 'eli', 'eli@mail.com')
    ]

    global elementList
    elementList = ttk.Treeview(
        window, columns=columns, show='headings', height=100, selectmode='browse')

    elementList.heading('name', text='Name')
    elementList.heading('username', text='Username')
    elementList.heading('email', text='Email')

    for element in elements:
        elementList.insert('', tk.END, values=element)

    elementList.bind('<<TreeviewSelect>>', showElement)

    elementList.pack(padx=5, pady=5)

    window.mainloop()


def showElement(event):
    showinfo(
        title='Element',
        message=elementList.item(elementList.selection())['values']
    )


if __name__ == '__main__':
    main()
