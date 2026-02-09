import tkinter as tk
from tkinter import messagebox

from model.sorting_context import SortingContext
from controller.MongoDAO import MongoDAO

class StrategyGUI(tk.Tk):

    def __init__(self):
        super().__init__()
        self.title("Strategy Pattern - Sorting")
        self.geometry("420x200")
        self.create_widgets()

    def create_widgets(self):
        self.lbl_numbers = tk.Label(self, text="Numbers separated by ,")
        self.lbl_numbers.pack(pady=5)

        self.txt_numbers = tk.Entry(self, width=40)
        self.txt_numbers.pack(pady=5)

        self.btn_accept = tk.Button(self, text="Accept", command=self.process_numbers)
        self.btn_accept.pack(pady=10)

        self.lbl_result = tk.Label(self, text="", wraplength=380)
        self.lbl_result.pack(pady=5)

    def process_numbers(self):
        input_text = self.txt_numbers.get()

        try:
            numbers = [int(x.strip()) for x in input_text.split(",")]

            sc = SortingContext()
            sorted_numbers = sc.sort(numbers)
            strategy_name = sc.get_strategy_name()

            self.lbl_result.config(
                text=f"{sorted_numbers}  Algorithm: {strategy_name}"
            )

            dao = MongoDAO()
            saved = dao.save(numbers)


            if saved:
                messagebox.showinfo("MongoDB", "Numbers saved to MongoDB!")
            else:
                messagebox.showerror("MongoDB", "Error saving to MongoDB.")

        except ValueError:
            messagebox.showerror(
                "Input Error",
                "Please enter valid numbers separated by commas."
            )


if __name__ == "__main__":
    app = StrategyGUI()
    app.mainloop()
