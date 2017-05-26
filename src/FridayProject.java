import java.util.Scanner;

public class FridayProject {
	
	/*
	 * author:Justin Gross
	 * date: 5/26/17
	 * Description:
	 * This class contains the code for printing a series of records, the number of which is user determined
	 * Each record is input by the customer and then stored to the sales record object
	 */
	
	public static void main(String[] args)
	{
		//Creating the scanner and the boolean that checks for multiple records
		Scanner input = new Scanner(System.in);
		
		boolean cont=true;
		
		//the while loop is true and when the user no longer wants to put in records
		//the loop ends based off of the boolean
		while(cont==true)
		{
			//The while loop contains the functionality for processing and printing each record
			
			//The next code prompts for user input and reads it and then stores it in appropriate variables
			System.out.println("Please input a sales record ");
			System.out.println("Please begin by inputting the Customer's Name: ");
			String name=input.nextLine();
			System.out.println("");
			System.out.println("Next please input the sales amount: ");
			double salesAmount=input.nextDouble();
			System.out.println("Finally please input the tax code:");
			input.nextLine();
			String taxCode=input.nextLine();
			
			//we create the sales record object which holds all data and processes the sales record
			SalesRecord sr = new SalesRecord(name, salesAmount, taxCode);
			
			//prints the sales record
			sr.printSalesRecord(input);
			
			//prompts the user to input whether they desire to input another record and breaks the loop if not desired
			System.out.println("Would you like to input another record (Y/N)");
			String check= input.nextLine();
			if(check.equals("N"))
			{
				cont=false;
			}
		
		}
		//closes the scanner
		input.close();
	}

}
