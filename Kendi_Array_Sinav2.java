import java.io.*;
import java.util.Scanner;

public class Kendi_Array_Sinav2 {
  
    public static void main(String args[]){
      
       BufferedReader in
     = new BufferedReader(new InputStreamReader(System.in));
       
       
       public static int neue1 ( boolean [] a, boolean [] b, boolean [] c, int i) {
       
        for ( i = 0 ; i<5; i++) {
               if ( a[i] == b[i]){
                 c[i] = true;
               } else {
                   c[i]= false;
                 }
          }
	   }
         public static void main(String args[]) throws IOException {
   
    
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         int i=0 ; 
    
     boolean [] a = new boolean [5];
      boolean [] b = new boolean [5];
       boolean [] c = new boolean [5];
         
       Scanner sc = new Scanner (System.in);
         
    System.out.println ("geben sie a werten:");
      for ( i = 0 ; i<5; i++) {
      a [i] =  sc.nextBoolean();
         }
        
      System.out.println ("geben sie b werten :"); 
 for ( i = 0 ; i<5; i++) {
      b [i] =  sc.nextBoolean();
    }
       
   
 System.out.println ("Array C:"); 
          for ( i = 0 ; i<5; i++) {
             //c [i] =  sc.nextBoolean();
            System.out.println ("" +c[i]); 
          }
             
    }
}