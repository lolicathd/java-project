import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class Aufgabe_1_2 {
	//unser array Stack
	private int[] arr;
	//wie viele werte sind in Stack 
	private int full;
	
	
	//konstruktor
	public Aufgabe_1_2(int i)
	{
		arr = new int [i];
		full = 0;
		
	}
	//überladen konstruktor
	public Aufgabe_1_2(int a, int b)
	{
		//das array wird erzeugt und besetzt
		arr = new int [a];
		int ss = arr.length;
		System.out.println(ss);
		//das füllungs program
		for(int i = 0;i < a;i++)
		{
			arr[i] = b;
			b++;
			
		}
		full = a;
	}
	
	public static void main(String args[]){
	
	
	Aufgabe_1_2 a1;
	int stackG, stackG1;
	int a = 0;
	int ob = 0;
	String result;
	boolean loop = true; //nur für den loop 
	Scanner sc = new Scanner (System.in);
	
	//übergabe von werten an den konstruktor
	System.out.println("Wie gross soll ihre stack sein (nur nummer) und ");
	System.out.println("(OPTIONAL) mit welchen wert soll es gefuelt werden (wert, wert+1,wert +2 ...)");
	System.out.println("");
	System.out.println("");
	System.out.println("bitte nur die werte trennen mit , zeichen!!");
	
	result = sc.next();
	String alfa[] = new String[1];
	alfa = result.split(",");
	stackG = Integer.parseInt(alfa[0]);
	//rausfinden wie viele werte würden übergaben
	if (alfa.length == 2)
	{
	stackG1 =Integer.parseInt(alfa[1]);
	a1 = new Aufgabe_1_2(stackG,stackG1);
	}
	
	// wieso funktioniert das nicht ? (Nachfragen)
	/*
	if (alfa.length > 2)	
	{
		System.out.println("Zu viele werte angegeben");
	}
	*/
	else
	{
	a1 = new Aufgabe_1_2(stackG);
	}
	
	
	//auswahl programm
	while(loop == true)
	{
		
	System.out.println("1. Pop");
	System.out.println("2. Push");
	System.out.println("3. Array Push"); 
	System.out.println("4. Print");
	System.out.println("5. SUM");
	System.out.println("6. Exit");
	
	a = Integer.parseInt(sc.next());
	switch (a)
	{
		case 1:
		//Pop
		//Eine Methode, die genau dann true als Rückgabewert liefert, wenn der Stack leer ist.
		
		boolean p, aaaa;
		p = a1.Pop();
		aaaa = a1.Rpop();
		if (p == true)
		{
			System.out.println("Stack ist leer");
		}
		else
		{
			System.out.println("Element geloescht");
		}
		System.out.println("wert "+aaaa);
		break;
		case 2:
		// Push
		System.out.println("Push");
		System.out.println("");
		System.out.print("Ihrer Wert : ");
		ob = Integer.parseInt(sc.next());
		System.out.println("");
		int r = -2;
		r = a1.Push(ob);
		if (r == -1)
		{
			System.out.println("Ihre stack ist voll");
		}
		else
		{
			System.out.println("Element hinzugefuegt");
		}
		break;
		
		case 3:
		//Array Push
		int rr =-2;
		String ree;
		int size;
		int[] ArrayP;
		System.out.println("Auswahl Array Push");
		System.out.println("Bitte nur werte trennen mit , zeichen ");
		ree = sc.next();
		String[] ArrayS = ree.split(",");
		
		size = ArrayS.length;
		ArrayP = new int[size];
		
		for (int i = 0; i<size;i++)
		{
			ArrayP[i] = Integer.parseInt(ArrayS[i]);
			System.out.println(ArrayP[i]);
		}
		rr = a1.PushE(ArrayP);
		if (rr == -1)
		{
			System.out.println("ZU VIELE WERTE (KEIN AUSREICHTBARE PLATZ)");
		}
		if (rr == 0)
		{
			System.out.println("Erfolgreich");
		}
		break;
		
		case 4:
		//Print
		a1.Print();
		break;
		case 5:
		System.out.println("ihre wert: ");
		int alfa1 = Integer.parseInt(sc.next());
		int beta;
		beta= a1.sum(alfa1);
		if(beta == -1)
		{
			System.out.println("KEIN WERT");
		}
		else
		{
			System.out.println("ihre komplete summe: "+beta);
		}
		break;
		case 6:
		//Exit
		loop = false;
		break;
		default:
		//alle andere werte
		System.out.println("invalid nummber try again");
		break;
	}
	}
}
	
public int PushE(int[] a)
{
	int counter = 0;
	int i = this.full;
	if ((i + a.length) <= arr.length)
	{
		for(int s = i;s < (a.length +i);s++)
		{
			arr[s] = a[counter];
			System.out.println(a[counter]);
			
			
				counter++;
			
		}
	}
	else
	{
		return -1;
	}
	i = i + a.length;
	this.full = i;
	return 0;
	
}

public int Push(int a)
{
	int ant = this.full;
	
	if (ant == arr.length)
	{
		return -1;
	}
	else
	{
	this.arr[ant] = a;
	ant++;
	this.full = ant;
	
	return 0;
	}
}
public boolean Pop()
{
	int f = full;
	f--;
	if (f < 0)
	{
		f = 0;
	}
	if (arr[f] == 0)
	{
		return true;
	}
	arr[f] = 0;
	this.full = f;
	return false;
	
		

}
public int sum(int a)
{
	int f = full;
	f--;
	if (f < 0)
	{
		f = 0;
	}
	if (arr[f] == 0)
	{
		return -1;
	}
	int summe = 0;
	this.full = f;
	for(int  i= 0;i < a;i++)
	{
		summe = summe + arr[f];
		arr[f] = 0;
		f--;
		
	}
	this.full = f;
	return summe;
	
		

}
public boolean Rpop()
{
	if(full == 0)
	{
		return true;
	}
	return false;
}
public void Print()
{
	System.out.println("");
	System.out.println("Print");
	System.out.println("");
		
	int f = full;
	
	for (int i = 0; i < f;i++)
	{
	System.out.println((i+1)+". "+arr[i]);
	}
	System.out.println(""); 
	
}
}