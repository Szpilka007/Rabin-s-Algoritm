package application;

public class Euklides {

	
	public int Euklides1(int nwd_a, int nwd_b) 
	{
		int r, a, q, b;
		int  x,x1, x2;
		int  y,y1, y2;
		int nwd;	

		if (nwd_b > nwd_a)
		{
		nwd = nwd_b;
		nwd_b = nwd_a;
		nwd_a = nwd;
		}
		
		a = nwd_a;
		b = nwd_b;
		 
	
		q = a/b;
		r = a - q*b;
		nwd = b;
		 
		x2 = 1;
		x1 = 0;
		y2 = 0;
		y1 = 1;
		x = 1;
		y = y2 - (q-1)*y1;
		 
		while (r != 0)
		{
		a = b;
		b = r;
		 
		x = x2 - q*x1;
		x2 = x1;
		x1 = x;
		 
		y = y2 - q*y1;
		y2 = y1;
		y1 = y;     
		 
		nwd = r;
		q = a/b;
		r = a - q*b;
		}
	return x;
	}
	
	public int Euklides2(int nwd_a, int nwd_b) 
	{
		int r, a, q, b;
		int  x,x1, x2;
		int  y,y1, y2;
		int nwd;
		 
		if (nwd_b > nwd_a)
		{
		nwd = nwd_b;
		nwd_b = nwd_a;
		nwd_a = nwd;
		}
		
		a = nwd_a;
		b = nwd_b;
		 
		q = a/b;
		r = a - q*b;
		nwd = b;
		 
		x2 = 1;
		x1 = 0;
		y2 = 0;
		y1 = 1;
		x = 1;
		y = y2 - (q-1)*y1;
		 
		while (r != 0)
		{
		a = b;
		b = r;
		 
		x = x2 - q*x1;
		x2 = x1;
		x1 = x;
		 
		y = y2 - q*y1;
		y2 = y1;
		y1 = y;     
		 
		nwd = r;
		q = a/b;
		r = a - q*b;
		}
	return y;
	}
}
