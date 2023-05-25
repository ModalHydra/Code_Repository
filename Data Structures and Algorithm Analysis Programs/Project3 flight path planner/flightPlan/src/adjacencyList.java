import java.util.*;

public class adjacencyList {
	
	private LinkedList<flightNode> nodeList = new LinkedList<flightNode>();
	
	public adjacencyList(flightDataReader data) {
		// use the built in linked list class of java to make a linked list of linked lists, with flightNodes
		
		fillNodeLinkedList(data.getStartingCityList(), data.getDestinationCityList());
		
		fillNodeEdges(data.getStartingCityList(), data.getDestinationCityList(), data);
		
		
	}
	
	public LinkedList<flightNode> getNodeList() {
		return nodeList;
	}
	
	private void fillNodeLinkedList(ArrayList<String> startCities, ArrayList<String> endCities) {
		int arraySize = startCities.size();
		
		flightNode temp = null;
		
		for(int i = 0; i < arraySize; i++) {
			if(!(inList(startCities.get(i)))) {
				temp = new flightNode(startCities.get(i));
				nodeList.add(temp);
			}
		}
		
		for(int i = 0; i < arraySize; i++) {
			if(!(inList(endCities.get(i)))) {
				temp = new flightNode(endCities.get(i));
				nodeList.add(temp);
			}
		}
		
	}
	
	private void fillNodeEdges(ArrayList<String> startCities, ArrayList<String> endCities, flightDataReader data) {
		int numNodes = nodeList.size();
		int numEdges = startCities.size();
		
		for(int i = 0; i < numNodes; i++) {
			flightNode currentNode = nodeList.get(i);
			
			for(int j = 0; j < numEdges; j++) {
				if(currentNode.getCityName().equals(startCities.get(j))) {
					flightNode tempNode = new flightNode(endCities.get(j));
					flightEdge tempEdge = new flightEdge(tempNode, data.getCostWeight(j), data.getTimeWeight(j));
					currentNode.addEdge(tempEdge);
				}
			}
			
			for(int j = 0; j < numEdges; j++) {
				if(currentNode.getCityName().equals(endCities.get(j))) {
					flightNode tempNode = new flightNode(startCities.get(j));
					flightEdge tempEdge = new flightEdge(tempNode, data.getCostWeight(j), data.getTimeWeight(j));
					currentNode.addEdge(tempEdge);
				}
			}
		}
		
	}
	
	private boolean inList(String city) {
		
		boolean valid = false;
		
		
		
		int nodeListSize = nodeList.size();
		
		for(int i = 0; i < nodeListSize; i++) {
			
			if(nodeList.get(i).getCityName().equals(city)) {
	
				valid = true;
			}
		}
		
		return valid;
	}

}
