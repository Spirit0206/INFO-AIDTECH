import random

#function which generate random number between 1 to 6

def roll_dice(num_dice):
    return [random.randint(1, 6) for _ in range(num_dice)]

#function to display the result and for continue and exit the app

def perform_roll():
    print("Welcome to the Dice Rolling App!")
    while True:
        try:
            num_dice = int(input("Enter the number of dice you want to roll: "))
            if num_dice <= 0:
                print("Please enter a positive number.")
                continue

            dice_results = roll_dice(num_dice)
            print("You rolled:", ", ".join(str(result) for result in dice_results))

            play_again = input("Do you want to roll again? (y/n): ").lower()
            if play_again != 'y':
                print("Thanks for using the Dice Rolling App. Goodbye!")
                break
        except ValueError:
            print("Invalid input. Please enter a valid number.")


if __name__ == "__main__":
    perform_roll()
