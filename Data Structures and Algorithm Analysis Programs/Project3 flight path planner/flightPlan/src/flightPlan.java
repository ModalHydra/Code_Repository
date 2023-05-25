import java.io.*;

public class flightPlan {

public static void main(String[] args) throws IOException {

		
		String flightDataFile;
		String requestFile;
		String outputFile;
		
		
		flightDataFile = args[0];
		requestFile =  args[1];
		outputFile =  args[2];
		
		/*
		System.out.println(flightDataFile);
		System.out.println(requestFile);
		System.out.println(outputFile);
		*/
		
		File output = new File(outputFile);
		
		output.delete();
		
		output.createNewFile();
		
		
		flightDataReader flightData = new flightDataReader(flightDataFile);
		flightPathsToCalculateReader flightRequests = new flightPathsToCalculateReader(requestFile);
		
		adjacencyList graph = new adjacencyList(flightData);
		
	
		flightPlanFinder finder;
		outputFileWriter writer;
		
		
		for(int i = 0; i < flightRequests.getNumLines(); i++) {
			finder = new flightPlanFinder(graph, flightRequests, i);
			
			writer = new outputFileWriter(outputFile, finder.getPathHolder(), finder.getCostHolder(),
					finder.getTimeHolder(), flightRequests.getWeightType(i), i, flightRequests);
		
			if(i == 0) {
				System.out.println("Your flight paths are stored in "  + writer.getFileName());
			}
		}
			
	}
	
}
