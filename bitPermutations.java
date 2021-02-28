import java.util.*;
import java.io.*;

public class  bitPermutations
{
	public static boolean[][] bitString (int n)
	{
		int ai; // the array index
		int mi = 0; // the matrix index
		
		int power = 1 << n; // how many total permutations of a bitstring of length n
		
		
		boolean[] boolArray = new boolean[n];
		boolean[][] boolMatrix = new boolean[power][n];
		
		do
		{
			
			//places the bool array inside of the matrix array
			for(int i = 0; i < n; i++)
				boolMatrix[mi][i] = boolArray[i];
				
			mi++;
			ai = n - 1; // reset array index
			for(int i = 0; i < n; i++)
				if( ai >= 0 && boolArray[ai] == true)
					ai--;
			if(ai >= 0 )
			{
				boolArray[ai] = true;
				for(int j = ai + 1; j< n; j++) // everything else must be false
					boolArray[j] = false;
			}
		}	
		while(ai != -1);	
		
		return boolMatrix;
	}
	
	
	
	public static int FindTotal(int[] arr, int total, boolean display)
	{
		int output = 0;
		boolean[][] matrixLookup = bitString(arr.length);
		int[] outputList = new int[arr.length];
		
	
		
		for(int i = 0; i < matrixLookup.length; i++)
		{
			int totalCheck = 0;
			for(int j = 0; j < arr.length; j++)
			{
				if(matrixLookup[i][j])
				{
					totalCheck += arr[j];
					outputList[j] = arr[j];
				}
			}
				//System.out.println(totalCheck);
			
			if(totalCheck == total)
			{
				output++;
				if(display){
					System.out.print("[ ");
						
						for(int j = 0; j < arr.length; j++)
						{
							System.out.print(outputList[j] + " ");
							
						}
					System.out.print("]\n");
					
				}
		
						
			}
				else
				{
					for(int j = 0; j < arr.length; j++)
					{
						outputList[j] = 0;
					}
				}
		}
		return output;
	}
	
	
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4};
		System.out.println(FindTotal(arr, 7, true));
		/*
		//int bitStrLength = 2;
		//System.out.println("FLIP");
		//boolean[][] flip = bitString(bitStrLength);
		
		//System.out.println("FFFF");
		//System.out.println(flip[0][0]);
		
		int power = 1 << bitStrLength;
		
		System.out.println(power);
		
		for(int i = 0; i < power; i++)
		{
			for(int j = 0; j < bitStrLength; j++)
			{	
				System.out.print(flip[i][j] + " ");
			}
			System.out.println();
		}	
		*/ 
	}
}
