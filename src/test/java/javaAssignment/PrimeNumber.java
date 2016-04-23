package javaAssignment;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner scanner = null;
		try{
			int flag=0;
			scanner = new Scanner(System.in);
			System.out.println("Enter a number.");
			int n = scanner.nextInt();
			if(n==0 || n==1){
				System.out.println(n+" is nither Prime nor Composit.");
			}else{
				for(int i=2; i<=n/2; i++){
					if(n%i==0){
						System.out.println(n+" is not a Prime number.");
						flag=1;
						break;
					}
				}
				if(flag==0)
					System.out.println(n+" is a Prime number.");
			}
		}
		finally {
		    if(scanner!=null)
		        scanner.close();
		}
	}	
}

