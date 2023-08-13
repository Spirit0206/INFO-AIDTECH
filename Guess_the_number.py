import random

# welcome text

print("welcome! Enter your name")
name = input()

# welcome user by pronouncing their name

# coardinating rules to play the game

def mymethod():
    # welcome the user
    print(f"welcome {name}! This is guess the number game and the instruction to play it are given bewlow")
    print("Some of the rules to play this game are as follows-")

    # rule 1
    print("1. you can to guess the number between 1 to 100")
    # rule2
    print("2. you get only 10 attempts to guess the number.")
    # rule 3
    print("3. If you will not guess the number , the game will be over and you will loss.")
    # rule 4
    print("4. If you guess the number within 10 attempts you will win.")
    # rule 5
    print("5. At every step you will get the instruction like number is too high or too low etc.")
    # rule 6
    print("6. Lastly if you want to play tha game again just press 1 and if you want to exit just press 2 from your keyboard.")


# function to check weitheer the number guesssed is right or not

def check():
    randnum = random.randint(1, 101)
    attempts = 0
    while attempts <= 10:
        try:
            user_guess = int(input("Enter your guess: "))
            attempts += 1
            if user_guess < randnum:
                print("Too low! Try a higher number.")
            elif user_guess > randnum:
                print("Too high! Try a lower number.")
            else:
                print(f"Congratulations! You guessed the right number which is {randnum} in {attempts} attempts.")
                break

        except ValueError:
            print("Invalid input. Please enter a valid number.")


# function to know user opinion weither they want to play the game or not

def guess_number():
    print("Lets go! Are you excited to play the game!")
    try:
        while True:
            user_choice = int(input("Press 1 to start or 2 to exit!"))
            if user_choice == 1:
                check()
            else:
                print("Thank you for playing the game now you can exit.")
                break
    except ValueError:
        print("please enter valid number!")


if __name__ == "__main__":
    mymethod()
    guess_number()