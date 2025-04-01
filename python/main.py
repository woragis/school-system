# import customtkinter as ctk

# # Configure appearance and theme
# ctk.set_appearance_mode("System")
# ctk.set_default_color_theme("blue")

# # Initialize the main window
# app = ctk.CTk()
# app.title("CustomTkinter Interface")
# app.geometry("400x300")

# # Create a label
# label = ctk.CTkLabel(
#     master=app, text="Welcome to CustomTkinter!", font=("Helvetica", 16))
# label.pack(pady=20)

# # Create an entry widget
# entry = ctk.CTkEntry(master=app, placeholder_text="Type something...")
# entry.pack(pady=10)

# # Define the button click event


# def on_button_click():
#     print("Button clicked!")
#     user_input = entry.get()
#     print(f"User input: {user_input}")


# # Create a button
# button = ctk.CTkButton(master=app, text="Submit", command=on_button_click)
# button.pack(pady=10)

# # Run the application
# app.mainloop()

# from tkinter import ttk
# import tkinter as tk

# root = tk.Tk()
# root.title("Custom Tkinter Interface")
# root.geometry("400x300")  # Set the window size

# # Create a main frame
# main_frame = tk.Frame(root, bg='#f0f0f0')  # Set background color
# main_frame.pack(fill='both', expand=True, padx=10, pady=10)
# # Add a label
# label = tk.Label(main_frame, text="Enter your name:",
#                  bg='#f0f0f0', font=('Helvetica', 12))
# label.pack(pady=5)

# # Add an entry widget
# entry = tk.Entry(main_frame, font=('Helvetica', 12), bd=2, relief='groove')
# entry.pack(pady=5)

# # Add a button


# def on_submit():
#     name = entry.get()
#     print(f"Hello, {name}!")


# button = tk.Button(main_frame, text="Submit", command=on_submit,
#                    bg='#4CAF50', fg='white', font=('Helvetica', 12), relief='raised')
# button.pack(pady=10)

# # Create a style object
# style = ttk.Style()
# style.configure('TButton', font=('Helvetica', 12), padding=10)
# style.configure('TLabel', font=('Helvetica', 12), background='#f0f0f0')
# style.configure('TEntry', font=('Helvetica', 12))

# # Use ttk widgets with the defined styles
# label = ttk.Label(main_frame, text="Enter your name:")
# label.pack(pady=5)

# entry = ttk.Entry(main_frame)
# entry.pack(pady=5)

# button = ttk.Button(main_frame, text="Submit", command=on_submit)
# button.pack(pady=10)

# root.mainloop()

from tkinter import Tk
import tkinter as ttk


def hello_world():
    print('hi')


root = Tk()
frm = ttk.Frame(root)
frm.grid()
ttk.Label(frm, text="Hello World!").grid(column=0, row=0)
ttk.Button(frm, text="Quit", command=root.destroy).grid(column=1, row=0)
root.mainloop()
