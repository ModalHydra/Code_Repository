import java.util.ArrayList;
import java.io.*;

public class outputFileWriter {
	
	private String fileName;
	private int requestNum;
	private ArrayList<String> paths;
	private ArrayList<Integer> times;
	private ArrayList<Double> costs;
	private String weightPriority;
	private flightPathsToCalculateReader pair;
	
	public outputFileWriter(String f, ArrayList<String> p, ArrayList<Double> c,
			ArrayList<Integer> t, String w, int r, flightPathsToCalculateReader trip) throws IOException {
		
		fileName = f;
		paths = p;
		times = t;
		costs = c;
		weightPriority = w;
		requestNum = r;
		pair = trip;
		
		sortPaths();
		
		
	}
	
	public String getFileName() {
		return fileName;
	}

	private void sortPaths() throws IOException {
		
		int index;
		int numPaths = paths.size();
		String output;
		
		FileWriter writer = new FileWriter(fileName, true);
		
		writer.flush();
		
		if(weightPriority.equals("T")) {
			output = "Flight " + (requestNum + 1) + ": " + pair.getStartCity(requestNum)
				+ ", " + pair.getDestinationCities(requestNum) + " (Time)\n";
			
			writer.write(output);
		}
		else {
			output = "Flight " + (requestNum + 1) + ": " + pair.getStartCity(requestNum)
			+ ", " + pair.getDestinationCities(requestNum) + " (Cost)\n";
			writer.write(output);
		}
		
		for(int i = 0; i < numPaths; i++) {
		
			index = findShortestWeightIndex();
		
			output = "Path " + (i + 1) + ": " + paths.get(index) + "\n";
			
			writer.write(output);
		
			
			paths.remove(index);
			costs.remove(index);
			times.remove(index);
			
			if(i == 2) {
				i = numPaths;
			}
		}
		
		writer.write("\n");
		
		writer.close();
		
	}
	
	private int findShortestWeightIndex() {
		
		int index = 0;
		double min = 0;
		
		if(weightPriority.equals("C")) {
			min = costs.get(0);
			for(int i = 0; i < costs.size(); i++) {
				if(costs.get(i) < min) {
					min = costs.get(i);
					index = i;
				}
			}
		}
		else {
			min = times.get(0);
			for(int i = 0; i < times.size(); i++) {
				if(times.get(i) < min) {
					min = times.get(i);
					index = i;
				}
			}
		}
		
		
		return index;
	}
}
