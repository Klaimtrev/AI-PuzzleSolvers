/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;

import domains.arithmetic.ArithmeticProblem;
import domains.dummy.DummyProblem;
import domains.farmer.FarmerGUI;
import domains.farmer.FarmerProblem;
import domains.puzzle.PuzzleProblem;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * This class presents problem solving domains in a tabbed pane.
 */
public class ProblemApplication extends Application {

    private Node FarmerGUI;
    
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        
	/* Add tabs using the following */
        /*Farmer Problem*/
	Tab tab = new Tab();
        tab.setText("FarmerProblem");
        tab.setContent(new ProblemGUI(new FarmerProblem(), 500, 700));
        tabPane.getTabs().add(tab);
        
        /*Dummy Problem*/
        Tab tab2 = new Tab();
        tab2.setText("DummyProblem");
        tab2.setContent(new ProblemGUI(new DummyProblem(), 500, 700));
        tabPane.getTabs().add(tab2);
        
        /*Arithmetic Problem*/
        Tab tab3 = new Tab();
        tab3.setText("ArithmeticProblem");
        tab3.setContent(new ProblemGUI(new ArithmeticProblem(), 500, 700));
        tabPane.getTabs().add(tab3);
        
        /*Puzzle Problem*/
        Tab tab4 = new Tab();
        tab4.setText("PuzzleProblem");
        tab4.setContent(new ProblemGUI(new PuzzleProblem(), 500, 700));
        tabPane.getTabs().add(tab4);

	//... 
        
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("Problem Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}