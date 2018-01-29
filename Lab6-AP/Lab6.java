import java.io.*;
import java.util.*;

class QueenFoundException extends Exception{
	public QueenFoundException(String string1) {
		super(string1);
}
}
class OverlapException extends Exception{
		public OverlapException(String string1) {
			super(string1);
	}
}
class NonCoordinateException extends Exception{
		public NonCoordinateException(String string1) {
			super(string1);
	}

		
}

class knights implements Comparable<knights>
{
	String name="";
	int knight_x;
	int knight_y;
	
	Stack<Object> stack = new Stack<Object>();
	
	public knights(String name,int x,int y) {
		this.name=name;
		this.knight_x=x;
		this.knight_y=y;
	}
	public int compareTo(knights other) {
		return name.compareToIgnoreCase(other.name);
	}
	public void x_set(int x) {
		this.knight_x=x;
	}
	public void y_set(int y) {
		this.knight_y=y;
	}
	public int y_get()
	{
		return knight_y;
	}
	public int x_get() 
	{
		return knight_x;
	}
	
}
abstract class type extends knights
{
	String type="";
	public type(String name, int x, int y,String type) {
		super(name, x, y);
		this.type=type;
	}
	public abstract Object getval();
	
}

class integer extends type{
	int val;
	public integer(String name, int x, int y,String type,int val) {
		super(name, x, y,type);
		this.val=val;
	}
	public Object getval() {
		return val;
	}
	
}
class string extends type{
	String val="";
	public string(String name, int x, int y,String type,String val) {
		super(name, x, y,type);
		this.val=val;
	}
	public Object getval() {
		return val;
	}
	
}

class float1 extends type{
	float val;
	public float1(String name, int x, int y,String type,float val) {
		super(name, x, y,type);
		this.val=val;
	}
	public Object getval() {
		return val;
	}
	
}

class coordinate extends type{
	int x_coordinate;
	int y_coordinate;
	public coordinate(String name, int x, int y,String type,int x_c,int y_c) {
		super(name, x, y,type);
		this.x_coordinate=x_c;
		this.y_coordinate=y_c;
	}
	public void setx(int x) {
		this.x_coordinate=x;
	}
	public void sety(int y) {
		this.y_coordinate=y;
	}
	public Object getval() {
		return x_coordinate + " " + y_coordinate;
		
	}
	
	
}


public class Lab6 
{
	

	static void check(PrintWriter w,knights k,type l,int iter)throws NonCoordinateException
	{
		coordinate co;
		
		if(l.type.equals("Coordinate"))
		{
			co=(coordinate) l;
			//System.out.println(iter + " "+k.name+" "+k.knight_x +" "+k.knight_y);
			
			k.x_set(co.x_coordinate);
			k.y_set(co.y_coordinate);
			
			w.println("No exception "+" "+k.knight_x+" "+k.knight_y);
		}
		else {
			w.println(iter + " "+k.name+" "+k.knight_x+" "+k.knight_y);
			throw new NonCoordinateException ("NonCoordinateException: Not a coordinate Exception "+l.getval());
		}
	}
	
	static void check2(PrintWriter w,int x,int xx,int y,int yy)throws OverlapException {
		if(x==xx&&y==yy) {
			throw new OverlapException("OverlapException:​ ​Knights​ ​Overlap​ ​Exception ");
		}
	}
	
	static void check3(PrintWriter w,int x,int xx,int y,int yy)throws QueenFoundException {
		if(x==xx&&y==yy) {
			throw new QueenFoundException("QueenFoundException:​ ​Queen​ ​has​ ​been​ ​Found.​ ​Abort!");
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		// TODO Auto-generated method stub
		ArrayList<knights> list=new ArrayList<>();
		PrintWriter w=new  PrintWriter("Output1.txt" , "UTF-8");
		
		Scanner sc=new Scanner(System.in);
		
		int num_knights=sc.nextInt();
		int iterations=sc.nextInt();
		int queen_x=sc.nextInt();
		int queen_y=sc.nextInt();
		int k=0;
		
		for(int i=1;i<4;i++) 
		{
		String sFile="";
		Scanner infile=new Scanner(new FileReader("C:\\Users\\HP\\Desktop\\AP\\Lab6\\src\\Test Case\\Input\\"+i+".txt"));
		while(infile.hasNextLine())
        sFile = sFile + infile.nextLine() + "\n";  
		String arr[]=sFile.split("\n");
		
		String name=arr[0];
		String arr1[]=arr[1].split(" ");
		
		int x=Integer.parseInt(arr1[0]);
		int y=Integer.parseInt(arr1[1]);
		
		
		int push=Integer.parseInt(arr[2]);
		knights ob1 = new knights(name, x,y);
		for(int j=0;j<push;j++)
		{
			
			String okay=arr[3+j];
			String aa[]=okay.split(" ");
			if(aa[0].equals("Integer")) 
			{
				int val=Integer.parseInt(aa[1]);
				integer ob=new integer(name,x,y,"Integer", val);
				ob1.stack.push(ob);
			}
			else if(aa[0].equals("String")) 
			{
				String val=aa[1];
				string ob=new string(name,x,y,"String", val);
				ob1.stack.push(ob);
		    }
			else if(aa[0].equals("Float")) 
			{
				float val=Float.parseFloat( aa[1]);
				float1 ob=new float1(name,x,y,"Float", val);
				ob1.stack.push(ob);
		    }
			else if(aa[0].equals("Coordinate"))
			{
				int x_move=Integer.parseInt(aa[1]);
				int y_move=Integer.parseInt(aa[2]);
				coordinate ob=new coordinate(name, x, y,"Coordinate", x_move, y_move);
				ob1.stack.push(ob);
			}
		
		}
		
		list.add(ob1);
		}
		
		Collections.sort(list);
		type ok;
		coordinate cas;
		int a=1;
		String na="";
		int lt=0;
		int xx=0;
		int yy=0;
		while(a<=iterations && list.size()!=0 )
		{
			try {
				int ll=0;
			for(k=0;k<list.size();k++) 
			{
				try {
					ok=(type) list.get(k).stack.pop();
				
					if(ok.type.equals("Coordinate")) {
					cas=(coordinate) ok;
					w.println(a + " "+list.get(k).name+" "+list.get(k).knight_x +" "+list.get(k).knight_y);
					xx=cas.x_coordinate;
					yy=cas.y_coordinate;
					for( ll=0;ll<list.size();ll++) 
					{
						na=list.get(ll).name;
						lt=ll;
						check2(w,xx,list.get(ll).knight_x,yy,list.get(ll).knight_y);
					}
					}
					check3(w,xx,queen_x,yy,queen_y);
					check(w,list.get(k),ok,a);
					
					
				
				}
				catch(NonCoordinateException e)	{	
					w.println(e.getMessage());	
				}
				catch(OverlapException e) {
					w.print(e.getMessage());
					list.get(k).knight_x=xx;
					list.get(k).knight_y=yy;
					w.println(na);
					list.remove(lt);
				}
				catch(QueenFoundException e) {
					w.print(e.getMessage());
					iterations=0;
					break;
				}
				catch(EmptyStackException e) 
				{
					w.println(a + " "+list.get(k).name+" "+list.get(k).knight_x +" "+list.get(k).knight_y);
					w.println("StackEmptyException: Stack Empty exception");
					list.remove(k);
				}
				
			}
			
			a++;
			}
			catch(Exception e){
				
			}
			
			
		}
		w.close();
    }
}
