"""
Chicken Model
@author Paulo Ramos
"""
class Chicken:
    def __init__(self):
        self._id = 0
        self._name = ""
        self._color = ""
        self._age = 0
        self._is_molting = False

    def __str__(self):
        return f"Chicken{{\nid-->{self._id}, \nname-->{self._name}, \ncolor-->{self._color}, \nage-->{self._age}, \nis_molting-->{self._is_molting}}}"
    
    def set_id(self, id):
        self._id = id

    def get_id(self):
        return self._id

    def get_name(self):
        return self._name

    def set_name(self, name):
        self._name = name

    def get_color(self):
        return self._color

    def set_color(self, color):
        self._color = color

    def get_age(self):
        return self._age

    def set_age(self, age):
        self._age = age

    def get_is_molting(self):
        return self._is_molting

    def set_is_molting(self, is_molting):
        self._is_molting = is_molting