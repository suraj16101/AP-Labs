import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;



class	MyGenericList <T extends Comparable<? super T>>	{	
	T element;
	MyGenericList left;
	MyGenericList right;
	private  MyGenericList<T> root;
	MyGenericList(T theElement) 
	{
	      element = theElement;
	      left = right = null;
	}	
	
	MyGenericList() 
	{
	      left = right = null;
	}	
	
	
	public void insert(T value) {

	    root = insert(value, root);
	  }
	
	public MyGenericList<T> get(){
		return root;
	}
	
	public MyGenericList<T> insert(T value,MyGenericList<T> gl) {
		
	    if (gl== null)
	      gl = new MyGenericList<T>(value);
	    
	    else if (value.compareTo(gl.element) <= 0)
	      gl.left = insert(value, gl.left);
	    
	    else if (value.compareTo(gl.element) > 0)
	     gl.right = insert(value, gl.right);
	    
	    else
	      throw new RuntimeException("Duplicate Entry : " + value.toString());
	    return gl;
	  }

	
	public String toString(MyGenericList<T> node)
	{
	    String result = "";
	    if (node == null)
	        return "";
	    else {
	   
	    result += toString(node.left);
	    result += node.element.toString();
	    result += toString(node.right);
	   	    }
	    return result;
	}
	
	  public int value(int steps,MyGenericList<T> yo,T val) {
		  if(yo.left!=null) {
			  steps=value(steps++,yo.left,val);
		  }
		  if(yo.element.compareTo(val)>=0) {
			  return steps;
		  }
		  steps++;
		  if(yo.right!=null) {
			  steps=value(steps++,yo.right,val);
		  }
		return steps;
		  
	  }
}	



public class Lab5 {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		ArrayList<Integer> rollnumber=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		int numTrees=sc.nextInt();
		int numStudents=sc.nextInt();
		String ar[][]=new String[numTrees][2];
		for(int l=1;l<numStudents+1;l++) {
			rollnumber.add(l);
		}
		//BSTFilesBuilder oba=new BSTFilesBuilder();
	//	oba.createBSTFiles(numStudents, numTrees);
		
		for(int j=1;j<=numTrees;j++)
		{
			String sFile="";
			String total ="";
		Scanner infile=new Scanner(new FileReader("C:\\Users\\HP\\Desktop\\AP\\Lab5\\Lab5\\src\\TEST_CASES\\T5\\input\\" +j+".txt"));
	//	Scanner infile=new Scanner(new FileReader("C:\\Users\\HP\\Desktop\\lab5\\TEST_CASES\\T1\\input\\1.txt"));
		while(infile.hasNextLine())
            sFile = sFile + infile.nextLine() + "\n";  
		String arr[]=sFile.split("\\s+");
		

		MyGenericList<String> ob1 = new MyGenericList<String>();
		MyGenericList<Integer> ob2 = new MyGenericList<Integer>();
		MyGenericList<Float> ob3 = new MyGenericList<Float>();
		int steps=1;
		
		
		
		
		if(arr[0].equalsIgnoreCase("String")) {
			for(int k=2;k<numStudents+2;k++) {
				
				ob1.insert(arr[k]);
			}
			
			MyGenericList<String> aa=ob1.get();
			
			steps=ob1.value(steps,aa,aa.element);
			
		}
		
		if(arr[0].equalsIgnoreCase("Integer")) {
			for(int k=2;k<numStudents+2;k++) {
				
				ob2.insert(Integer.parseInt(arr[k]));
			}
		
			MyGenericList<Integer> aa=ob2.get();
			
			steps=ob2.value(steps,aa,aa.element);
	
		}
		
		if(arr[0].equalsIgnoreCase("Float")) {
			for(int k=2;k<numStudents+2;k++) {
				
				ob3.insert(Float.parseFloat(arr[k]));
			}
			MyGenericList<Float> aa=ob3.get();
			
			steps=ob3.value(steps,aa,aa.element);
	
		}
		double add=0;
		String ss="";
		if(arr[0].equalsIgnoreCase("String")){
		   ss=ob1.toString(ob1.get());
		   total=ss;
		}
		else if(arr[0].equalsIgnoreCase("Integer")) {
			for(int k=2;k<numStudents+2;k++) {
				add=add+Double.parseDouble(arr[k]);
			}
			total=String.valueOf((int)add);
		}
		else {
			for(int k=2;k<numStudents+2;k++) {
				add=add+Double.parseDouble(arr[k]);
			}
			total=String.valueOf(add);
		}
		
		ar[j-1][0] = String.valueOf(steps);
		ar[j-1][1] = total;
		}
		for(int o=0;o<ar.length-1;o++) {
			int index=o;
			for(int p=o+1;p<ar.length;p++) {
				if(Integer.parseInt(ar[index][0])>Integer.parseInt(ar[p][0])) {
				index=p;
				}
			}
			String[] temp=ar[index];
			ar[index]=ar[o];
			ar[o]=temp;
		}
		try {
			PrintWriter w = new PrintWriter("./src/" + "answer" + ".txt", "UTF-8");
		String aa="";
		for(int k=0;k<ar.length;k++){
			if(aa.indexOf(ar[k][0])==-1)
			{
				w.print(ar[k][0]+" ");
				aa=aa+ar[k][0];
			}
			w.print(ar[k][1]+" ");
		
		}
		
		int size=0;
		for(int q=0;q<rollnumber.size();q++) {
			for(int r=0;r<ar.length;r++) {
				if(Integer.parseInt(ar[r][0])== rollnumber.get(q)) {
					
					size=size+1;
					break;
				}
						
			}
		}
		
		int siz=rollnumber.size()-size;
		w.println(siz);
		w.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
