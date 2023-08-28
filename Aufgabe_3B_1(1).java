import java.io.*;
import java.util.Scanner;

public class Aufgabe_3B_1 {
  
    public static void main(String args[]){
      
       BufferedReader in
     = new BufferedReader(new InputStreamReader(System.in));
      
    
     int [] a = new int [5];
     int [] b = new int [5];
     boolean [] c = new boolean [5];
         
       Scanner sc = new Scanner (System.in);
 //----------------------------------------------------------

	System.out.println("Bitte geben sie ganze zahlen an fuer a :");
	System.out.println("");
	
	for (int i = 0;i != 5;i++)
	{
		a[i] = Integer.parseInt(in.readline());
	}
		 
	System.out.println("");
		 
		 
    
             
             System.out.println("Ergebnis :");
			 System.out.println(" ");
			 
          for ( i = 0 ; i<5; i++) {
             //c [i] =  sc.nextBoolean();
            System.out.println ("" +c[i]); 
          }
             
    }
}
   
   
             
             
         