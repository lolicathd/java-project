import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Aufgabe_3_2 
{
 public static void main(String args[])
{
	ArrayIntegerList A1;
	ArrayGList A2;
	int answer;
	Scanner sc = new Scanner(System.in);
	int ans, w1,w2;
	double w11 = 0;
	boolean loops = true,b1,b2 = true,b3 = true;
	//b2 is used here as a checker for int or double
	String result;
	System.out.println("Wie gross soll ihrer array sein ?(NUMMER)");
	System.out.println("");
	result = sc.next();
	while (b3 == true)
	{
	
	System.out.println("wollen sie");
	System.out.println("1. ganze zahlen");
	System.out.println("2. kommer zahlen");
	
	answer = Integer.parseInt(sc.next());
	switch (answer)
	{
		case 1:
		
		b2 = true;
		b3 = false;
		break;
		case 2:
		
		b2 = false;
		b3 = false;
		break;
		default:
		System.out.println("Falsche zahl");
		System.out.println("");
		break;
	}
	
	}
	A1 = new ArrayIntegerList(Integer.parseInt(result));
	A2 = new ArrayGList(Integer.parseInt(result));
	
	System.out.println("");
	while(loops == true)
	{
	System.out.println("");
	System.out.println("Was wollen sie tun ? (WAHLEN MIT NUMMER)");
	System.out.println("");
	System.out.println("1. leange auslesen");
	System.out.println("2. fuegt ein wert am ende ein");
	System.out.println("3. Das erste wert");
	System.out.println("4. loescht den ersten wert");
	System.out.println("5. wert finden");
	System.out.println("6. ausgabe von inhalte");
	System.out.println("7. exit");
	ans = Integer.parseInt(sc.next());
	w2 = 0;
	
	switch(ans)
	{
		case 1:
		if (b2 == true)
		{
		System.out.println("leange = "+A1.getLenght());
		}
		else
		{
		System.out.println("leange = "+A2.getLenght());
			
		}
		break;
		
		case 2:
		
		System.out.println("");
		System.out.println("Bitte geben sie ein wert ein");
		if (b2 == false)
		{
			System.out.print(" kommer mit punkt (.) ersetzen");
		}
		System.out.println("");
		if(b2 == true)
		{
		w1 = Integer.parseInt(sc.next());
		w2 = A1.insertLast(w1);
		}
		else
		{
			w11 = Double.parseDouble(sc.next());
			w2 = A2.insertLast(w11);
		}
		if (w2 == 0)
		{
			System.out.println("Erfolgreich");
		}
		else
		{
			System.out.println("Array voll");
		}
		break;
		
		case 3:
		if (b2 == true)
		{
		w2 = A1.getFirst();
		System.out.println("");
			
		}
		else
		{
			w11 = A2.getFirst();
			System.out.println("");
		}
			
			if (w2 == -9999)
				{
			System.out.println("Kein wert vorhanden");
				}
			
			if (b2 == true)
			{
			System.out.println("das erste wert ist "+w2);	
			}
			if(b2 == false)
			{
				if (w11 == -9999.0)
			{
			System.out.println("Kein wert vorhanden");
			}
			else
			{
			System.out.println("das erste wert ist "+w11);
			}
			}
		
		System.out.println("");
		break;
		
		case 4:
		if (b2 == true)
		{
		System.out.println("");
		w2 = A1.deleteFirst();
		if (w2 == -1)
		{
			System.out.println("Kein wert vorhanden");
		}
		}
		else
		{
		System.out.println("");
		w2 = A2.deleteFirst();
			
		if (w2 == -1)
		{
			System.out.println("Kein wert vorhanden");
		}
		else
		{
			System.out.println("Erfolgreich");
		}
		}
		System.out.println("");
		break;
		
		case 5:
		System.out.println("nach welchen wert suchen sie ?");
		if(b2 == true)
		{
		w2 = Integer.parseInt(sc.next());
		b1 = A1.search(w2);
			
		}
		else
		{
			w11 = Double.parseDouble(sc.next());
			b1 = A2.search(w11);
		
		}
		if (b1 == false)
		{
			System.out.println("Kein wert gefunden");
		}
		else
		{
			System.out.println("Wert befindet sich in array");
			
		}
		break;
		
		case 6:
		if (b2 == true)
		{
		A1.print();
		}
		else
		{
		A2.print();
		
		}
		break;
		case 7:
		loops = false;
		break;
		
		default:
		System.out.println("Falsche zahl");
		break;
	}
}
}

}