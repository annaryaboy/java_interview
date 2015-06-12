import java.util.*;
import java.io.*;
import java.util.Scanner;


public class Tax {
	int qty = 0;
	String prodName = null;
	float price = 0.0f;
	boolean luxury = false;
	float tax = 0.0f;

	void calculateSalesTax() {
		float totalTax = 0.0f;
		if (luxury)
			totalTax = 0.09f;
		else {
		        totalTax = 0.01f;
		}
		
		tax = totalTax * price;
	}

	public String toString() {
		float p = price + tax;
		return qty + " " + prodName + " at " + p + " total: " + p*qty + " total cents: " + p*qty*100;
	}


	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		ArrayList list = new ArrayList();
		int no = 1;
		while (true) {
		Tax tax = new Tax();
			System.out.println("Add Item Number: " + no);
			System.out.print("Quantity: ");
			int qty = input.nextInt();
			tax.qty = qty;
			System.out.print("Product Name: ");
			String prod = input.next();
			tax.prodName = prod;
			System.out.print("Price: ");
			float p = input.nextFloat();
			tax.price = p;
			System.out.print("Is it Luxury[y/n]: ");
			String lux = input.next();
			if (lux.toLowerCase().equals("y"))
				tax.luxury = true;

			tax.calculateSalesTax();
			list.add(tax);
			no++;
			System.out.print("Add More Items [y/n]: ");
			String add = input.next();
			if (add.toLowerCase().equals("n"))
				break;
			
		}
		

		for (int i = 0; i < list.size(); i++) {

			Tax t = new Tax();
			t =(Tax)list.get(i);

			System.out.println("Result: " + t);

		}
      }
}
