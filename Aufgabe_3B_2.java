import java.io.*;
import java.util.Scanner;

public class Aufgabe_3B_2 {
  
    public static void main(String args[]){
      
      Scanner sc = new Scanner (System.in);
		 
		 boolean [] a = new boolean [5];
		 boolean [] b = new boolean [5];
		 boolean [] c = new boolean [5];
      //-----------------------------   
         System.out.println ("geben sie a werten:");
		 System.out.println("");
		 for (int i = 0 ; i<5; i++) {
			 a [i] =  sc.nextBoolean();
			 }
			 
	  //-----------------------------
		 System.out.println("");
		 System.out.println ("geben sie b werten :");
		 System.out.println("");
		 
		 
		 for (int i = 0 ; i<5; i++) {
			 b [i] =  sc.nextBoolean();
			 }
      //-----------------------------
	
         
             System.out.println("");
             System.out.println("Ergebnis :");
			 System.out.println(" ");
			 
			 comperer(a,b,c);
			
          for (int i = 0 ; i<5; i++) {
			 System.out.println ("" +c[i]); 
			 }
             
             
    }
	
	
	
	public static void comperer(boolean [] a,boolean [] b,boolean [] c)
	{
		for ( int i = 0 ; i<5; i++) 
		{
			if ( a[i] == b[i])
			{
				c[i] = true;
			} 
			else 
			{
				c[i]= false;
			}
		}
		
	
	}
}
   
   
             
             
         