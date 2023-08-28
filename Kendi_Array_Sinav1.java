import java.io.*;
import java.util.Scanner;

public class Kendi_Array_Sinav1 {
  
    public static void main(String args[]){
      
   
     boolean [] a = new boolean [5];
      boolean [] b = new boolean [5];
       boolean [] c = new boolean [5];
         
       Scanner sc = new Scanner (System.in);
         
    System.out.println ("geben sie a werten:");
      for (int i = 0 ; i<5; i++) {
      a [i] =  sc.nextBoolean();
         }
        
      System.out.println ("geben sie b werten :"); 
 for (int i = 0 ; i<5; i++) {
      b [i] =  sc.nextBoolean();
    }
       
 
 
          
 for (int i = 0 ; i<5; i++) {
               if ( a[i] == b[i]){
                 c[i] = true;
               } else {
                   c[i]= false;
                 }
          }
             
             System.out.println("Ergebnis :");
			 System.out.println(" ");
			 
          for (int i = 0 ; i<5; i++) {
             //c [i] =  sc.nextBoolean();
            System.out.println ("" +c[i]); 
          }
             
    }
}
   
   
             
             
         