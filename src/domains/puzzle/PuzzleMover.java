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
import domains.puzzle.PuzzleState.Location;
import framework.problem.Mover;
import framework.problem.State;
public class PuzzleMover extends Mover {
        public static final String ST1 = "SLIDE TILE 1";
        public static final String ST2 = "SLIDE TILE 2";
        public static final String ST3 = "SLIDE TILE 3";
        public static final String ST4 = "SLIDE TILE 4";
        public static final String ST5 = "SLIDE TILE 5";
        public static final String ST6 = "SLIDE TILE 6";
        public static final String ST7 = "SLIDE TILE 7";
        public static final String ST8 = "SLIDE TILE 8";
    public PuzzleMover(){
        
         //super.addMove(goesAlone, s -> trygoesAlone(s));
        super.addMove(ST1,  s -> tryslideTile1(s));
        super.addMove(ST2, s -> tryslideTile2(s));
        super.addMove(ST3, s -> tryslideTile3(s));
        super.addMove(ST4, s -> tryslideTile4(s));
        super.addMove(ST5, s -> tryslideTile5(s));
        super.addMove(ST6, s -> tryslideTile6(s));
        super.addMove(ST7, s -> tryslideTile7(s));
        super.addMove(ST8, s -> tryslideTile8(s));
        }
    private State tryslideTile1(State s) {
        //PuzzleState copy = s.getTiles();
        PuzzleState copyc= (PuzzleState) s;
        PuzzleState copy = new PuzzleState(
                            new int[][]{new int[]{copyc.getTile(0,0), copyc.getTile(0,1), copyc.getTile(0,2)}, 
                            new int[]{copyc.getTile(1,0),copyc.getTile(1,1), copyc.getTile(1,2)}, 
                            new int[]{copyc.getTile(2,0), copyc.getTile(2,1), copyc.getTile(2,2)}});
        
        Location loc1 = copy.getLocation(1);
        Location loc0 = copy.getLocation(0);
        if (loc1.getColumn()==loc0.getColumn()){
            if ((loc1.getRow()+1==loc0.getRow())||(loc1.getRow()-1==loc0.getRow())){
                return new PuzzleState(copy,loc1,loc0);
            }
        }
        else if (loc1.getRow()==loc0.getRow()){
            if ((loc1.getColumn()+1==loc0.getColumn())||(loc1.getColumn()-1==loc0.getColumn())){
                return new PuzzleState(copy,loc1,loc0);
        }
    }
    return null;
    }

