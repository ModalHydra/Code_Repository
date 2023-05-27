//File Name: algorithm_efficiency.java
//File Author: Gabriel Bentley
//Date: October 13th, 2020
//Editor: Eclipse IDE
/*Program Purpose: The purpose of the algorithm_efficiency is to
 * run a given array of length 10, 50, 100, 1000, 5000, or 10000 containing
 * positive integer numbers through 4 different sorting methods
 * Quick Sort, Heap Sort, Radix Sort, and Bubble Sort to find their
 * sorting time.
 */
import java.io.*;
import java.util.*;


public class algorithm_efficiency {
	
	
	// The printArray method will take in an array of integers and the array
	// size and print out the contents of the array
	// the printArray method was used during testing to see if the sorting methods
	// were working as intended
	static void printArray(int[] array, int a)
	{
		System.out.print("{");
		
		for(int i = 0; i < a; i ++)
		{
			System.out.print(array[i]+" ");
		}
		
		System.out.println("}");
	}
	
	// The tempFill method will take in two array of integers and
	// their array size. the method will copy the contents of the second array
	// to the first array
	static void tempFill(int [] temp, int[] array, int a) {
		for(int i = 0; i < a; i++)
		{
			temp[i] = array[i];
		}
	}
	
	// The sortingTime method will take in an integer array and the array size
	// The array will call all of the sorting methods with copies of the given 
	// array, and output the array results to the console
	static void sortingTime(int a, int[] array)
	{
		int[] tempArray = new int[a];
		
		// get array copy
		tempFill(tempArray, array, a);
		
		// call quicksort method
		System.out.println("The sorting time of an array with "+ a + " elements"
				+ " for quickSort was\n" + quickSort(tempArray, 0, a -1) + " milliseconds");
		
		// get array copy
		tempFill(tempArray, array, a);
		
		// call heapsort method
		System.out.println("The sorting time of an array with "+ a + " elements"
				+ " for heapSort was\n" + heapSort(tempArray) + " milliseconds");
		
		// get array copy
		tempFill(tempArray, array, a);
		
		// call radixSort method
		System.out.println("The sorting time of an array with "+ a + " elements"
				+ " for radixSort was\n" + radixSort(tempArray) + " milliseconds");
		
		// get array copy
		tempFill(tempArray, array, a);
		
		// call bubbleSort method
		System.out.println("The sorting time of an array with "+ a + " elements"
				+ " for bubbleSort was\n" + bubbleSort(tempArray) + " milliseconds");
		
		
		System.out.println();
		
	}
	
	//quickSort will take in an array, and two integers
	//quickSort will return a double of the time taken to sort
	//the array in milliseconds.
	static double quickSort(int[] array, int first, int last)
	{
		// start timing the method
		long start = System.nanoTime();
		
		// if the last integer is greater then the first integer
		if(last > first) {
			
			// call the partition method
			int pivotIndex = partition(array, first, last);
			
			// split the array into two and call quickSort recursivly with both
			// halves of the array
			quickSort(array, first, pivotIndex -1);
			quickSort(array, pivotIndex + 1, last);
		}
		
		// stop timing the method
		long stop = System.nanoTime();
		return (stop-start) * Math.pow(10, -6);
	}
	
