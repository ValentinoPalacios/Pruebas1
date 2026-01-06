class Store:
    def __init__(self, id, name, price, price_iva=0):
        self.id = id
        self.name = name
        self.price = price
        self.price_iva = price_iva

    def calculate_price_iva(self):
        return self.price * 1.15
