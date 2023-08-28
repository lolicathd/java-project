import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class Aufgabe_1_1 {
	private int[] arr;
	int full;
	
	public Aufgabe_1_1(int i)
	{
		arr = new int [i];
		full = 0;
		
	}
	
	
	public static void main(String args[]){
	int stackG = 0;
	int a = 0;
	int ob = 0;
	boolean loop = true;
	Scanner sc = new Scanner (System.in);
		
	System.out.print("Wie gross soll ihre stack sein (nur nummer): ");
	stackG = Integer.parseInt(sc.next());
	Aufgabe_1_1 a1 = new Aufgabe_1_1(stackG);
	
	while(loop == true)
	{
	System.out.println("1. Pop");
	System.out.println("2. Push");
	System.out.println("3. Print");
	System.out.println("4. Exit");
	
	a = Integer.parseInt(sc.next());
	switch (a)
	{
		case 1:
		int p = 0;
		p = a1.Pop();
		if (p == -1)
		{
			System.out.println("Stack ist leer");
		}
		else
		{
			System.out.println("Element gelöscht");
		}
		break;
		case 2:
		System.out.println("Push");
		System.out.println("");
		System.out.print("Objekt nummer : ");
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
		a1.Print();
		break;
		case 4:
		loop = false;
		break;
		default:
		System.out.println("invalid nummber try again");
		break;
	}
	}
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
public int Pop()
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
	arr[f] = 0;
	this.full = f;
	return 0;
	
		

}
public void Print()
{
	System.out.println("");
	System.out.println("Print");
	System.out.println("");
		
	int f = full;
	
	for (int i = 0; i < f;i++)
	{
	System.out.println(arr[i]);
	}
	System.out.println("");
	
}
}