    private State tryslideTile2(State s) {
        
        PuzzleState copyc= (PuzzleState) s;
        PuzzleState copy = new PuzzleState(
                            new int[][]{new int[]{copyc.getTile(0,0), copyc.getTile(0,1), copyc.getTile(0,2)}, 
                            new int[]{copyc.getTile(1,0),copyc.getTile(1,1), copyc.getTile(1,2)}, 
                            new int[]{copyc.getTile(2,0), copyc.getTile(2,1), copyc.getTile(2,2)}});
        
        Location loc1 = copy.getLocation(2);
        Location loc0 = copy.getLocation(0);
        if (loc1.getColumn()==loc0.getColumn()){
            if ((loc1.getRow()+1==loc0.getRow())||(loc1.getRow()-1==loc0.getRow())){
                return new PuzzleState(copy,loc1,loc0);
            }
        }
        else if (loc1.getRow()==loc0.getRow()){
            if ((loc1.getColumn()+1==loc0.getColumn())||(loc1.getColumn()-1==loc0.getColumn())){
                return new PuzzleState(copy,loc1,loc0);
        }
    }
    return null;
    }
    private State tryslideTile3(State s) {
        PuzzleState copyc= (PuzzleState) s;
        PuzzleState copy = new PuzzleState(
                            new int[][]{new int[]{copyc.getTile(0,0), copyc.getTile(0,1), copyc.getTile(0,2)}, 
                            new int[]{copyc.getTile(1,0),copyc.getTile(1,1), copyc.getTile(1,2)}, 
                            new int[]{copyc.getTile(2,0), copyc.getTile(2,1), copyc.getTile(2,2)}});
        Location loc1 = copy.getLocation(3);
        Location loc0 = copy.getLocation(0);
        if (loc1.getColumn()==loc0.getColumn()){
            if ((loc1.getRow()+1==loc0.getRow())||(loc1.getRow()-1==loc0.getRow())){
                return new PuzzleState(copy,loc1,loc0);
            }
        }
        else if (loc1.getRow()==loc0.getRow()){
            if ((loc1.getColumn()+1==loc0.getColumn())||(loc1.getColumn()-1==loc0.getColumn())){
                return new PuzzleState(copy,loc1,loc0);
        }
    }
        return null;
}
    private State tryslideTile4(State s) {
        PuzzleState copyc= (PuzzleState) s;
        PuzzleState copy = new PuzzleState(
                            new int[][]{new int[]{copyc.getTile(0,0), copyc.getTile(0,1), copyc.getTile(0,2)}, 
                            new int[]{copyc.getTile(1,0),copyc.getTile(1,1), copyc.getTile(1,2)}, 
                            new int[]{copyc.getTile(2,0), copyc.getTile(2,1), copyc.getTile(2,2)}});
        Location loc1 = copy.getLocation(4);
        Location loc0 = copy.getLocation(0);
        if (loc1.getColumn()==loc0.getColumn()){
            if ((loc1.getRow()+1==loc0.getRow())||(loc1.getRow()-1==loc0.getRow())){
                return new PuzzleState(copy,loc1,loc0);
            }
        }
        else if (loc1.getRow()==loc0.getRow()){
            if ((loc1.getColumn()+1==loc0.getColumn())||(loc1.getColumn()-1==loc0.getColumn())){
                return new PuzzleState(copy,loc1,loc0);
            }
        }
        return null;
    }
    private State tryslideTile5(State s) {
        PuzzleState copyc= (PuzzleState) s;
        PuzzleState copy = new PuzzleState(
                            new int[][]{new int[]{copyc.getTile(0,0), copyc.getTile(0,1), copyc.getTile(0,2)}, 
                            new int[]{copyc.getTile(1,0),copyc.getTile(1,1), copyc.getTile(1,2)}, 
                            new int[]{copyc.getTile(2,0), copyc.getTile(2,1), copyc.getTile(2,2)}});
        Location loc1 = copy.getLocation(5);
        Location loc0 = copy.getLocation(0);
        if (loc1.getColumn()==loc0.getColumn()){
            if ((loc1.getRow()+1==loc0.getRow())||(loc1.getRow()-1==loc0.getRow())){
                return new PuzzleState(copy,loc1,loc0);
            }
        }
        else if (loc1.getRow()==loc0.getRow()){
            if ((loc1.getColumn()+1==loc0.getColumn())||(loc1.getColumn()-1==loc0.getColumn())){
                return new PuzzleState(copy,loc1,loc0);
        }
    }
        return null;
    }
    private State tryslideTile6(State s) {
        PuzzleState copyc= (PuzzleState) s;
        PuzzleState copy = new PuzzleState(
                            new int[][]{new int[]{copyc.getTile(0,0), copyc.getTile(0,1), copyc.getTile(0,2)}, 
                            new int[]{copyc.getTile(1,0),copyc.getTile(1,1), copyc.getTile(1,2)}, 
                            new int[]{copyc.getTile(2,0), copyc.getTile(2,1), copyc.getTile(2,2)}});
        Location loc1 = copy.getLocation(6);
        Location loc0 = copy.getLocation(0);
        if (loc1.getColumn()==loc0.getColumn()){
            if ((loc1.getRow()+1==loc0.getRow())||(loc1.getRow()-1==loc0.getRow())){
                return new PuzzleState(copy,loc1,loc0);
            }
        }
        else if (loc1.getRow()==loc0.getRow()){
            if ((loc1.getColumn()+1==loc0.getColumn())||(loc1.getColumn()-1==loc0.getColumn())){
                return new PuzzleState(copy,loc1,loc0);
        }
    }
        return null;
    }
    private State tryslideTile7(State s) {
        PuzzleState copyc= (PuzzleState) s;
        PuzzleState copy = new PuzzleState(
                            new int[][]{new int[]{copyc.getTile(0,0), copyc.getTile(0,1), copyc.getTile(0,2)}, 
                            new int[]{copyc.getTile(1,0),copyc.getTile(1,1), copyc.getTile(1,2)}, 
                            new int[]{copyc.getTile(2,0), copyc.getTile(2,1), copyc.getTile(2,2)}});
        Location loc1 = copy.getLocation(7);
        Location loc0 = copy.getLocation(0);
        if (loc1.getColumn()==loc0.getColumn()){
            if ((loc1.getRow()+1==loc0.getRow())||(loc1.getRow()-1==loc0.getRow())){
                return new PuzzleState(copy,loc1,loc0);
            }
        }
        else if (loc1.getRow()==loc0.getRow()){
            if ((loc1.getColumn()+1==loc0.getColumn())||(loc1.getColumn()-1==loc0.getColumn())){
                return new PuzzleState(copy,loc1,loc0);
        }
    }
        return null;
    }
    private State tryslideTile8(State s) {
        PuzzleState copyc= (PuzzleState) s;
        PuzzleState copy = new PuzzleState(
                            new int[][]{new int[]{copyc.getTile(0,0), copyc.getTile(0,1), copyc.getTile(0,2)}, 
                            new int[]{copyc.getTile(1,0),copyc.getTile(1,1), copyc.getTile(1,2)}, 
                            new int[]{copyc.getTile(2,0), copyc.getTile(2,1), copyc.getTile(2,2)}});
        Location loc1 = copy.getLocation(8);
        Location loc0 = copy.getLocation(0);
        if (loc1.getColumn()==loc0.getColumn()){
            if ((loc1.getRow()+1==loc0.getRow())||(loc1.getRow()-1==loc0.getRow())){
                return new PuzzleState(copy,loc1,loc0);
            }
        }
        else if (loc1.getRow()==loc0.getRow()){
            if ((loc1.getColumn()+1==loc0.getColumn())||(loc1.getColumn()-1==loc0.getColumn())){
                return new PuzzleState(copy,loc1,loc0);
        }
    }
        return null;
    }
    
    <T> T[][] deepCopy(T[][] matrix) {
    return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
}
    
}
