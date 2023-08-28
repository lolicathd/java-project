import java.io.*;
import java.util.Scanner;

public class Aufgabe_2_1 {
	private byte[] M; //menge
	private int[] GM; //grundMengen
	private int full; //eigentliche größe GM
	
	public Aufgabe_2_1(int a)
	{
		
		//maximale Element der Grundmenge und Menge
		GM = new int[a];
		 M = new byte[a];
		 for (int i = 0;i < a;i++)
		 {
			 M[i] = 0;
			 GM[i] = i;
		 }
		 
		full = 0;
	}
	
	
    public static void main(String args[]){
		
		Aufgabe_2_1 A2;
		Scanner sc = new Scanner (System.in);
		int ant;
		boolean loop = true;
		
		System.out.print("Geben sie die Größe für grundMengen(GM) nur nummer : ");
		A2 = new Aufgabe_2_1(Integer.parseInt(sc.next()));
		System.out.println("");
		System.out.println("");
		while (loop == true)
		{
			System.out.println("Was wollen sie machen");
			System.out.println("");
			System.out.println("1. add");
			System.out.println("2. size");
			System.out.println("3. print");
			System.out.println("4. Exit");
			System.out.println("");
			System.out.print("Ihrer auswahl (nur nummer) : ");
			ant = Integer.parseInt(sc.next());
		
			switch (ant)
			{	
				//add
				case 1:
				System.out.println("");
				System.out.print("bitte geben sie ihre werte ein (GTRENNT MIT KOMMER (,)): ");
				String pout = sc.next();
				String pout1[] = pout.split(",");
				
				
				int antwort_add = A2.add(pout1);
				if (antwort_add == -1)
				{
					System.out.println("KONNTE NICHT EINGEFÜGT WERDEN");
				}
				if(antwort_add == 0)
				{
					System.out.println("Erfolgreich");
				}
				break;
				//size
				case 2:
				int SIZE_1;
				SIZE_1 = A2.size();
				System.out.println(SIZE_1);
				break;
				//print
				case 3:
				A2.print();
				break;
				//ende
				case 4:
				loop = false;
				break;
				
				default:
				System.out.println("invalid nummber ");
				break;
			}
		}
		
		
		
		
    }
	
	
	public int size()
	{
		return full;
	}
	
	public void print()
	{
		for(int i = 0;i < GM.length;i++)
		{
			System.out.print("|"+M[i]+"|");
		}
		System.out.println("");
		for(int i = 0;i < GM.length;i++)
		{
			System.out.print("|"+GM[i]+"|");
		}
		
	}
	
	public int add(String[] c)
	{
		int s = c.length;
		int[] a = new int[s];
		for(int i = 0;i < s;i++)
		{
			a[i] = Integer.parseInt(c[i]);
			
		}
		int clear = a.length;
		//int i = 0;
		clear--;
		for(int i = 0;i <= clear;i++)
		{
			
			for(int j = 0;j<= clear;j++)
			{
				
				if(i == j)
				{
					//System.out.println("No ERR");
				}
				else
				{
					
					if (a[i]==a[j])
					{
						return -1;
					}
					
				}
			}
			
		}
		int l;
		for(int i = 0;i < a.length;i++)
		{
			l = a[i];
			
		if(l < 0||l > GM.length)
		{
			return -1;
		}
		if(GM.length == full)
		{
			return -1;
		}
		}
		for(int i = 0;i < a.length;i++)
		{
			l = a[i];
		if(M[l]== 0)
		{
			M[l] = 1;
			full++;
			
		}
		}
		return 0;
	  
	}
	
	
	
	
}