	//partition will take in an integer array and two integers
	//partition will return the pivot space in the array for the
	//quickSort method to use
	static int partition(int[] array, int first, int last)
	{
		int pivot = array[first]; // Choose the first element as the pivot
		int low = first +1; // index for forward search
		int high = last; // index for backward search
		
		// while the high value is greater then the low value
		while (high > low) {
			
			// find the new low and high values
			while (low <= high && array[low] <= pivot) { 
				low++;
			}
			while (low <= high && array[high] > pivot) {
				high--;
			}
			
			// swap if high is greater then low
			if(high > low) {
				int temp = array[high];
				array[high] = array[low];
				array[low] = temp;
			}
			
		}
		
		while (high > first && array[high] >= pivot) {
			high--;
		}
		
		// if pivot is greater then the element in array high
		// make array first equal array high and make array high 
		// equal the pivot element value
		if(pivot > array[high]) {
			array[first] = array[high];
			array[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}
	
	// heapSort will take in an integer array and return
	// a double of the time taken to sort the array in milliseconds
	static double heapSort(int[] array)
	{
		// get array length
		int n = array.length;
		
		// start time for method to finish
		long start = System.nanoTime();
		  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
        	// call the heapify method
            heapify(array, n, i); 
        }
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = array[0]; 
            array[0] = array[i]; 
            array[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(array, i, 0); 
        } 
        
        // stop timing the method
        long stop = System.nanoTime();
		
		return (stop-start) * Math.pow(10, -6);
	}
	
	// the heapify method will take in an integer array and
	// two integer variables as argument and returns nothing
	// heapify will make sure that the current heap is sorted 
	// correctly
	static void heapify(int array[], int n, int i) 
    { 
        int largest = i;  // Initialize largest as root 
        int l = 2*i + 1;  // left = 2*i + 1 
        int r = 2*i + 2;  // right = 2*i + 2 
          
        // If left child is larger than root 
        if (l < n && array[l] > array[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && array[r] > array[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = array[i]; 
            array[i] = array[largest]; 
            array[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(array, n, largest); 
        } 
        
    } 
	
	// radixSort method will take in an integer array as an 
	// argument and return the time taken to sort the array 
	// as a double
	static double radixSort(int[] array)
	{
		int max = array[0];
		int l = array.length;
		int [] radix = new int[10]; // bucket counter
		int [] holder = new int [l];
		long start = System.nanoTime(); // start time
		
		// find the maximum value in the array
		for (int i = 1; i < l; i++)
		{
			if(max < array[i])
			{
				max = array[i];
			}
		}
		
		// sort the array by values 9-0 as long as max divided by i
		// is greater than zero
		for(int i = 1; max/i > 0; i *= 10)
		{
			// reset the counter array for the buckets
			for(int k = 0; k < 10; k++)
			{
				radix[k] = 0;
			}
			
			// get the amount of values in each bucket
			for(int k = 0; k < l; k++)
			{
				radix[(array[k] / i) % 10]++;
			}
			
			// move the values
			for(int k = 1; k < 10; k++)
			{
				radix[k] += radix[k-1];
			}
			
			// sort the holder using the radix counter values
			for(int k = l - 1; k >=0; k--)
			{

		        holder[radix[(array[k] / i) % 10] - 1] = array[k];
		        radix[(array[k] / i) % 10]--;
			}
			
			// give the array the sorted values
			for(int k = 0; k < l; k++)
			{
				array[k] = holder[k];
			}
		}
				
		// stop timing the method
		long stop = System.nanoTime();
		
		return (stop-start) * Math.pow(10, -6);
	}
	
	// bubbleSort method will take in an integer array as an argument
	// and will return the time taken to sort the array as a double
	static double bubbleSort(int[] array)
	{
		// start timing the array
		long start = System.nanoTime();
		int temp;
		int l = array.length;
		
		// loop through the array taking the largest value to the 
		// largest value to the end of it
		for(int k = 0; k < l-1; k++)
		{
			for(int i = 0; i < l-1-k; i++)
			{
				// if the previous element is greater 
				// swap the elements
				if(array[i] > array[i+1])
				{
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
				
			}
			
		}
		
		// stop timing the method
		long finish = System.nanoTime();
		
		return (finish-start)*Math.pow(10, -6);
	}
	
	// the fillArray method will take an integer array, the array size, and
	// a string for a text file as arguments and will return the filled array
	static int[] fillArray(int[] array, int arraySize, String textFile)
	{
		Scanner scanner;
		// open the .txt file and read the integers stored in it
		try {
			scanner = new Scanner(new File(textFile));
			for(int i = 0; i < arraySize; i++)
			{
				array[i] = scanner.nextInt();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return array;
	}

	// the main method will create the arrays to hold integers
	// prompt the user for the text file with the array values
	// and ask for the size of the array to be sorted
	// then using a switch statement the fillArray and sortingArray
	// methods will be called
	public static void main(String[] args) {
		
		int[] first = new int[10];
		int[] second = new int[50];
		int[] third = new int [100];
		int[] fourth = new int[1000];
		int[] fifth = new int [5000];
		int[] sixth = new int [10000];
		
		int size;
		String inputFile;
		
		Scanner input = new Scanner(System.in);
		
		// prompt for and read in the text file
		System.out.println("Please enter the text file you wish to read array"
				+ " elements from from");
		inputFile = input.next();
			
		// prompt for and read in the array size
		System.out.println("Please enter the size of the array you wish to"
				+ " be sorted");
		size = input.nextInt();
		
		// call the fillArray and sortingTime with the appropriate values
		switch(size)
		{
			case 10:
				fillArray(first, 10, inputFile);
				sortingTime(10, first);
				break;
			case 50:
				fillArray(second, 50, inputFile);
				sortingTime(50, second);
				break;
			case 100:
				fillArray(third, 100, inputFile);
				sortingTime(100, third);
				break;
			case 1000:
				fillArray(fourth, 1000, inputFile);
				sortingTime(1000, fourth);
				break;
			case 5000:
				fillArray(fifth, 5000, inputFile);
				sortingTime(5000, fifth);
				break;
			case 10000:
				fillArray(sixth, 10000, inputFile);
				sortingTime(10000, sixth);
				break;
			default:
				System.out.println("the value you entered was not valid");
				break;
		}

	}

}
