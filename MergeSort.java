package multithread;

import java.util.Scanner;

public class MergeSort extends Thread {
	
    Scanner sc=new Scanner(System.in);
    
    @Override
    public void run()
    {
    	  int x[];
		  int y[];
		  int z[];
		  int s1,s2;
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the size of the first matrix");
		  s1=sc.nextInt();
		  System.out.println("Enter the size of the second matrix");
		  s2=sc.nextInt();
		  
		  x=new int[s1];
		  
		  y=new int[s2];
		  
		  z=new int[s1+s2];
		  
		  System.out.println("Enter the values into the first matrix");
		  accept(x,s1);
		  System.out.println("Enter the values into the second matrix");
		  accept(y,s2);
		  
		  mergesort(x, y, z, s1, s2);
		  
		  System.out.println("After sorting the values are");
		  disp(z, s1+s2);
		  
		  

    }
	void accept(int a[],int n)
   {
       int i;

	for(i=0;i<n;i++)
	{
	    a[i]=sc.nextInt();
	}
	
   }

    void disp(int a[],int n)
    {
      int i;

	for(i=0;i<n;i++)
	{
	  System.out.print(" "+a[i]);
	}
     }

     int mergesort(int a[],int b[],int c[],int m,int n)
     {
       int i=0,j=0,id=0;

	  while( i<m && j<n)
	  {
	     if( a[i] < b[j] )
	     {
	       c[id]= a[i];
	       i++;
	     }
	     else if( b[j]<a[i] )
	     {
	       c[id]=b[j];
	       j++;
	     }
	     else
	     {
	       c[id]=a[i];
	       i++;
	       j++;
	     }
	     id++;
	  }

	  while(i<m)
	  {
	    c[id]=a[i];
	    i++;
	    id++;
	  }
	  while(j<n)
	  {
	    c[id]=b[j];
	    j++;
	    id++;
	  }
	  return id;
    }

	public static void main(String[] args) {
		
            
		  MergeSort ms=new MergeSort();
		  ms.start();
		  
	}
}