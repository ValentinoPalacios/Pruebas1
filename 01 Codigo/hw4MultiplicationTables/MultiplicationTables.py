
while True:

    number = input("Enter a number to see its multiplication table (1-12): ")
    
    if not number.isdigit():
        print("Please enter a valid number.")
        continue
    
    number = int(number)
    
    if number < 1 or number > 12:
        print("You can only enter numbers from 1 to 12.")
        continue
    
    print(f"\nMultiplication table for {number}:")
    for i in range(1, 13):
        print(f"{number} x {i} = {number * i}")
    
    choice = input("\nDo you want to see another table? (yes/no): ").strip().lower()
    if choice != "yes":
        print("Goodbye!")
        break
