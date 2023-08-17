import json

# class contain structure
class Task:
    def __init__(self, title, description, status="Not Started"):
        self.title = title
        self.description = description
        self.status = status

    def __str__(self):
        return f"Title: {self.title}\nDescription: {self.description}\nStatus: {self.status}"

#class contain various methods to perform operations

class ToDoList:
    def __init__(self):
        self.tasks = []

    def add_task(self, task):
        self.tasks.append(task)

    def delete_task(self, index):
        if 1 <= index <= len(self.tasks):
            del self.tasks[index - 1]
            print("Task deleted successfully.")
        else:
            print("Invalid task index.")

    def view_tasks(self):
        if self.tasks:
            for index, task in enumerate(self.tasks, start=1):
                print(f"Task {index}:\n{task}\n")
        else:
            print("No tasks found.")

    def save_tasks(self, filename):
        with open(filename, "w") as file:
            task_data = [{"title": task.title, "description": task.description, "status": task.status} for task in self.tasks]
            json.dump(task_data, file)
        print("Tasks saved to file.")

    def load_tasks(self, filename):
        try:
            with open(filename, "r") as file:
                task_data = json.load(file)
                self.tasks = [Task(data["title"], data["description"], data["status"]) for data in task_data]
            print("Tasks loaded from file.")
        except FileNotFoundError:
            print("No tasks found in the file.")

#Function to perform task as per user requirement

def perform_operations():
    todo_list = ToDoList()

    while True:
        print("\nTo-Do List App")
        print("1. Add Task")
        print("2. Delete Task")
        print("3. View Tasks")
        print("4. Save Tasks")
        print("5. Load Tasks")
        print("6. Exit")

        choice = input("Select an option: ")

        if choice == "1":
            title = input("Enter task title: ")
            description = input("Enter task description: ")
            status = input("Enter task status (default: Not Started): ")
            task = Task(title, description, status)
            todo_list.add_task(task)
            print("Task added successfully.")
        elif choice == "2":
            index = int(input("Enter the index of the task to delete: "))
            todo_list.delete_task(index)
        elif choice == "3":
            todo_list.view_tasks()
        elif choice == "4":
            filename = input("Enter the filename to save tasks: ")
            todo_list.save_tasks(filename)
        elif choice == "5":
            filename = input("Enter the filename to load tasks: ")
            todo_list.load_tasks(filename)
        elif choice == "6":
            print("Exiting the app.")
            break
        else:
            print("Invalid choice. Please choose again.")

if __name__ == "__main__":
    perform_operations()


