package pra;

import java.util.Scanner;

public class Palindrome { 
	public static void main(String args[]){  
		  method4();
		}  
	
	public static void method1(){  
		  int r,sum=0,temp;    
		  int n=454;//It is the number variable to be checked for palindrome  
		  
		  temp=n;    
		  while(n>0){    
		   r=n%10;  //getting remainder  
		   sum=(sum*10)+r;    
		   n=n/10;    
		  }    
		  if(temp==sum)    
		   System.out.println("palindrome number ");    
		  else    
		   System.out.println("not palindrome");    
		}  
	
	public static void method2() {
		String s = "malayalam";
		int i;
		for(i=0; i<(s.length())/2; i++){
			if(s.charAt(i) == s.charAt(s.length()-(i+1))){	
			}
			else{
				break;
			}
		}
		if(i== s.length()/2){
			System.out.println("String is a Palindrome");
		}else{
			System.out.println("String is not a Palindrome");
			}
	}
	public static void method3()
	{
	  String inputString;
	  Scanner in = new Scanner(System.in);
	
	  System.out.println("Input a string");
	  inputString = in.nextLine();
	
	  int length  = inputString.length();
	  int i, begin, end, middle;
	
	  begin  = 0;
	  end    = length - 1;
	  middle = (begin + end)/2;
	
	  for (i = begin; i <= middle; i++) {
	    if (inputString.charAt(begin) == inputString.charAt(end)) {
	      begin++;
	      end--;
	    }
	    else {
	      break;
	    }
	  }
	  if (i == middle + 1) {
	    System.out.println("Palindrome");
	  }
	  else {
	    System.out.println("Not a palindrome");
	  } 	
	}
	public static void method4(){
		String original, reverse = "";
	      Scanner in = new Scanner(System.in);
	 
	      System.out.println("Enter a string to check if it is a palindrome");
	      original = in.nextLine();
	 
	      int length = original.length();
	 
	      for ( int i = length - 1; i >= 0; i-- )
	         reverse = reverse + original.charAt(i);
	 
	      if (original.equals(reverse))
	         System.out.println("Entered string is a palindrome.");
	      else
	         System.out.println("Entered string is not a palindrome.");
	}
}
