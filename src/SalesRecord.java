import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SalesRecord {
	
	/*
	 * author:Justin Gross
	 * date:5/26/17
	 * Description:
	 * A class containing desired information and processes for a sales record
	 */
	
	/*
	 * The instance variables for the object:
	 * integer customers is static to allow for ever-increasing customer numbers
	 * boolean correct checks to see if the tax code is valid
	 * The rest of the variables contain the basic data for the record
	 */
	
	private static int customers=0;
	private int customerNumber;
	private String name;
	private double salesAmount;
	private String taxCode;
	private double totalAmount;
	private boolean correct;
	
	/*
	 * The instantiation of the object sets all of the various variables to the desired states
	 * totalAmount is calculated using a private method
	 */
	
	public SalesRecord(String aName, double aSalesAmount, String aTaxCode)
	{
		customers++;
		customerNumber=customers;
		name=aName;
		salesAmount=aSalesAmount;
		taxCode=aTaxCode;
		correct=true;
		totalAmount=calcTotalAmount(salesAmount, taxCode);
		
		
	}
	
	/*
	 * This method prints the sales record
	 * If the record is incorrect, it prompts the user to enter a correct tax code
	 * Then the record prints
	 */
	
	public void printSalesRecord(Scanner tax)
	{
		//the do-while loop forces the program to run at least once (if the tax code is correct)
		//it allows for continual incorrect inputs by the user and runs until a correct code is input
		do
		{	
			//checks the tax code to see if current tax is correct
			totalAmount=calcTotalAmount(salesAmount, taxCode);
			
			//If correct, print the record and rounds the sales amount appropriately
			
			if(correct)
			{
				
				DecimalFormat df =  new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.DOWN);
				
				System.out.println("Customer ID: "+ customerNumber);
			
				System.out.println("Customer Name: "+name);
				System.out.println("Sales Amount: "+salesAmount);
				System.out.println("Tax Code: "+taxCode);
				System.out.println("Total Amount Due: "+df.format(totalAmount));
				System.out.println("\n");
			}
			//If incorrect, it prompts for correct code, giving the user the available options
			else
			{
				
				System.out.println("This sales record is incorrect. Please reset tax code");
				System.out.println("The tax Code options are: NRM, NPF, and BIZ.");
				System.out.println("Please input new correct tax code now:");
				taxCode=tax.nextLine();
				
				
			}
			
		}while(!correct);
		
	}
	/*
	 * this method calculates the total amount including sales tax
	 * if the tax code is incorrect, total is 0 and the boolean is switched to false
	 * returns total
	 */
	
	private double calcTotalAmount(double aSalesAmount, String aTaxCode)
	{
		double total;
		if(aTaxCode.equals("NRM"))
		{
			correct=true;
			total=aSalesAmount*1.06;
			
		}
		else if(aTaxCode.equals("NPF"))
		{
			total=aSalesAmount;
			correct=true;
			
		}
		else if(aTaxCode.equals("BIZ"))
		{
			correct=true;
			total=aSalesAmount*1.045;
			
		}
		else
		{
			total=0;
			correct=false;
		}
			
		
		
		
		
		
		return total;
	}
	
	
	
}
