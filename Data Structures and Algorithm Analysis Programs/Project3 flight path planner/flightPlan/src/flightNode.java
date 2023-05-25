import java.util.*;

public class flightNode {

	private String cityName;
	private boolean visited;
	private int currentTime = 0;
	private double currentCost = 0;
	private ArrayList<String> currentPath = new ArrayList<String>();
	private LinkedList<flightEdge> adjacentCities = new LinkedList<flightEdge>();
	
	public flightNode(String city) {
		cityName = city;
		visited = false;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public int getCurrentTime() {
		return currentTime; 
	}
	
	public double getCurrentCost() {
		return currentCost;
	}
	
	public ArrayList<String> getCurrentPath(){
		return currentPath;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
	public LinkedList<flightEdge> getEdgeLinkedList(){
		return adjacentCities;
	}
	
	public flightEdge getEdge(String name) {
		
		int index = -1; 
		for(int i = 0; i < adjacentCities.size(); i++) {
			if(name.equals(adjacentCities.get(i).getEndLocation().getCityName())) {
				index = i;
			}
		}
		
		return adjacentCities.get(index);
	}
	
	public boolean hasEdge(String name) {
		boolean valid = false;
		
		for(int i = 0; i < adjacentCities.size(); i++) {
			if(name.equals(adjacentCities.get(i).getEndLocation().getCityName())) {
				valid = true;
			}
		}
		
		return valid;
	}
	
	public void setVisited(boolean visit) {
		
		visited = visit;
	}
	
	public void setCurrentCost(double d) {
		currentCost = d;
	}
	
	public void setCurrentTime(int t) {
		currentTime = t;
	}
	
	
	public void addEdge(flightEdge e) {
		adjacentCities.add(e);
	}
	
}
