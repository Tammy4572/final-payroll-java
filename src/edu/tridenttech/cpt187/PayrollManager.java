//FILE:	PayrollManager.java
//PROG:	Tammy Castro
//PURP: implementation of two search algorithms for searching arrayspackage edu.tridenttech.cpt187;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PayrollManager {
	PrintWriter myWriter;
	public PayrollManager(String filename)
	{
		try {
			myWriter = new PrintWriter(new FileWriter(filename,true));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveOneRecord(int empNum,double payRate,double numHours,double pay) throws IOException
	{
		myWriter.printf("\n%5s %8s %6s %9.2f%n", empNum,payRate,numHours,pay);
		myWriter.close();
	}	
}
