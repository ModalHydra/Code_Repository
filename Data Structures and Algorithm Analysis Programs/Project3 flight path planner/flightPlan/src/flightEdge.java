
public class flightEdge {
	
	private flightNode endLocation;
	private double costWeight = 0;
	private int timeWeight;
	
	public flightEdge(flightNode end, double cost, int time) {
		endLocation = end;
		costWeight = cost;
		timeWeight = time;
	}
	
	public flightNode getEndLocation() {
		return endLocation;
	}
	
	public double getCostWeight() {
		return costWeight;
	}
	
	public int getTimeWeight() {
		return timeWeight;
	}

}
