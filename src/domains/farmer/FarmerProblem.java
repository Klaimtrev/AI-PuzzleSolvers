/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

/**
 *
 * @author Diego Minaya D
 */
import domains.arithmetic.ArithmeticMover;
import domains.arithmetic.ArithmeticState;
import framework.problem.Problem;
import framework.problem.Mover;
import framework.problem.State;
public class FarmerProblem extends Problem {
    public FarmerProblem() {
            super();
            super.setName("Welcome to the Farmer,Wolf, Goat and Cabbage Problem");
            super.setIntroduction(INTRO);
            super.setMover(new FarmerMover());
            super.setInitialState(new FarmerState("West","West","West","West"));
            super.setCurrentState(super.getInitialState());
            super.setFinalState(new FarmerState("East", 
                                      "East", 
                                      "East", 
                                      "East"));
        }
    private static final String INTRO = 
              
              "A farmer and his wolf, goat, and cabbage come to the edge of a river they wish to cross. "
            + "There is a boat at the river's edge that only the farmer can row."
            + " The farmer can take at most one other object besides himself on a crossing, but if the wolf is ever left with the goat, "
            + "the wolf will eat the goat; "
            + "similarly, if the goat is left with the cabbage, the goat will eat the cabbage."
            + " Devise a sequence of crossings of the river so that all four characters arrive safely on the other side.";
    
}
