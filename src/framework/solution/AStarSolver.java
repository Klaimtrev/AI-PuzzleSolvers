package framework.solution;

import framework.graph.Vertex;
import framework.problem.Problem;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/* imports go here */

/**
 * This class represents an A* solver by extending the StateSpaceSolver
 * class.
 * @author Your name and section here
 */
public class AStarSolver extends StateSpaceSolver {
    
    /**
     * Creates an A* solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem 
     */
    public AStarSolver(Problem problem) {
        super(problem, false);
        //Comparator<Vertex> comparator = null;
        comparator = getComparator();
        getStatistics().setHeader(problem.getName()+"\n"+"A* Search");
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(10, comparator);
        setQueue(queue);
    }
    
    /**
     * Adds a vertex to the PQ.
     * @param v the vertex to be added
     */
    @Override
    public void add(Vertex v) {
        getQueue().add(v);
    }
    
    /**
     * Creates a comparator object that compares vertices for ordering
     * in a PQ during A* search.
     * This should be used when creating the PQ.
     * @return the comparator object
     */
    public final Comparator<Vertex> getComparator() {
        
        return (v1, v2) -> {
            int cost1 = v1.getDistance();
            int cost2 = v2.getDistance();
            return Integer.compare(cost1, cost2);
        };
    }
    private final Comparator<Vertex> comparator;
}