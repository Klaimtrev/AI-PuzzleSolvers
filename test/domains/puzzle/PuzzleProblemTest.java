package domains.puzzle;

import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Your name here
 */
public class PuzzleProblemTest {
    
    /**
     * Declare private instance fields here. For example:
     */
    
    private final Problem problem;
    private final Mover mover;
    private final String slide1, slide2, slide3, slide4,   // move names
                         slide5, slide6, slide7, slide8;
    
    public PuzzleProblemTest() {

        /**
         * Initialize instance fields here
         */
        problem = new PuzzleProblem();
        mover = problem.getMover();
        slide1= "SLIDE TILE 1";
        slide2= "SLIDE TILE 2";
        slide3= "SLIDE TILE 3";
        slide4= "SLIDE TILE 4";
        slide5= "SLIDE TILE 5";
        slide6= "SLIDE TILE 6";
        slide7= "SLIDE TILE 7";
        slide8= "SLIDE TILE 8";
    }

    @Test
    public void testSolution() {
        
	/**
	 * Display a welcome, the problem introduction, and the initial state.
	 * Perform moves until the problem is solved, making appropriate
	 * assertions along the way.
	 * Use FarmerProblemTest as a model.
	 */
        display("Welcome to the " + problem.getName() + " problem");
        display(problem.getIntroduction());
        display(problem.getCurrentState());
        assertFalse(problem.success());
        
        tryMove("SLIDE TILE 6");
        assertFalse(problem.success());
        
        tryMove("SLIDE TILE 8");
        assertFalse(problem.success());
        
        tryMove("SLIDE TILE 2");
        assertFalse(problem.success());
        
        tryMove("SLIDE TILE 1");
        assertFalse(problem.success());
        
        tryMove("SLIDE TILE 8");
        assertTrue(problem.success());
    }
    private void tryMove(String move) {
        State next = mover.doMove(move, problem.getCurrentState());
        assertTrue(next != null);
        problem.setCurrentState(next);
        display(problem.getCurrentState());
    }
    private void display(Object o) {
        System.out.println(o + "\n");
    }
    
}