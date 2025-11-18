import json
import os
import json
import sys

from model.Doll import Doll

class DollController:
    def __init__(self):
        self.dolls = []

    def add_doll(self, doll):
        if any(d.id == doll.id for d in self.dolls):
            print(f"Error: ID {doll.id} already exists.")
            return False
        self.dolls.append(doll)
        return True

    def display_dolls(self):
        if not self.dolls:
            print("No dolls available.")
        else:
            print("\n--- All Dolls ---")
            for doll in self.dolls:
                print(doll)

    def save_to_json(self, filename):
        with open(filename, "w") as f:
            json.dump([d.to_dict() for d in self.dolls], f, indent=4)

    def load_from_json(self, filename):
        try:
            with open(filename, "r") as f:
                data = json.load(f)
                self.dolls = [Doll.from_dict(d) for d in data]
        except FileNotFoundError:
            self.dolls = []