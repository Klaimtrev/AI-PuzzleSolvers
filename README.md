# AI-PuzzleSolvers

![AIPuzzleSolverUI](https://github.com/user-attachments/assets/9ed3e853-bd38-4c3b-81c5-b9de890040b1)

A JavaFX-based project featuring four small games alongside AI solvers (BFS, DFS, A*) for solving in-game challenges. This is project implemented in Java using NetBeans. 

## Features :books:
- **Graphical User Interface**: A GUI built with JavaFX to interact with the puzzle problem and see the solution steps.
- **Multiple Search Algorithms**: Choose between BFS, DFS, and A* search to solve the puzzle.
- **Statistics Display**: Displays the statistics of the search process such as number of moves, time taken, and search type.
- **Reset & Solve**: Options to reset the puzzle and solve it step-by-step or automatically.


## Getting Started :rocket:

### Prerequisites :memo: 

To run this project, you need the following:
- JDK 1.8 (Java 8)
- JavaFX
- Recommended: Netbeans IDE

### Setup :gear:

With Netbeans:
- Go to team -> Git -> Clone
- In the Repository URL paste this:
  ```bash
  git clone https://github.com/Klaimtrev/AI-PuzzleSolvers.git
- Do not forget to select a destination folder
- Click on Next -> Next -> Finish
- A new project will open, click on clean compile
- Finally run the ProblemApplication which is located inside Source Packages\framework.ui\

Without Netbeans
- Create a new folder for the project
- Open cmd and paste:
  ```bash
  git clone https://github.com/Klaimtrev/AI-PuzzleSolvers.git
- Now that the project is in your folder open it with your favorite IDE
- Compile it
- Go to src\framework\ui\
- Run ProblemApplication.java


## GUI Overview :iphone: 
The main window consists of:

- Problem Information: Displays the problem's name, introduction, and current state.

- State Information: Shows the current state and the goal state of the puzzle.

- Action Buttons: Buttons to make moves, solve the problem, or reset it.

- Search Type Selection: Choose between BFS or DFS search algorithms for solving the puzzle.

- A Solver*: Option to solve the puzzle using the A* search algorithm.

- Statistics: Displays the statistics of the AI search algorithms.

## DEMO :tv:


https://github.com/user-attachments/assets/b0445463-cfc3-4d50-8c7c-e648152e6b9d



## Author :writing_hand: 

- [Diego Minaya](https://github.com/Klaimtrev)
