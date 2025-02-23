package domains.farmer;

//import framework.problem.Mover;
//import framework.problem.State;
import framework.problem.State;
import framework.problem.Mover;


/**
 *
 * @author tcolburn
 */
public class FarmerMover extends Mover {
    
    public FarmerMover() {
        super.addMove(GOES_ALONE, s -> goesAlone(s));
        super.addMove(TAKES_WOLF, s -> takesWolf(s));
        super.addMove(TAKES_GOAT, s -> takesGoat(s));
        super.addMove(TAKES_CABBAGE, s -> takesCabbage(s));
    }
    
    public static final String GOES_ALONE = "Farmer Goes Alone";
    public static final String TAKES_WOLF = "Farmer Takes Wolf";
    public static final String TAKES_GOAT = "Farmer Takes Goat";
    public static final String TAKES_CABBAGE = "Farmer Takes Cabbage";
    
    /**
     * Tries to create a new FWGC state by crossing farmer alone.
     * The given state is not changed.
     * @param state the given state
     * @return the new state, or an empty optional if result is not safe
     */
    private State goesAlone(State state) {
        FarmerState s = (FarmerState) state;
	return checkSafe(new FarmerState(opposite(s.getFarmer()),
                                                  s.getWolf(),
                                                  s.getGoat(),
			                          s.getCabbage()));
    }
    
    /**
     * Tries to create a new FWGC state by crossing the farmer and the wolf.
     * The given state is not changed.
     * @param state the given state
     * @return the new state, or an empty optional if the farmer and wolf are
     * not on the same side in the given state or the result is not safe
     */
    private State takesWolf(State state) {
        FarmerState s = (FarmerState) state;
        return	s.getFarmer() != s.getWolf() ?
                null :
                checkSafe(new FarmerState(opposite(s.getFarmer()),
			                  opposite(s.getWolf()),
					  s.getGoat(),
					  s.getCabbage()));
    }

    /**
     * Tries to create a new FWGC state by crossing the farmer and the goat.
     * The given state is not changed.
     * @param state the given state
     * @return the new state, or an empty optional if the farmer and goat are
     * not on the same side in the given state or the result is not safe
     */
    private State takesGoat(State state) {
        FarmerState s = (FarmerState) state;
        return s.getFarmer() != s.getGoat() ?
	       null :
               checkSafe(new FarmerState(opposite(s.getFarmer()),
					 s.getWolf(),
					 opposite(s.getGoat()),
					 s.getCabbage()));
    }

    /**
     * Tries to create a new FWGC state by crossing the farmer and the cabbage.
     * The given state is not changed.
     * @param state the given state
     * @return the new state, or an empty optional if the farmer and cabbage are
     * not on the same side in the given state or the result is not safe
     */
    private State takesCabbage(State state) {
        FarmerState s = (FarmerState) state;
        return s.getFarmer() != s.getCabbage() ?
	       null :
               checkSafe(new FarmerState(opposite(s.getFarmer()),
					 s.getWolf(),
					 s.getGoat(),
					 opposite(s.getCabbage())));
    }
    
    /**
     * Utility method to find the opposite side of a character.
     * @param side the side whose opposite is needed
     * @return the opposite side of the given side
     */
    private static FarmerState.Side opposite(FarmerState.Side side) {
	if ( side == FarmerState.Side.EAST )
	    return FarmerState.Side.WEST;
	else
	    return FarmerState.Side.EAST;
    }
    
    /**
     * Utility method to determine whether a FWGC state is safe.
     * A state is not safe if the farmer leaves the wolf alone with the goat or
     * the goat alone with the cabbage.
     * @param state the state to be tested for safety
     * @return whether the state is safe
     */
    private static boolean isSafe(FarmerState state) {

	FarmerState.Side farmer = state.getFarmer();
	FarmerState.Side wolf = state.getWolf();
	FarmerState.Side goat = state.getGoat();
	FarmerState.Side cabbage = state.getCabbage();

	return !((goat == wolf) && (goat != farmer) ||
		 (cabbage == goat) && (cabbage != farmer));
    }
    
    /**
     * Utility method to wrap an Optional around a FarmerState.
     * @param state a FWGC state
     * @return an Optional of the state if safe, an empty Optional otherwise
     */
    private static State checkSafe(FarmerState state) {

	return isSafe(state) ? state : null;
        
    }
    
}
