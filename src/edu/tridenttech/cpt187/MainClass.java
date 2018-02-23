//FILE:	MainClass.java
//PROG:	Tammy Castro
//PURP: implementation of two search algorithms for searching arrays
package edu.tridenttech.cpt187;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import java.io.File;

public class MainClass {
	
	public static void main(String[] args) throws IOException {
		EmployeePayData data = new EmployeePayData();
		
	      
		Scanner input = new Scanner (System.in);
		
		int empNum = 0;
		double numHours = 0;
		double pay = 0.0;
		
		int searches = 0;
		int foundIds =0;
		int notFoundIds = 0;
		
		data.loadArray();
		data.bubbleSort();
		
		System.out.println("Enter ID number to search for or -1 to quit: ");
		empNum = input.nextInt();
			
		int binSearch = 0;		
		int binFail=0;
		double payRate = data.getOnePayRate(empNum);
		PayrollManager pm = new PayrollManager("payrollProcessed.dat");
		
		while(empNum >= 0)
		{	
			
			if(data.binSearch(empNum) != -1)
			{
					
					System.out.println("Binary search found employee " + empNum + " at record "+ data.binSearch(empNum));
					System.out.println("and the pay rate is $"+ data.getOnePayRate(empNum));
					System.out.println();
					binSearch++;//Count the number of successful searches
			}
			else{
					System.out.println("Binary search did not find ID number " + empNum); 
					binFail++;//Count the number of failed searches
			}
			System.out.println("Enter number of hours worked by employee:"); 
			numHours = input.nextFloat(); 
			payRate = data.getOnePayRate(empNum);
			
			pay = payRate * numHours;
			
			//Save one record 
			pm.saveOneRecord(empNum, payRate, numHours, pay);
			System.out.printf("%6s %8s %10s %15.2f%n",empNum,payRate,numHours,pay);
			searches++;
			
			System.out.println("Enter ID number to search for or -1 to quit: ");
			empNum = input.nextInt();
		}//END while loop
		
		foundIds = binSearch;
		notFoundIds = binFail;
		
		System.out.println("**Total number of IDs searched for: "+ searches);
		System.out.println("**Total number of employee IDs found: "+ foundIds);
		System.out.println("**Total number of IDs not found: "+ notFoundIds);
		
		input.close();
	}
}