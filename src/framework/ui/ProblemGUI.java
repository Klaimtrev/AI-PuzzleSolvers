/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;

import framework.graph.Graph;
import framework.graph.GraphCreator;
import framework.graph.GraphSearcher;
import framework.graph.Vertex;
import framework.problem.Problem;
import framework.problem.State;
import framework.solution.AStarSolver;
import framework.solution.Solution;
import framework.solution.SolvingAssistant;
import framework.solution.StateSpaceSolver;
import static java.awt.Color.black;
import java.util.List;
import java.util.Vector;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.BorderFactory;



/**
 *
 * @author Diego Minaya D
 */
public class ProblemGUI extends VBox {
    
    /**
     * Creates a problem GUI with a given width height and a problem
     * @param problem the problem
     * @param width the width of the display area
     * @param height the height of the display area
     */
    public ProblemGUI(Problem problem, double width, double height) {
        this.problem = problem;
        System.out.print("HERE IS THE "+this.problem);
        setPrefHeight(height);
        setPrefWidth(width*1.5);
        numberOfMoves=0;
        solver = new SolvingAssistant(problem);
        root = new VBox();
        root2 = new HBox();
        Vertical1 = new VBox();
        Vertical2= new VBox();
        /*SOLVING*/
        solving = new HBox();
//        graphcreator= new GraphCreator();
//        graph= new Graph();
//        graph =graphcreator.createGraphFor(problem);
//        graphSearcher = new GraphSearcher(graph);
        BFS = new StateSpaceSolver(problem, true);
        DFS = new StateSpaceSolver(problem,true);
        
        //createReset(solving);
        solvingCreateButtons();
        message = new Text(10, 50, "You solved the problem.\nCongratulations!");
        message.setFont(Font.font("Calisto MT",25));
        message.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
        moveNames = problem.getMover().getMoveNames();
        weekBorder = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(1.0), BorderStroke.MEDIUM));
        setAlignment(Pos.CENTER);
        welcomeMessage = new Label(problem.getName());
        setFont(welcomeMessage);
        currentState = new Label("Current State : ",state);
        setFont(currentState);
        goalState = new Label("Goal State: ", goal);
        setFont(goalState);
        currentState.setAlignment(Pos.CENTER);
        Moves = new Label("Moves: "+ solver.getMoveCount());
        setFont(Moves);
        introduction = new Label(problem.getIntroduction());
        introduction.setWrapText(true);
        goal = new Label((problem.getFinalState().toString()));
        StateLook(goal);
        state = new Label((problem.getCurrentState().toString()));
        StateLook(state);;
        CreateButtons(moveNames,root);
        Vertical1.getChildren().addAll(currentState,state);
        Vertical2.getChildren().addAll(goalState,goal);
        //root.getChildren().add(button);
        root2.getChildren().addAll(Vertical1,root,Vertical2);
        root2.setAlignment(Pos.CENTER);
        super.getChildren().addAll(welcomeMessage,
				   introduction,root2,solving);
        
    }
    /**
     * Creates the buttons and adds them to the VBox
     * This method is just used for the options of the problem.
     * @param List<String> mN is a list with the names of all the options
     * @param VBox v is a VBox where all the buttons will be added
     */
    private void CreateButtons(List<String> mN,VBox v){
        root.getChildren().add(Moves);
        for (String item : mN){
            button = new Button(item);
            button.setOnAction((event) -> {
                solver.tryMove(item);
                state = new Label((solver.getProblem().getCurrentState().toString()));
                Moves = new Label("Moves: "+ solver.getMoveCount());
                setFont(Moves);
                StateLook(state);
                Vertical1.getChildren().clear();
                Vertical1.getChildren().addAll(currentState,state);
                Vertical2.getChildren().clear();
                Vertical2.getChildren().addAll(goalState,goal);
                root.getChildren().clear();
                CreateButtons(moveNames,root);
                root2.getChildren().clear();
                root2.getChildren().addAll(Vertical1,root,Vertical2);
                super.getChildren().clear();
                super.getChildren().addAll(welcomeMessage,
				   introduction,root2,solving);
                //root.getChildren().add(CreateReset(root));
                if (solver.isProblemSolved()) {
                root.getChildren().add(message);
                        }
            });
            button.setAlignment(Pos.CENTER);
            v.getChildren().add(button);
            //CreateReset(root);
        }
    }
    /**
     * Returns the button to reset the problem
     * Resets the problem to its original state
     * This method is used to set the current state to its original state
     * @param VBox v is a VBox where the reset button will be added
     * @return the button to reset the problem
     */
    private Button createReset(){
        button = new Button("RESET");
        button.setOnAction((event) -> {
            solver.reset();
            state = new Label((solver.getProblem().getCurrentState().toString()));
            Moves = new Label("Moves: "+ solver.getMoveCount());
            setFont(Moves);
            StateLook(state);  
            Vertical1.getChildren().clear();
            Vertical1.getChildren().addAll(currentState,state);
            Vertical2.getChildren().clear();
            Vertical2.getChildren().addAll(goalState,goal);
            root.getChildren().clear();
            CreateButtons(moveNames,root);
            //root.getChildren().add(createReset());
            solving.getChildren().clear();
            solvingCreateButtons();
            //super.getChildren().add(solving);
            
            root2.getChildren().clear();
            root2.getChildren().addAll(Vertical1,root,Vertical2);
            super.getChildren().clear();
            super.getChildren().addAll(welcomeMessage,
				   introduction,root2);
        });
        return button;
    }
    private void solvingCreateButtons() {
        VBox Vertical1 = new VBox();
        VBox Vertical2 = new VBox();
        VBox Vertical3 = new VBox();
        VBox Vertical4 = new VBox();

        solve = new Button("SOLVE");
        next = new Button("NEXT");
        Button aiSolve = new Button("AI SOLVE");

        //next.disableProperty().bind(Bindings.not(solve.disableProperty()));

        scroll = new ChoiceBox<>();
        scroll.getItems().addAll("Breadth-First Search", "Depth-First Search");

        Text Search_Type = new Text("Search Type"); 
        Text Benchmarks = new Text("Benchmarks");
        Text Statistics = new Text("Statistics");

        solve.setOnAction(event -> {
            System.out.println("Solve button clicked!");

            if (problem == null) {
                System.out.println("Error: problem is null!");
                return;
            }
            
            // Get the selected search type
            String selectedSearch = (String) scroll.getValue();
            
            System.out.println("The selected SEARCH is: "+selectedSearch);


            // Determine whether BFS (true) or DFS (false)
            boolean bfs = "Breadth-First Search".equals(selectedSearch);

            StateSpaceSolver solver = new StateSpaceSolver(problem, bfs); 
            solver.solve();
            solution = solver.getSolution();
            
            //AStarSolver Asolver = new AStarSolver(problem); 
            //Asolver.solve();
            //solution = Asolver.getSolution();

            if (solution == null) {
                System.out.println("No solution found.");
            } else {
                System.out.println("Solution found:");
                System.out.print("Total moves: "+ solution.getLength());
            }
        });

        next.setOnAction(event -> {
            
            if (solution != null && solution.hasNext()) {
                Vertex nextStep = solution.next();  // Get next state
                
                Object data = nextStep.getData();
                
                if(data instanceof State){
                    problem.setCurrentState((State) data);
                    
                    state.setText(problem.getCurrentState().toString());
                }
                else{
                    System.out.print("Error: nextStep data is not State");
                }
                
                
                if (solver.isProblemSolved()) {
                    root.getChildren().add(message);
                }
            } else {
                System.out.println("No more steps in solution.");
            }
        });



        aiSolve.setOnAction(event -> {
            AStarSolver solver = new AStarSolver(problem); 
            solver.solve();
            solution = solver.getSolution();

            System.out.println("AI Solver Solution: " + solution);
        });

        Vertical1.getChildren().addAll(solve, next, aiSolve, createReset());
        Vertical2.getChildren().addAll(Search_Type, scroll);
        Vertical3.getChildren().addAll(Statistics);
        Vertical4.getChildren().addAll(Benchmarks);

        solving.getChildren().addAll(Vertical1, Vertical2, Vertical3);
    }

    /**
     * Creates the Border, Padding and Font for a Label
     * This method is used to set the Border, Padding and Font for a Label
     * This method is only used for states
     * @param Label s is the label that will be added certain properties
     */
    private void StateLook(Label s){
        s.setBorder(weekBorder);
                s.setPadding(new Insets(20, 40, 20, 40));
                s.setBorder(weekBorder);
                s.setFont(Font.font ("DejaVu Sans Mono", 20));
    }
    /**
     * Set the label font
     * This method is only used for labels (excluding states)
     * @param Label s is the label that will set the font to
     */
    private void setFont(Label s){
        s.setFont(Font.font("Calisto MT",25));
        s.setAlignment(Pos.CENTER);
    }
    
    /* Instance fields and helper methods here */
    private Label welcomeMessage;
    private Label introduction;
    private Label currentState;
    private Label state;
    private Label goalState;
    private Label Moves;
    private Label goal;
    private Border weekBorder;
    private VBox root;
    private VBox Vertical1;
    private VBox Vertical2;
    private HBox root2;
    private Button button;
    private List<String> moveNames;
    private final SolvingAssistant solver;
    private int numberOfMoves;
    private Text message;
    private Solution solution;

    
    /*For SOLVING*/
    private HBox solving;
    private Button solve;
    private Button next;
    private Button reset;
    private ChoiceBox scroll;
    private ChoiceBox benchmark;
//    private final GraphSearcher graphSearcher;
//    private GraphCreator graphcreator;
//    private Graph graph;
    private Problem problem;
    private StateSpaceSolver BFS;
    private StateSpaceSolver DFS;

}
