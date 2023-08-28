interface GList
{
	int getLenght();
	int insertLast(double value);
	double getFirst();
	int deleteFirst();
	boolean search(double value);
	void print();
}
public class ArrayGList implements GList
{
	
	private double[] arr;
	private int full = 0;
	
	public int getLenght()
	{
		return arr.length;
		
	}
	
	public int insertLast(double value)
	{
	
		if (full == arr.length)
		{
			
			return -1;
		}
		else
		{
			
		}
		if(arr[full] == 0.0)
		{
			arr[full] = value;
			
			full++;
			return 0;
		}
		
		else
		{
			return -1;
		}
		
	}
	
	public double getFirst()
	{
		if (arr[0] == 0.0)
		{
			return -9999;
		}
		return arr[0];
	}
	
	public int deleteFirst()
	{
		int is = full;
			if(arr[0] == 0.0)
			{
				
				return -1;
			}
			else
			{
				for(int i = 0;i < arr.length;i++)
				{
					int ii = i + 1;
					if (ii == arr.length)
					{
						
						full--;
						
						return 0;
					}
					else
					{
					
						arr[i] = 0.0;
					arr[i] = arr[ii];
					arr[ii] = 0.0;
					

					
					}
				}
				
			}
			return -1;
	}
	
	public boolean search(double value)
	{
		
		for(int i = 0;i < arr.length;i++)
		{
			if (arr[i] == value)
			{
				return true;
			}
		}
		return false;
	}
	
	public void print()
	{
		
		System.out.println("");
		for(int i = 0; i < arr.length;i++)
		{
			
			System.out.print("|"+i+"|");
		}
		System.out.println("");
		for(int i = 0; i < arr.length;i++)
		{
			
			System.out.print("|"+arr[i]+"|");
		}
	}
	
public ArrayGList(int i)
{
	arr = new double [i];
	
	full = 0;
}
}