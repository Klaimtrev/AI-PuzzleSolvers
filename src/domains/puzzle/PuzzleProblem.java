/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;

/**
 *
 * @author Diego Minaya D
 */
import domains.arithmetic.ArithmeticMover;
import domains.arithmetic.ArithmeticState;
import framework.problem.Problem;
import framework.problem.Mover;
import framework.problem.State;
public class PuzzleProblem extends Problem {
    public PuzzleProblem() {
            super();
            super.setName("Puzzle");
            super.setIntroduction(INTRO);
            super.setMover(new PuzzleMover());
            super.setInitialState(new PuzzleState(
                            new int[][]{new int[]{2, 8, 3}, 
                            new int[]{1, 6, 4}, 
                            new int[]{7, 0, 5}}));
            super.setCurrentState(super.getInitialState());
            super.setFinalState(new PuzzleState(
                            new int[][]{new int[]{1, 2, 3}, 
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}}));
                            
    }
           private static final String INTRO = 
                "Welcome to the 8 Puzzle Problem! \n"
                   + "You are given a board in which numbered tiles can slide around. "
                   + "There is one blank space that holds no tile. "
                   + " A legal move consists of sliding a tile into the blank space if the tile is adjacent to it. "
                   + "The goal is to move tiles around until the board looks like the final state below";
        }

