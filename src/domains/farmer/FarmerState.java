package domains.farmer;

//import framework.problem.State;
import framework.problem.State;
import java.util.Objects;

/**
 * This class represents a state in the farmer, wolf, goat, and cabbage problem.
 * @author tcolburn
 */
//public class FarmerState implements State {
public class FarmerState implements State {
    
    public enum Side {WEST, EAST};

    public FarmerState(Side farmer, Side wolf, Side goat, Side cabbage) {
        this.farmer = farmer;
        this.wolf = wolf;
        this.goat = goat;
        this.cabbage = cabbage;
    }
    
    public FarmerState(String farmer, String wolf, String goat, String cabbage) {
        this(toSide(farmer), toSide(wolf), toSide(goat), toSide(cabbage));
    }

    public Side getFarmer() {
        return farmer;
    }

    public Side getWolf() {
        return wolf;
    }

    public Side getGoat() {
        return goat;
    }

    public Side getCabbage() {
        return cabbage;
    }
    
    @Override
    public boolean equals(Object other) {
	if (this == other) return true;
	if (other == null) return false;
	if (getClass() != other.getClass()) return false;
	FarmerState state = (FarmerState) other;
	return (this.farmer == state.farmer &&
		this.wolf == state.wolf &&
		this.goat == state.goat &&
		this.cabbage == state.cabbage);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.farmer);
        hash = 71 * hash + Objects.hashCode(this.wolf);
        hash = 71 * hash + Objects.hashCode(this.goat);
        hash = 71 * hash + Objects.hashCode(this.cabbage);
        return hash;
    }
    
    @Override
    public String toString() {

	StringBuilder buf = new StringBuilder();

	String start = "   |  |   \n";
	String fWest = " F |  |   \n";
	String fEast = "   |  | F \n";
	String wWest = " W |  |   \n";
	String wEast = "   |  | W \n";
	String gWest = " G |  |   \n";
	String gEast = "   |  | G \n";
	String cWest = " C |  |   \n";
	String cEast = "   |  | C \n";
	String end   = "   |  |   ";

	buf.append(start);
        
        buf.append(farmer  == Side.WEST ? fWest : fEast);
        buf.append(wolf    == Side.WEST ? wWest : wEast);
        buf.append(goat    == Side.WEST ? gWest : gEast);
        buf.append(cabbage == Side.WEST ? cWest : cEast);

	buf.append(end);

	return buf.toString();
    }

    private static Side toSide(String s) {

	if ( s.equalsIgnoreCase("west") )
	    return Side.WEST;
	else if ( s.equalsIgnoreCase("east") )
	    return Side.EAST;
        else {
            throw new RuntimeException("Bad side: " + s);
        }

    }
    
    private final Side farmer;
    private final Side wolf;
    private final Side goat;
    private final Side cabbage;
    
}
