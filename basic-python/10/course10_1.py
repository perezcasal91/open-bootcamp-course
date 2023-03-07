import tkinter as tk
from tkinter import ttk


def main():
    window = tk.Tk()
    window.title('Course 10 Exe 1')

    # Window Size
    width = 250
    height = 200

    # Centering the Window
    left = int((window.winfo_screenwidth() - width) / 2)
    top = int((window.winfo_screenheight() - height) / 2)

    # Changing the attributes
    window.geometry(f'{width}x{height}+{left}+{top}')
    window.resizable(0, 0)
    window.attributes('-topmost', 1)
    window.columnconfigure(0, weight=1)
    window.columnconfigure(1, weight=1)
    window.columnconfigure(2, weight=1)

    global radio
    radio = tk.StringVar()
    r1 = ttk.Radiobutton(window, text='Radio 1', value='R1', variable=radio)
    r2 = ttk.Radiobutton(window, text='Radio 2', value='R2', variable=radio)
    r3 = ttk.Radiobutton(window, text='Radio 3', value='R3', variable=radio)
    r1.grid(row=0, column=0, sticky='NW', padx=15, pady=5)
    r2.grid(row=0, column=1, sticky='N', pady=5)
    r3.grid(row=0, column=2, sticky='NE', padx=10, pady=5)
    reset = ttk.Button(window, text='Reset', command=resetRadio)
    reset.grid(row=1, column=0, columnspan=3, sticky='S', pady=5)

    window.mainloop()


def resetRadio():
    radio.set(None)


if __name__ == '__main__':
    main()
