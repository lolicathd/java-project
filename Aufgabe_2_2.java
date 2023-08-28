import java.io.*;
import java.util.Scanner;

public class Aufgabe_2_2 {
	private byte[] M; //menge
	private int[] GM; //grundMengen
	private int full; //eigentliche größe GM
	
	public Aufgabe_2_2(int a)
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
	public Aufgabe_2_2(int a, int b)
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
		b--;
		for(int i = 0;i <= b;i++)
		{
			M[i] = 1;
			
		}
		full = b;
		
	}
	
    public static void main(String args[]){
		
		Aufgabe_2_2 A2;
		int wert1, wert2;
		Scanner sc = new Scanner (System.in);
		int ant;
		String result;
		boolean loop = true;
		
		System.out.println("Geben sie die Größe für grundMengen(GM) nur nummer : ");
		System.out.println("(OPTIONAL) bis wo soll die Menge gefühlt werden");
		System.out.println("um ein zweiten parameter zu geben bitte trennen sie es mit ein kommer(,) zeichen");
		result = sc.next();
		String a[] = new String[1];
		a = result.split(",");
		wert1 = Integer.parseInt(a[0]);
		if (a.length == 2)
		{
			wert2 = Integer.parseInt(a[1]);
			A2 = new Aufgabe_2_2(wert1, wert2);
		}
		else
		{
			A2 = new Aufgabe_2_2(wert1);
		}
		System.out.println("");
		System.out.println("");
		while (loop == true)
		{
			System.out.println("Was wollen sie machen");
			System.out.println("");
			System.out.println("1. add");
			System.out.println("2. addE");
			System.out.println("3. size");
			System.out.println("4. print");
			System.out.println("5. Check_if");
			System.out.println("6. Exit");
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
				case 2:
				int ober,unter;
				System.out.println("Bitte geben sie ein oben und unten wert (NUR ZIFFER GETRENNT MIT KOMMER (,))");
				System.out.println("Beispiel (unter,ober). z.B. 2,12 ");
				String ouwert = sc.next();
				String ls[] = new String[1];
				int aout;
				ls = ouwert.split(",");
				ober = Integer.parseInt(ls[1]);
				unter = Integer.parseInt(ls[0]);
				aout = A2.AddE(unter,ober);
				if (aout == -1)
				{
					System.out.println("OUT OF BOUND");
				}
				if (aout == 0)
				{
					System.out.println("SUCC");
				}
				break;
				//size
				case 3:
				int SIZE_1;
				SIZE_1 = A2.size();
				System.out.println(SIZE_1);
				break;
				//print
				case 4:
				A2.print();
				break;
				case 5:
				 System.out.println(A2.check_if());
				break;
				//ende
				case 6:
				loop = false;
				break;
				
				default:
				System.out.println("invalid nummber ");
				break;
			}
		}
		
		
		
		
    }
	public int AddE(int a,int b)
	{
		
		System.out.println(GM.length);
		if (a > b||a < 0||b < 0||a > GM.length||b > GM.length)
		{
			return -1;
		}
		else
		{
			
		}
		
		//a = unter
		//b = ober
		while(a <= b)
		{
			M[a] = 1;
			a++;
		}
		
		return 0;
	}
	
	public int size()
	{
		return full;
	}
	public boolean check_if()
	{
		if(full == 0)
		{
			return true;
		}
		
			return false;
		
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
