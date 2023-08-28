import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Aufgabe_3_1 
{
 public static void main(String args[])
{
	ArrayIntegerList A1;
	Scanner sc = new Scanner(System.in);
	int ans, w1,w2;
	boolean loops = true,b1;
	
	String result;
	System.out.println("Wie gross soll ihrer array sein ?(NUMMER)");
	System.out.println("");
	result = sc.next();
	A1 = new ArrayIntegerList(Integer.parseInt(result));
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
		System.out.println("leange = "+A1.getLenght());
		 
		break;
		
		case 2:
		System.out.println("");
		System.out.println("Bitte geben sie ein wert ein");
		System.out.println("");
		w1 = Integer.parseInt(sc.next());
		w2 = A1.insertLast(w1);
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
		w2 = A1.getFirst();
		System.out.println("");
		if (w2 == -9999)
		{
			System.out.println("Kein wert vorhanden");
		}
		else
		{
		System.out.println("das erste wert ist "+w2);
		}
		System.out.println("");
		break;
		
		case 4:
		System.out.println("");
		w2 = A1.deleteFirst();
		if (w2 == -1)
		{
			System.out.println("Kein wert vorhanden");
		}
		else
		{
			System.out.println("Erfolgreich");
		}
		System.out.println("");
		break;
		
		case 5:
		System.out.println("nach welchen wert suchen sie ?");
		w2 = Integer.parseInt(sc.next());
		b1 = A1.search(w2);
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
		A1.print();
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