package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Your name here
 */
public class PuzzleMoverTest {
        
    /**
     * Declare private instance fields here. For example:
     */
    
    private final State start;
    private final Mover mover;
    private final String slide1, slide2, slide3, slide4,  // move names
	                 slide5, slide6, slide7, slide8;
    
    public PuzzleMoverTest() {
        start = new PuzzleState(
                new int[][]{new int[]{1, 2, 3}, 
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});

        mover = new PuzzleMover();
        slide1= "SLIDE TILE 1";
        slide2= "SLIDE TILE 2";
        slide3= "SLIDE TILE 3";
        slide4= "SLIDE TILE 4";
        slide5= "SLIDE TILE 5";
        slide6= "SLIDE TILE 6";
        slide7= "SLIDE TILE 7";
        slide8= "SLIDE TILE 8";
        
    }
    
    /**
     * Test all moves in the methods below by replacing the calls to fail.
     */

    @Test
    public void testSlide1() {
        /**
         * For example, if mover, start, and slide1 have been
         * initialized, call:
         *
         *     mover.doMove(slide1, start)
         *
         * and test the result with assertions.
         */
//        State next = mover.doMove(slide1, start);
//        assertTrue(next.equals( new PuzzleState(
//                            new int[][]{new int[]{0, 2, 3}, 
//                            new int[]{8, 1, 4}, 
//                            new int[]{7, 6, 5}}))); 
//        display(mover.doMove(slide1,start));
    assertTrue(mover.doMove(slide1,start)==null);
    }

    @Test
    public void testSlide2() {
        State next = mover.doMove(slide2, start);
        assertTrue(next.equals( new PuzzleState(
                            new int[][]{new int[]{1, 0, 3}, 
                            new int[]{8, 2, 4}, 
                            new int[]{7, 6, 5}})));    
        display(mover.doMove(slide2,start));
    }

    @Test
    public void testSlide3() {
        assertTrue(mover.doMove(slide3,next)==
                            new PuzzleState(
                            new int[][]{new int[]{1, 3, 0}, 
                            new int[]{8, 2, 4}, 
                            new int[]{7, 6, 5}}));
        assertTrue(mover.doMove(slide3,start)==null);      
    }

    @Test
    public void testSlide4() { 
        State next = mover.doMove(slide4, start);
        assertTrue(next.equals( new PuzzleState(
                            new int[][]{new int[]{1, 2, 3}, 
                            new int[]{8, 4, 0}, 
                            new int[]{7, 6, 5}})));    
       display(mover.doMove(slide4,start));
    }

    @Test
    public void testSlide5() {
        assertTrue(mover.doMove(slide5,start)==null);       
    }

    @Test
    public void testSlide6() {
        State next = mover.doMove(slide6, start);
        assertTrue(next.equals( new PuzzleState(
                            new int[][]{new int[]{1, 2, 3}, 
                            new int[]{8, 6, 4}, 
                            new int[]{7, 0, 5}})));    
       display(mover.doMove(slide6,start));        
       display (next);
    }

    @Test
    public void testSlide7() {
        assertTrue(mover.doMove(slide7,start)==null);        
    }

    @Test
    public void testSlide8() {
        State next = mover.doMove(slide8, start);
        assertTrue(next.equals( new PuzzleState(
                            new int[][]{new int[]{1, 2, 3}, 
                            new int[]{0, 8, 4}, 
                            new int[]{7, 6, 5}})));    
       display(mover.doMove(slide8,start));        
    }
    private void display(Object o) {
        System.out.println(o + "\n");
    }
    
    private State next;
    private State nextu;
    
}