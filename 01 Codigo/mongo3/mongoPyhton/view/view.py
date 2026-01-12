import tkinter as tk
from tkinter import messagebox
from controller.MongoCrud import MongoCrud
from model.Store import Store
from tkinter import ttk

class View:

    def __init__(self):
        self.mongo = MongoCrud()

        self.root = tk.Tk()
        self.root.title("Store CRUD")

        tk.Label(text="ID:").grid(row=0, column=0)
        tk.Label(text="Name:").grid(row=1, column=0)
        tk.Label(text="Price:").grid(row=2, column=0)
        tk.Label(text="Price IVA:").grid(row=3, column=0)

        self.txt_id = tk.Entry()
        self.txt_name = tk.Entry()
        self.txt_price = tk.Entry()
        self.txt_price_iva = tk.Entry()

        self.txt_id.grid(row=0, column=1)
        self.txt_name.grid(row=1, column=1)
        self.txt_price.grid(row=2, column=1)
        self.txt_price_iva.grid(row=3, column=1)

        tk.Button(text="Save", command=self.save).grid(row=4, column=0)
        tk.Button(text="Find", command=self.find).grid(row=4, column=1)
        tk.Button(text="Update", command=self.update).grid(row=5, column=0)
        tk.Button(text="Delete", command=self.delete).grid(row=5, column=1)
        tk.Button(text="Load", command=self.load_table).grid(row=6, column=1)


        columns = ("ID", "Name", "Price", "IVA")

        self.table = ttk.Treeview(self.root, columns=columns, show="headings")
        self.table.grid(row=7, column=0, columnspan=2, sticky="nsew")

        self.table.heading("ID", text="ID")
        self.table.heading("Name", text="Name")
        self.table.heading("Price", text="Price")
        self.table.heading("IVA", text="Price IVA")

        self.table.column("ID", width=80)
        self.table.column("Name", width=150)
        self.table.column("Price", width=100)
        self.table.column("IVA", width=100)

        self.root.mainloop()

    def save(self):
        store = Store(
            int(self.txt_id.get()),
            self.txt_name.get(),
            float(self.txt_price.get())
        )
        self.mongo.create(store)
        self.txt_price_iva.delete(0, tk.END)
        self.txt_price_iva.insert(0, store.calculate_price_iva())
        messagebox.showinfo("OK", "Store saved")
    
    
    def find(self):
        self.clear_table()

        store = self.mongo.read_by_id(int(self.txt_id.get()))

        if store:
            self.txt_name.delete(0, tk.END)
            self.txt_price.delete(0, tk.END)
            self.txt_price_iva.delete(0, tk.END)

            self.txt_name.insert(0, store.name)
            self.txt_price.insert(0, store.price)
            self.txt_price_iva.insert(0, store.price_iva)

            self.table.insert("", tk.END, values=(
                store.id,
                store.name,
                f"{store.price:.2f}",
                f"{store.price_iva:.2f}"
            ))
        else:
            messagebox.showerror("Error", "Store not found")


    def update(self):
        store = Store(
            int(self.txt_id.get()),
            self.txt_name.get(),
            float(self.txt_price.get())
        )
        self.mongo.update(store)
        self.txt_price_iva.delete(0, tk.END)
        self.txt_price_iva.insert(0, store.calculate_price_iva())
        messagebox.showinfo("OK", "update store")

    def delete(self):
        self.mongo.delete(int(self.txt_id.get()))
        self.txt_id.delete(0, tk.END)
        self.txt_name.delete(0, tk.END)
        self.txt_price.delete(0, tk.END)
        self.txt_price_iva.delete(0, tk.END)
        messagebox.showinfo("OK", "Store deleted")

    def load_table(self):
        self.clear_table()

        stores = self.mongo.read_all()

        for store in stores:
            self.table.insert("", tk.END, values=(
                store.id,
                store.name,
                f"{store.price:.2f}",
                f"{store.price_iva:.2f}"
            ))


    def clear_table(self):
        for row in self.table.get_children():
            self.table.delete(row)

if __name__ == "__main__":
    View()
