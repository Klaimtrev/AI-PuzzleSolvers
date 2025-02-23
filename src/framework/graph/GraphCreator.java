/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.graph;

import framework.problem.Problem;
import java.util.Stack;
import framework.graph.Vertex;
import framework.problem.State;
import java.util.List;
import java.util.Vector;

/**
 * @author Your name here
 */
public class GraphCreator {
    
    public Graph createGraphFor(Problem problem) {
        graph = new Graph();
        stack = new Stack();
        start = new Vertex(problem.getInitialState());
        stack.push(start);
        moveNames = problem.getMover().getMoveNames();
        arr = new Vector();//this is not necessary
        while (!stack.empty()){
            u = (Vertex)(stack.pop());
            for (String item: moveNames){
                next=problem.getMover().doMove(item, (State)u.getData());
                if (next!=null){
                    v= new Vertex(next);
                    if (graph.getVertices().containsKey(v)){
                        
                        //System.out.print("\n Repeated Vertex"+ v.toString());
                        v = graph.getVertices().get(v);
                    }
                    else{
                            stack.push(v);
                            //System.out.print("\n New Vertex"+ v.toString());
                            }
                    //System.out.print("Vertex Added"+v.toString() );
                    graph.addEdge(u,v);
                }
            }
        }
        //System.out.print(graph.toString());
        return graph;
    }
    
    private Graph graph = null;
    private Stack stack = null;
    private List<String> moveNames;
    private Vertex start;
    private Vertex u;
    private State next;
    private Vertex v;
    private Vector arr;
}