/**
 * This class actually runs the program and allow us to compare the performance
 * of Insertion Sort vs Merge Sort
 * @author Annie, Jason, Kenrick, Lewis, Stephen
 *
 */
public class InsertionVersusMerge
{
	/**
	 * this values are declared constants for easy manipulation
	 * can be changed to console input later on
	 */
	private static final int MIN_ARRAY_SIZE = 1000;
	private static final int MAX_ARRAY_SIZE = 100_000;
	private static final int STEP_SIZE = 1000;
	
	/**
	 * We need to compare between insertion sort and merge sort for arrays of different types and sizes.
	 * So we generate 
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		// outer loop varies array sizes
		for(int arraySize = MIN_ARRAY_SIZE; arraySize <= MAX_ARRAY_SIZE; arraySize += STEP_SIZE)
		{
			StatisticalResults[] sortingResultsArray = new StatisticalResults[6]; // 6 combinations of sorting results
			
			for(int index = 0; index < sortingResultsArray.length; ++index)
			{
				sortingResultsArray[index] = new StatisticalResults(arraySize);
			}
			/**
			 * sortingResultsArray[0] holds the results of sorting through randomly-ordered array using insertion sort
			 * sortingResultsArray[1] holds the results of sorting through ascending array using insertion sort
			 * sortingResultsArray[2] holds the results of sorting through descending array using insertion sort
			 * 
			 * sortingResultsArray[3] holds the results of sorting through randomly-ordered array using merge sort
			 * sortingResultsArray[4] holds the results of sorting through ascending array using merge sort
			 * sortingResultsArray[5] holds the results of sorting through descending array using merge sort
			 */
			
			// to-do: place an inner loop here to get multiple instances of results to get the average for random order		
//			/int[] randomArray = InputGenerator.generateRandomArray(arraySize);
			
			int[] insertAscendArray = InputGenerator.generateAscendArray(arraySize);
			int[] insertDescendArray = InputGenerator.generateDescendArray(arraySize);
			
			int[] mergeAscendArray = InputGenerator.generateAscendArray(arraySize);
			int[] mergeDescendArray = InputGenerator.generateDescendArray(arraySize);

			Sorter.insertionSort(insertAscendArray, sortingResultsArray[1]);
			Sorter.insertionSort(insertDescendArray, sortingResultsArray[2]);
			
			Sorter.mergeSort(mergeAscendArray, 0, arraySize-1, sortingResultsArray[4]);
			Sorter.mergeSort(mergeDescendArray, 0, arraySize-1, sortingResultsArray[5]);
			
			System.out.println("Insertion sort (ascending): " + sortingResultsArray[1]);
			System.out.println("Insertion sort (descending): " + sortingResultsArray[2]);
			System.out.println();
			
			System.out.println("Merge sort (ascending): " + sortingResultsArray[4]);
			System.out.println("Merge sort (descending): " + sortingResultsArray[5]);
			System.out.println();
			
		}
	}

}
