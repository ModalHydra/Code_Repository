import java.util.*;

public class flightPlanFinder {
	
	private adjacencyList graph;
	private ArrayList<String> cityVisitedList = new ArrayList<String>();
	private ArrayList<String> pathHolder = new ArrayList<String>();
	private ArrayList<Double> costHolder = new ArrayList<Double>();
	private ArrayList<Integer> timeHolder = new ArrayList<Integer>();
	private Stack<flightNode> nodeStack = new Stack<flightNode>();
	private flightPathsToCalculateReader travelPairs;
	
	public flightPlanFinder(adjacencyList g, flightPathsToCalculateReader t, int requestNum) {
		
		graph = g;
		travelPairs = t;
		
		int index = listSearch(travelPairs.getStartCity(requestNum));
		
		flightNode start = graph.getNodeList().get(index);
		
		index = listSearch(travelPairs.getDestinationCities(requestNum));
		
		flightNode end = graph.getNodeList().get(index);
		
		//System.out.println("recursive backtracking");
		findAllPaths(start, end);
		//System.out.println();
		
		//System.out.println("Iterative backtracking");
		DFS(start, end);
		//System.out.println();
		
	}

	
	
	// perform s DFS on the graph and make a list of all paths to the destination
	// keep track of the cost and time weights for each path
	// sort the paths by the desired weight type after finding all paths
	// output up to the shortest three paths
	// instead of the visited bool have an array holding the cities that have been visited
	// the program will get the start city, push it onto the stack, get its edge, add edge weights to path weights
	// find the edge city name, search the graphs linkedList for that name, recursivly call with the node gotten
	// from the linked list until the destination string is found 
	
	
	public ArrayList<String> getPathHolder(){
		return pathHolder;
	}
	
	public ArrayList<Double> getCostHolder(){
		return costHolder;
	}
	
	public ArrayList<Integer> getTimeHolder(){
		return timeHolder;
	}
	
	private void findAllPaths(flightNode city, flightNode destination)
    {
       
        ArrayList<String> pathList = new ArrayList<String>();
        ArrayList<Double> costList = new ArrayList<Double>();
        ArrayList<Integer> timeList = new ArrayList<Integer>();
  
        pathList.add(city.getCityName());
  
        findAllPathsUtil(city, destination, pathList, costList, timeList);
    }
	

	private void findAllPathsUtil(flightNode city, flightNode destination,
			List<String> localPathList, List<Double> localCostList, List<Integer> localTimeList)
	{
		
		if (city.getCityName().equals(destination.getCityName())) {
			
			int totalTime = 0;
			double totalCost = 0;
			
			for(Double i : localCostList) {
				totalCost += i;
			}
			
			for(Integer i : localTimeList) {
				totalTime += i;
			}
			
			String formatedPath = format(localPathList, totalCost, totalTime);
			
			//System.out.println(formatedPath);
			
			pathHolder.add(formatedPath);
			costHolder.add(totalCost);
			timeHolder.add(totalTime);
			
			
			return;
		}

		cityVisitedList.add(city.getCityName());

		int index = listSearch(city.getCityName());
		int counter = 0;
		for (flightEdge i : graph.getNodeList().get(index).getEdgeLinkedList()) {
			if (!(cityVisitedList.contains(city.getEdgeLinkedList().get(counter).getEndLocation().getCityName()))) {
				
				localPathList.add(i.getEndLocation().getCityName());
				localCostList.add(i.getCostWeight());
				localTimeList.add(i.getTimeWeight());
			
				int index2 = listSearch(i.getEndLocation().getCityName());
			
				flightNode temp = graph.getNodeList().get(index2);
				findAllPathsUtil(temp, destination, localPathList, localCostList, localTimeList);
				
				localPathList.remove(i.getEndLocation().getCityName());
				
				if(localCostList.size() > 0) {
					int k = localCostList.size();
				localCostList.remove(k - 1);
				localTimeList.remove(k - 1);
				}
				
			}
			counter++;
		}

		cityVisitedList.remove(city.getCityName());
	}
	
public void DFS(flightNode start, flightNode end) {
	
				
		for(int i =0; i < graph.getNodeList().size(); i++) {
			
			flightNode temp = graph.getNodeList().get(i);
			temp.setVisited(false);
			temp.getCurrentPath().clear();
			temp.setCurrentCost(0);
			temp.setCurrentTime(0);
		}
		
		nodeStack.push(start);
		
		
		
		while(!(nodeStack.isEmpty())){
			flightNode currentCity = nodeStack.peek();
			nodeStack.pop();
			
			
			
			currentCity.getCurrentPath().add(currentCity.getCityName());
			
			currentCity.setVisited(true);
			
			for(int i = 0; i < currentCity.getEdgeLinkedList().size(); i++) {
				flightNode edgeCity;
				int index = listSearch(currentCity.getEdgeLinkedList().get(i).getEndLocation().getCityName());
				edgeCity =  graph.getNodeList().get(index);
				
				if(edgeCity.getVisited() == false) {
					nodeStack.push(edgeCity);
					edgeCity.setVisited(true);
					edgeCity.setCurrentCost(currentCity.getEdge(edgeCity.getCityName()).getCostWeight() + currentCity.getCurrentCost());
					edgeCity.setCurrentTime(currentCity.getEdge(edgeCity.getCityName()).getTimeWeight() + currentCity.getCurrentTime());
					for(int j = 0; j < currentCity.getCurrentPath().size(); j++) {
						edgeCity.getCurrentPath().add(currentCity.getCurrentPath().get(j));
					}
					
				}
				else {
					edgeCity.getCurrentPath().remove(edgeCity.getCityName());
					
				}
				
				if (edgeCity.getCityName().equals(end.getCityName())) {
					
					int totalTime = 0;
					double totalCost = 0;
					
					totalTime = currentCity.getCurrentTime() + currentCity.getEdge(edgeCity.getCityName()).getTimeWeight();
					totalCost = currentCity.getCurrentCost() + currentCity.getEdge(edgeCity.getCityName()).getCostWeight();
					
					String formatedPath = "";
					
					//formatedPath += start.getCityName() + " ";
					
					int pathSize = currentCity.getCurrentPath().size();
					
					for(int j = 0; j < pathSize; j++) {
						formatedPath += currentCity.getCurrentPath().get(j) + " ";
					}
					
					formatedPath += edgeCity.getCityName() + " ";
					
					formatedPath += totalTime + " " + totalCost;
					
					//System.out.println(formatedPath);
					
					
				}
				
				//currentCity.setVisited(false);
				
			}
			
			//currentCity.removeCurrentPath(currentCity.getCityName());
		}
	}
	
	
	private int listSearch(String city) {
		
		int index = -1;
		
		for(int i = 0; i < graph.getNodeList().size(); i++) {
			if(city.equals(graph.getNodeList().get(i).getCityName())) {
				index = i;
			}
		}
		
		return index;
	}
	
	private String format(List<String> path, double cost, int time) {
		
		String formattedPath = "";
		
		for(String i : path) {
			if(i != path.get(path.size() - 1)) {
				formattedPath += (i + " -> ");
			}
			else {
				formattedPath += (i + ". ");
			}
		}
		
		formattedPath += ("Time: " + time + " ");
		formattedPath += ("Cost: " + String.format("%.2f", cost));
		
		return formattedPath;
	}
}
