/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.arithmetic;
import domains.arithmetic.ArithmeticState;
import framework.problem.Mover;
import framework.problem.State;

/**
 *
 * @author Diego Minaya D
 */
public class ArithmeticMover extends Mover {
    
    public static final String Add= "Add 3";
    public static final String Sub= "Subtract 5";
    public static final String Mul= "Multiply by 2";
    public static final String Div= "Divide by 2";
    
    public ArithmeticMover(){
        super.addMove(Add, s -> tryAdd(s));
        super.addMove(Sub, s -> trySub(s));
        super.addMove(Mul, s -> tryMul(s));
        super.addMove(Div, s -> tryDiv(s));
    }
    
    private State tryAdd(State s){
        ArithmeticState copy= (ArithmeticState) s;
        return new ArithmeticState(3+(copy.getContent()));
    }
    private State trySub(State s){
        ArithmeticState copy= (ArithmeticState) s;
        return new ArithmeticState((copy.getContent())-5);
    }
    private State tryMul(State s){
        ArithmeticState copy= (ArithmeticState) s;
        return new ArithmeticState((copy.getContent())*2);
    }
    private State tryDiv(State s){
        ArithmeticState copy= (ArithmeticState) s;
        return new ArithmeticState((copy.getContent())/2);
    }
    
    
}
