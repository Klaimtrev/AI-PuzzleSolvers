/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.graph.Graph;
import framework.graph.Vertex;

/**
 * A graph for the FWGC problem.
 * @author Your name and section here
 */
public class FarmerGraph extends Graph {
    
    public FarmerGraph() {
        /* you must provide */
        
    first =new Vertex(new FarmerState("West",
                                            "West",
                                            "West",
                                            "West"));
    
    second =new Vertex(new FarmerState("West",
                                            "East",
                                            "West",
                                            "East"));
    
    third =new Vertex(new FarmerState("West",
                                            "East",
                                            "West",
                                            "West"));
    
    fourth =new Vertex(new FarmerState("West",
                                            "West",
                                            "East",
                                            "West"));
    
    fifth =new Vertex(new FarmerState("West",
                                            "West",
                                            "West",
                                            "East"));
    
    sixth =new Vertex(new FarmerState("East",
                                            "East",
                                            "East",
                                            "East"));
    
    seventh =new Vertex(new FarmerState("East",
                                            "West",
                                            "East",
                                            "West"));
    
    
    eight =new Vertex(new FarmerState("East",
                                            "West",
                                            "East",
                                            "East"));
    
    ninth =new Vertex(new FarmerState("East",
                                            "East",
                                            "West",
                                            "East"));
    
    ten =new Vertex(new FarmerState("East",
                                            "East",
                                            "East",
                                            "West"));
    
    
    //Ading Vertices
        addEdge(first,seventh);addEdge(seventh,first);
        addEdge(seventh,fourth);addEdge(fourth,seventh);
        addEdge(fourth,ten);addEdge(ten,fourth);
        addEdge(fourth,eight);addEdge(eight,fourth);
        addEdge(ten,third);addEdge(third,ten);
        addEdge(eight,fifth);addEdge(fifth,eight);
        addEdge(fifth,ninth);addEdge(ninth,fifth);
        addEdge(third,ninth);addEdge(ninth,third);
        addEdge(ninth,second);addEdge(second,ninth);
        addEdge(second,sixth);addEdge(sixth,second);
    }
    
    public Vertex getStart() {
        return first;
        /* you must provide */
    }
    
    public Vertex getEnd() {
        return sixth;
        /* you must provide */
    }
    
    Vertex first ;
    Vertex second ;
    Vertex third ;
    Vertex fourth ;
    Vertex fifth ;
    Vertex sixth ;
    Vertex seventh ;
    Vertex eight ;
    Vertex ninth ;
    Vertex ten ;
    
}