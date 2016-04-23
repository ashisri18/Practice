package javaAssignment;

import java.util.Scanner;

public class EvenOddNumber {
	public static void main(String[] args) {
		Scanner scanner = null;
		try{
			scanner = new Scanner(System.in);
		
			System.out.println("Enter a number.");
			int i = scanner.nextInt();
			if (i%2==0){
				System.out.println("Entered number "+i+" is Even number.");
			}else {
				System.out.println("Entered number "+i+" is Odd number.");
			}
		}
		finally {
			if(scanner!=null)
	        scanner.close();
		}
	}	
}
