import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;
class chupa{
	public String[][] messcal(String[] arr,int m){
		String[][] aa=new String[m][];
		float size=m;
		for(int i=0;i<m;i++){
			float as=(size/4);
    		String la=Float.toString(as);
			la=la.concat(" ");
			la=la.concat(arr[i]);
			String[] b = new String[6];
			b=la.split(" ");
			aa[i]=b;
			size--;
		}
		
		return aa;
	}
	public String[][] hotelcal(String[] arr,int m){
		String[][] aa=new String[m][];
		float size=m;
		for(int i=0;i<m;i++){
			float as=(size/5);
    		String la=Float.toString(as);
			la=la.concat(" ");
			la=la.concat(arr[i]);
			String[] b = new String[6];
			b=la.split(" ");
			aa[i]=b;
			size--;
		}
		return aa;
	}
	public String[][] acadcal(String[] arr,int m){
		String[][] aa=new String[m][];
		float size=m;
		for(int i=0;i<m;i++){
			float as=((size*3)/10);
    		String la=Float.toString(as);
			la=la.concat(" ");
			la=la.concat(arr[i]);
			String[] b = new String[6];
			b=la.split(" ");
			aa[i]=b;
			size--;
		}
		return aa;
	}
}
class mess{
   public String[] lol(String[][] mess,int m){
	   for (int i=0; i<m; i++)
		{
			int index=i;
			for (int j=i+1;j<m;j++)
			{
				float as = Float.parseFloat(mess[j][0]);
				float sa = Float.parseFloat(mess[index][0]);
				
				if (as>sa)
					index=j;
				else if(as==sa){
					 if(Float.parseFloat(mess[j][1])>Float.parseFloat(mess[index][1]))
						 index=j;
					 else if(Float.parseFloat(mess[j][1])==Float.parseFloat(mess[index][1])){
						 if(Float.parseFloat(mess[j][2])>Float.parseFloat(mess[index][2]))
							 index=j;
						 else if(Float.parseFloat(mess[j][2])==Float.parseFloat(mess[index][2])){
							 if(Float.parseFloat(mess[j][3])>Float.parseFloat(mess[index][3]))
								 index=j;
						 }
						 
					 }
				}
			}
			String[] flag = mess[index];
			mess[index ] = mess[i];
			mess[i]= flag;
					
		}
	   String[] arr=new String[m];
	   for(int l=0;l<m;l++){
		   arr[l]=mess[l][4];
	   }
	   return arr;
	   
	   }
	   
   
   
   }

  
class library{
    public String[] aver(String[][] library,int m){
    	String[][] array=new String[m][];
    	for(int i=0;i<m;i++){
    		float as = (Float.parseFloat(library[i][0])+Float.parseFloat(library[i][1])+Float.parseFloat(library[i][2]))/3;
    		String la=Float.toString(as);
			la=la.concat(" ");
			la=la.concat(library[i][3]);
			String[] b = new String[6];
			b=la.split(" ");
			array[i]=b;
    		
    	}
    	return sort(array,m);
    	
    }
    public String[] sort(String[][] array,int m){
    	for (int i=0; i<m; i++)
		{
			int index=i;
			for (int j=i+1;j<m;j++)
			{
				float as = Float.parseFloat(array[j][0]);
				float sa = Float.parseFloat(array[index][0]);
				
				if (as>=sa)
					index=j;
			}
			String[] flag = array[index];
			array[index ] = array[i];
			array[i]= flag;
					
		}
    	String[] arr=new String[m];
    	for(int i=0;i<m;i++){
    		arr[i]=array[i][1];
    	}
    	return arr;
    }
}
    
