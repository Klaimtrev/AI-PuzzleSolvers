package domains.arithmetic;

import framework.problem.State;
/**
 *
 * @author Diego Minaya D
 */
public class ArithmeticState implements State {
    public ArithmeticState(int N){
        content=N;
    }
    @Override
    public boolean equals(Object other){
        ArithmeticState ST = (ArithmeticState) other;
        if(this.content == ST.content){
            return true;
        }
        else{return false;}
    }
    public int getContent(){
        return content;
    }
    @Override
    public String toString(){
        String s1=Integer.toString(content);
        String s2="The value is: "+s1;
        return s2;
    }
    
    final private int content;
}
