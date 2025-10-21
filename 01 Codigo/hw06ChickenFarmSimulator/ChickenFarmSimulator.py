from Chicken import Chicken

class ChickenFarmSimulator:
    @staticmethod
    def main():
        print("This is my chicken Farm Simulator")
        
        owner = None
        id = 1
        name = "lucy"
        age = 2
        is_molting = False
        
        owner = "Paulo Ramos"
        
        # class object
        chicken = Chicken()
        chicken.set_id(id)
        chicken.set_name(name)
        chicken.set_age(age)
        chicken.set_is_molting(is_molting)
        
        print(f"The chicken is --> {chicken}")
        print(f"chicken id --> {chicken.get_id()}")

if __name__ == "__main__":
    ChickenFarmSimulator.main()