class acadmeics{
	 public String[] ave(String[][] ar,int m){
	    	String[][] array=new String[m][];
	    	for(int i=0;i<m;i++){
	    		float as = (Float.parseFloat(ar[i][0])+Float.parseFloat(ar[i][1])+((Float.parseFloat(ar[i][2]))*2));
	    		String la=Float.toString(as);
				la=la.concat(" ");
				la=la.concat(ar[i][3]);
				String[] b = new String[6];
				b=la.split(" ");
				array[i]=b;
	    		
	    	}
	    	return sort(array,m);
	    	
	    }
	    public String[] sort(String[][] array,int m){
	    	for (int i=0; i<m; i++)
			{
				int index=i;
				for (int j=i+1;j<m;j++)
				{
					float as = Float.parseFloat(array[j][0]);
					float sa = Float.parseFloat(array[index][0]);
					
					if (as>=sa)
						index=j;
				}
				String[] flag = array[index];
				array[index ] = array[i];
				array[i]= flag;
						
			}
	    	String[] arr=new String[m];
	    	for(int i=0;i<m;i++){
	    		arr[i]=array[i][1];
	    	}
	    	return arr;
	    }
}
public class Rank {
	public void sort(String ranks[][],int m){
		 for (int i=0; i<m; i++)
			{
				int index=i;
				for (int j=i+1;j<m;j++)
				{
					float as = Float.parseFloat(ranks[j][0]);
					float sa = Float.parseFloat(ranks[index][0]);
					System.out.println(as);
					if (as>sa){
						index=j;
					}
					else if(as==sa){
						 if(Integer.parseInt(ranks[j][2])>Integer.parseInt(ranks[index][2])){
							 index=j;
							 System.out.println("lol");
							 }
						 else if(Float.parseFloat(ranks[j][2])==Float.parseFloat(ranks[index][2])){
							 if(ranks[j][3].charAt(0)<ranks[index][3].charAt(0))
								 index=j;
							 
							 
						 }
					}
				}
				String[] flag = ranks[index];
				ranks[index ] = ranks[i];
				ranks[i]= flag;
						
			}
		 for(int po=0;po<m;po++){
			 System.out.println(ranks[po][1]);
		 }
	}
	public  void cal(String[][]arraym,String[][] arrayh,String[][] arrayl,String[][] arraya,int m,String[][] rank){
		String[][] ranks=new String[m][];
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				if(rank[i][2].equals(arraym[j][1])){
					String a1 = arraym[j][0];
					String a2 = rank[i][2];
					String a3 = rank[i][0];
					String a4 = rank[i][1];
					String o= a1.concat(" ").concat(a2).concat(" ").concat(a3).concat(" ").concat(a4);
					String[] b = new String[6];
					b=o.split(" ");
					ranks[i]=b;
					
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				if(ranks[i][1].equals(arrayh[j][1])){
					ranks[i][0]=Float.toString(Float.parseFloat(ranks[i][0])+Float.parseFloat(arrayh[j][0]));
				}
			}
		
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				if(ranks[i][1].equals(arrayl[j][1])){
					ranks[i][0]=Float.toString(Float.parseFloat(ranks[i][0])+Float.parseFloat(arrayl[j][0]));
				}
			}
		
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				if(ranks[i][1].equals(arraya[j][1])){
					ranks[i][0]=Float.toString(Float.parseFloat(ranks[i][0])+Float.parseFloat(arraya[j][0]));
				}
			}
		
		}
		sort(ranks,m);
		/*for(int j=0;j<m;j++){
			for(int k=0;k<4;k++){
				System.out.println(ranks[j][k]);
			}
			System.out.println();
		}*/
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		mess obj1=new mess();
		library obj3=new library();
		acadmeics obj4=new acadmeics();
		String[][] rank=new String[m][];
		String[][] mess=new String[m][];
		String[][] hostel=new String[m][];
		String[][] library=new String[m][];
		String[][] acadmeics=new String[m][];
		String[][] fees=new String[m][];
		String[][] naac=new String[m][];
		for(int i=0;i<m;i++){
			String collegename=sc.next();
			
			
			String name1=sc.next();
			String mess1=sc.next();
			mess1+=sc.nextLine();
			mess1=mess1.concat(" ");
			mess1=mess1.concat(collegename);
			String[] b = new String[6];
			b=mess1.split(" ");
			mess[i]=b;
			
			String name2=sc.next();
			String hostel1=sc.next();
			hostel1+=sc.nextLine();
			hostel1=hostel1.concat(" ");
			hostel1=hostel1.concat(collegename);
			String[] c = new String[6];
			c=hostel1.split(" ");
			hostel[i]=c;
			
			String name3=sc.next();
			String lib1=sc.next();
			lib1+=sc.nextLine();
			lib1=lib1.concat(" ");
			lib1=lib1.concat(collegename);
			String[] d = new String[5];
			d=lib1.split(" ");
			library[i]=d;
			
			String name4=sc.next();
			String acad1=sc.next();
			acad1+=sc.nextLine();
			acad1=acad1.concat(" ");
			acad1=acad1.concat(collegename);
			String[] e = new String[5];
			e=acad1.split(" ");
			acadmeics[i]=e;
			
			String name5=sc.next();
			String fe=sc.next();
			String name6=sc.next();
			String name7=sc.next();
			String grade=sc.next();
			fe=fe.concat(" ");
			fe=fe.concat(grade);
			fe=fe.concat(" ");
			fe=fe.concat(collegename);
			String[] f = new String[5];
			f=fe.split(" ");
			rank[i]=f;
			
			
		}
		/*for(int j=0;j<m;j++){
			for(int k=0;k<1;k++){
				System.out.println(naac[j][k]);
			}
			System.out.println();
		}*/
		
		String[] arrm=obj1.lol(mess,m);
		String[] arrh=obj1.lol(hostel, m);
		String[] arrl=obj3.aver(library, m);
		String[] arra=obj4.ave(acadmeics, m);
		chupa obj10=new chupa();
		String mm[][]=obj10.messcal(arrm,m);
		String hh[][]=obj10.hotelcal(arrh,m);
		String ll[][]=obj10.messcal(arrl,m);
		String aa[][]=obj10.acadcal(arra,m);
		Rank ob=new Rank();
		ob.cal(mm,hh,ll,aa,m,rank);
		
	}
	
}

