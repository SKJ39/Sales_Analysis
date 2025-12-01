package ec2;

import java.io.*;
import java.util.*;

public class FileIO {
	private String fname = null;
	private boolean DEBUG = false;			//set true to print data read

	public FileIO(String fname) {			//Default Constructor
		this.fname = fname;
	}

	public Franchise readData() {
		Franchise a1 = null;
		int counter = 0;					//Reading line location
		
		try {								//Handles exceptions
			//Opening file
			FileReader file = new FileReader(fname);
			BufferedReader buff = new BufferedReader(file);
			String temp;
			boolean eof = false;			//end of file = false;
			
			while (!eof) {
				String line = buff.readLine();
				counter++;
				
				if (line == null) {
					eof = true;
				} else {
					if (DEBUG) {
						System.out.println("Reading" + line);
					}
					
					//Read the number of stores (first line), create a Franchise object, 
					//and parse in the size of the array
					if (counter == 1) {
						temp = line;
						a1 = new Franchise(Integer.parseInt(temp));
						if (DEBUG) {
							System.out.println("d  " + a1.numberofstores());
						}
					}
					
					//Ignore the second line (header)
					if (counter == 2);
					
					//Read each line, parse in data of each Store object
					if (counter > 2) {
						//Call another method to populate each Store object in the array in Franchise 
						int x = buildStore(a1, (counter-3), line);
						  	
						//Make sure the read and populated values are the same
						if (DEBUG) {
							System.out.println("Reading Store # "+(counter-2)+" Number of weeks read =  " +  x);
						} 
						if (DEBUG) {	
							System.out.println("Data read:");
							a1.getStores(counter-3).printdata();
						}
					}
				}
			}
			
			buff.close();
		} 
		catch (Exception e) {				//In case of an exception
			System.out.println("Error -- " + e.toString());
		}
		
		return a1;
	}

	//Build a Store object from readData() and parse to the array in Franchise
	public int buildStore(Franchise a1, int counter, String temp) {
		Store tstore = new Store();
		String s1  =  "";
		float sale = 0.0f;
		int week = 0;
		int day = 0;
		
		//Break a line into small tokens
		StringTokenizer st = new StringTokenizer(temp);
		
	    //Weekly loop (while the line is NOT null / has string tokens)
		while (st.hasMoreTokens()) {
	    	//Daily loop
	         for(day = 0; day < 7; day++) {
		    	 s1 = st.nextToken();
		         sale = Float.parseFloat(s1);
	        	 tstore.setsaleforweekdayintersection(week, day, sale);
	         }
	         week++;
	    }
		
		//Franchise go to each object array index(counter) to parse in a new Store object
		a1.setStores(tstore, counter);
	    return week; 
	}
}
