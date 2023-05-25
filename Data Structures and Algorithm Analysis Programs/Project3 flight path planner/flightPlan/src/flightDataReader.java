import java.util.*;
import java.io.*;

public class flightDataReader {

	
	private String fileName;
	private ArrayList<String> startingCityNames = new ArrayList<String>();
	private ArrayList<String> destinationCityNames = new ArrayList<String>();
	private ArrayList<Double> costWeightArrayList = new ArrayList<Double>();
	private ArrayList<Integer> timeWeightArrayList = new ArrayList<Integer>();
	private int numberOfEdges;
	
	
	public flightDataReader(String file) throws FileNotFoundException {
		fileName = file;
		
		numberOfEdges = setNumberOfEdges(file);
		fillArrayLists(file, numberOfEdges);
	}
	
	
	public String getFileName() {
		return fileName;
	}
	
	public int getNumberOfEdges() {
		return numberOfEdges;
	}
	
	public String getStartingCityName(int index){
		return startingCityNames.get(index);
	}
	
	public ArrayList<String> getStartingCityList(){
		return startingCityNames;
	}
	
	public String getDestinationCityName(int index){
		return destinationCityNames.get(index);
	}
	
	public ArrayList<String> getDestinationCityList(){
		return destinationCityNames;
	}
	
	public double getCostWeight(int index){
		return costWeightArrayList.get(index);
	}
	
	public int getTimeWeight(int index){
		return timeWeightArrayList.get(index);
	}
	
	private int setNumberOfEdges(String fileName) throws FileNotFoundException {
		
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		
		numberOfEdges = Integer.parseInt(sc.next());
		
		sc.close();
		
		return numberOfEdges;
	}
	
	private void fillArrayLists(String fileName, int lines) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		
		String temp;
		
		sc.next();
		
		while(sc.hasNext()) {
			temp = sc.next();
			startingCityNames.add(temp.split("\\|")[0]);
			destinationCityNames.add(temp.split("\\|")[1]);
			costWeightArrayList.add(Double.parseDouble(temp.split("\\|")[2]));
			timeWeightArrayList.add(Integer.parseInt(temp.split("\\|")[3]));
			
		}
		
		sc.close();
		
	}
	
}
