import requests
import json


API_KEY = '34ad3cd6b989177596a7e73be0a98fba'

#Getting weather data from API

def get_weather_data(location):
    base_url = "http://api.openweathermap.org/data/2.5/weather"
    params = {
        'q': location,
        'appid': API_KEY,
        'units': 'metric'
    }
    response = requests.get(base_url, params=params)
    data = response.json()
    return data
# getting forcast details from API

def get_forecast_data(location):
    base_url = "http://api.openweathermap.org/data/2.5/forecast"
    params = {
        'q': location,
        'appid': API_KEY,
        'units': 'metric'
    }
    response = requests.get(base_url, params=params)
    data = response.json()
    return data['list']

#function to display results

def Display_results():
    print("Welcome to the Weather App!")
    while True:
        choice = input("1. Get Current Weather\n2. Get Weather Forecast\n3. Exit\nYour choice: ")

        if choice == '1':
            location = input("Enter a location: ")
            weather_data = get_weather_data(location)
            print("Current Weather in", location)
            print("Temperature:", weather_data['main']['temp'], "°C")
            print("Weather:", weather_data['weather'][0]['description'])

        elif choice == '2':
            location = input("Enter a location: ")
            forecast_data = get_forecast_data(location)
            print("Weather Forecast in", location)
            for forecast in forecast_data:
                print(f"Date: {forecast['dt_txt']}, Temperature: {forecast['main']['temp']} °C, Weather: {forecast['weather'][0]['description']}")

        elif choice == '3':
            print("Thanks for using the Weather App. Goodbye!")
            break

        else:
            print("Invalid choice. Please choose a valid option.")

if __name__ == "__main__":
    Display_results()
