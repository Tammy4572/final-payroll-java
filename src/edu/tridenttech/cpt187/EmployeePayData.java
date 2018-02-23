//FILE:	EmployeePayData.java
//PROG:	Tammy Castro
//PURP: implementation of two search algorithms for searching arrays
package edu.tridenttech.cpt187;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeePayData {
	
	private int[] idNum = new int[375];
	private double[] payRate = new double [375];
	private int recCount = 0;
	private int id = 0;
	private double rate = 0.0;
	double rateOfPay = 0.0;

	public void loadArray()
	{
		int index = 0;
		recCount  = 0;
		id = 0;
		rate = 0.0;
		//opens and read in the data from the given file
		try
		{
			String filename = "masterEmpPay.dat";
			Scanner infile = new Scanner(new FileInputStream(filename));
			
			while(infile.hasNext())
			{
				//Read a complete record
				id= infile.nextInt();
				idNum[index] = id;
				rate = infile.nextDouble();
				payRate[index] = rate;
				//Increments the count of elements
				++recCount;
				++index;
			}
			//closes file out
			infile.close();
		}//END try statement
		catch(IOException ex)
		{
		recCount = -1;
			ex.printStackTrace();
		}
	}//END loadArray
	
	public double getOnePayRate(int empNum)
	{
			int pay = binSearch(empNum);
			rateOfPay = payRate[pay];
			return rateOfPay;
	}
//	public int seqSearch(int empNum)
//	{
//		int index = 0;
//		int found = -1;
//		//while subscript number is not last number keep searching
//		//compares index to total number of records in Array to find target
//		while(index < recCount)
//		{
//			if(empNum == idNum[index])
//			{
//				found = index;
//				index = recCount;				
//			}
//			else
//			{
//				++index;
//			}	
//		}//END while
//			return found;
//	}//END seqSearch
	
	public void bubbleSort()
	{
		int last = recCount -1;
		for(int i = idNum.length -1; i > 0; i--)
		{
			int ind = 0;
			int swap1 = 0;//swaps idNum
			double swap2 = 0.0; //swaps payRate
			for(ind = 0; ind < last; ind++)
			{					
				if(idNum[ind] > idNum[ind + 1])
				{
					//swaps elements
					swap1 = idNum[ind];
					swap2 = payRate[ind];
					idNum[ind] = idNum[ind + 1];
					payRate[ind] = payRate[ind +1];
					idNum[ind + 1] = swap1;
					payRate[ind + 1] = swap2;
				}
			}
			if(swap1 == 0)
			{
				last = 0;
			}
			else
			{
				last = last -1;
			}
		}
	}	
	
	public int binSearch(int empNum)
	{
		int first = 0;
		int last = recCount -1;
		int found = 0;
		int mid = 0;
		while(idNum[first] <= idNum[last] && found == 0)
		{
			mid = (first + last)/2;
			//yes mid idNumber is == target
			if(idNum[mid] == empNum)
			{
				found = 1;
			}//END if
			//mid of idNumber is != target
			else 
			{	
				//if mid idNumber less than target 
				if(idNum[mid] < empNum)
				{
					first = mid + 1;
				}
				//mid not less than target
				else
				{
					last = mid - 1;
				}//END else
			}//END else	
		}//END while
		//not <= last and found != 0
		if(found == 0)
		{
			mid = -1;
			return mid;
		}
		return mid;
	}//END binSearch 
	
}