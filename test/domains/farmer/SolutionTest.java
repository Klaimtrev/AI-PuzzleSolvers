/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego Minaya D
 */
package domains.farmer;

import domains.farmer.FarmerState;
import framework.graph.Vertex;
import framework.solution.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the Solution class.
 * It creates a simple two-move solution to the FWGC problem
 * and tests its access methods.
 * @author tcolburn
 */
public class SolutionTest {
    
    public SolutionTest() {
        start = new Vertex(new FarmerState("East", 
                                           "East",
                                           "West",
                                           "East"));
        intermediate = 
                new Vertex(new FarmerState("West", 
                                           "East",
                                           "West",
                                           "East"));
        end =   new Vertex(new FarmerState("East", 
                                           "East",
                                           "East",
                                           "East"));
        end.setPredecessor(intermediate);
        intermediate.setPredecessor(start);
        start.setPredecessor(null);
    }
    
    @Test
    public void testSolution() {
        Solution solution = new Solution(start, end);
	assertTrue(solution.getLength() == 2);
        assertTrue(solution.hasNext());
        assertTrue(solution.next() == start);
        assertTrue(solution.next() == intermediate);
        assertTrue(solution.next() == end);
        assertFalse(solution.hasNext());
    }

    /**
     * This test prints the solution to standard output.
     */
    @Test
    public void testOutput() {
        Solution solution = new Solution(start, end);
        while (solution.hasNext()) {
            System.out.println(solution.next().toString() + "\n\n");
        }
    }
    
    private final Vertex start;
    private final Vertex intermediate;
    private final Vertex end;
    
}