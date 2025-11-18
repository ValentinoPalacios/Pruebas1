import os
import sys

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from model.Doll import Doll
from controller.DollController import DollController


def main():
    controller = DollController()
    controller.load_from_json("dolls.json")

    while True:
        try:
            id = int(input("Ingerse ID Doll(integer): "))
            if any(d.id == id for d in controller.dolls):
                print("ID already exists")
                continue
            name = input("Doll name ").strip()
            material = input("Ingerese Doll material: ").strip()
            price = float(input("Ingrese Doll Price (positive number): "))
            if price < 0:
                print("Price must be positive. Try again.")
                continue
            controller.add_doll(Doll(id, name, material, price))
        except ValueError:
            print("Invalid input ID must be integer and Price must be a number.")
            continue

        more = input("Add another Doll? (y/n): ").lower()
        if more != 'y':
            break

    controller.display_dolls()
    controller.save_to_json("dolls.json")
    print("Data guardados en dolls.json")

if __name__ == "__main__":
    main()
