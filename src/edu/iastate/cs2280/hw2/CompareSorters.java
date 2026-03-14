package edu.iastate.cs2280.hw2;

/**
 *  
 * @author Elijah Zimmerly
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.Random; 


public class CompareSorters 
{
	/**
	 * Repeatedly take integer sequences either randomly generated or read from files. 
	 * Use them as coordinates to construct points.  Scan these points with respect to their 
	 * median coordinate point four times, each time using a different sorting algorithm.  
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException
	{		 
		// Conducts multiple rounds of comparison of four sorting algorithms.  Within each round, 
		// set up scanning as follows: 
		// 
		//    a) If asked to scan random points, calls generateRandomPoints() to initialize an array 
		//       of random points. 
		// 
		//    b) Reassigns to the array scanners[] (declared below) the references to four new 
		//       PointScanner objects, which are created using four different values  
		//       of the Algorithm type:  SelectionSort, InsertionSort, MergeSort and QuickSort. 
		// 
		// 	
		Scanner scnr = new Scanner(System.in);
		PointScanner[] scanners = new PointScanner[4];
		System.out.println("keys:  1 (random integers)  2 (file input)  3 (exit)");
		int key = 0;
		int trial = 1;
		while(key != 3) {
			System.out.print("Trial " + trial + ": ");
			key = scnr.nextInt();
			
			if(key == 1) {
				System.out.println("Points from a file");
				System.out.print("File name: ");
				String fileName = scnr.next();
				for(int i = 0; i < 4; i++) {
					scanners[i] = new PointScanner(fileName, Algorithm.values()[i]);
				}
			}
			else if(key == 2) {
				System.out.print("Enter number of random points: ");
				int numPts = scnr.nextInt();
				Point[] pts = generateRandomPoints(numPts, new Random());
				for(int i = 0; i < 4; i++) {
					scanners[i] = new PointScanner(pts, Algorithm.values()[i]);
				}
			}
			else if(key == 3) {
				break;
			}
			else {
				System.out.println("Invalid input!");
			}
			
			System.out.println("\nalgorithm   size  time (ns)\n----------------------------------");
			for(PointScanner ptScnr : scanners) {
				ptScnr.scan();
				System.out.println(ptScnr.stats());
			}
			System.out.println("----------------------------------\n");
			
			trial++;
		}
		scnr.close();
		 
		
		// For each input of points, do the following. 
		// 
		//     a) Initialize the array scanners[].  
		//
		//     b) Iterate through the array scanners[], and have every scanner call the scan() 
		//        method in the PointScanner class.  
		//
		//     c) After all four scans are done for the input, print out the statistics table from
		//		  section 2.
		//
		// A sample scenario is given in Section 2 of the project description. 
		
	}
	
	
	/**
	 * This method generates a given number of random points.
	 * The coordinates of these points are pseudo-random numbers within the range 
	 * [-50,50] � [-50,50]. Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing. 
	 * 
	 * @param numPts  	number of points
	 * @param rand      Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{ 
		Point[] pts = new Point[numPts];
		for(int i = 0; i < numPts; i++) {
			int randX = rand.nextInt(101) - 50;
			int randY = rand.nextInt(101) - 50;
			pts[i] = new Point(randX, randY);
		}
		return pts;
	}
	
}
