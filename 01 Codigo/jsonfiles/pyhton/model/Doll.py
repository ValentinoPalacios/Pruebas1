import json
import os
import json
import sys 

class Doll:
    def __init__(self, id, name, material, price):
        self.id = id
        self.name = name
        self.material = material
        self.price = price

    def __str__(self):
        return f"Doll(ID: {self.id}, Name: {self.name}, Material: {self.material}, Price: {self.price})"

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "material": self.material,
            "price": self.price
        }

    @staticmethod
    def from_dict(data):
        return Doll(data["id"], data["name"], data["material"], data["price"])

