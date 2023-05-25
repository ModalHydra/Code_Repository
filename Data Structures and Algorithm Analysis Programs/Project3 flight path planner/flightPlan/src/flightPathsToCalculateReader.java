import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class flightPathsToCalculateReader {

	private String requestsFile;
	private int numLines;
	private ArrayList<String> startCities = new ArrayList<String>();
	private ArrayList<String> destinationCities = new ArrayList<String>();
	private ArrayList<String> weightType = new ArrayList<String>();
	
	public flightPathsToCalculateReader(String file) throws FileNotFoundException {
		
		requestsFile = file;
		setNumberOfLines(requestsFile);
		
		fillArrayLists(requestsFile,numLines);
		
		
	}
	
	public String getRequestsFile() {
		return requestsFile;
	}
	
	public int getNumLines() {
		return numLines;
	}
	
	public String getStartCity(int lineIndex) {
		return startCities.get(lineIndex);
	}
	
	public String getDestinationCities(int lineIndex) {
		return destinationCities.get(lineIndex);
	}
	
	public String getWeightType(int lineIndex) {
		return weightType.get(lineIndex);
	}
	
	
private int setNumberOfLines(String fileName) throws FileNotFoundException {
		
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		
		numLines = Integer.parseInt(sc.next());
		
		sc.close();
		
		return numLines;
	}

private void fillArrayLists(String fileName, int lines) throws FileNotFoundException {
	File file = new File(fileName);
	Scanner sc = new Scanner(file);
	
	String temp;
	
	sc.next();
	
	while(sc.hasNext()) {
		temp = sc.next();
		startCities.add(temp.split("\\|")[0]);
		destinationCities.add(temp.split("\\|")[1]);
		weightType.add(temp.split("\\|")[2]);
		}
	
	sc.close();
	}

}
