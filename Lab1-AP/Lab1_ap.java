//Suraj Prathik Kumar
//2016101
import java.util.Scanner;

public class Lab1_ap {
	
	//sorting function that sorts according to the distance in descending order
	public String[][] sort(String[][] aa,int q){
		for (int i=0; i<q-1; i++)
		{
			int index=i;
			for (int j=i+1;j<q;j++)
			{
				int as = Integer.parseInt(aa[j][3]);
				int sa = Integer.parseInt(aa[index][3]);
				
				if (sa>=as)
					index=j;
			}
			String[] flag = aa[index];
			aa[index ] = aa[i];
			aa[i]= flag;
					
		}
		String[][] bb=new String[q][]; 
		int a=0;
		for(int j=q-1;j>=0;j--){
			bb[a]=aa[j];
			a++;
		}
		return bb;
		/*for(int k=0;k<q;k++){
			for(int l=0;l<4;l++)
			System.out.print(bb[k][l]+" ");
		System.out.println();
		}*/
		
	}
public void alot(String[][]a,int n,int m){
		int pg1=0;
		int phd1=0;
		int ug1=0;
		//counting the number of pg,phd and ug students
		for(int j=0;j<n;j++){ 
			String s=a[j][2];
			if(s.equalsIgnoreCase("PG"))
				pg1=pg1+1;
			else if(s.equalsIgnoreCase("PhD"))
				phd1=phd1+1;
			else if(s.equalsIgnoreCase("UG"))
				ug1=ug1+1;
		}
	//making new arrays for each
	String[][] pg=new String[pg1][];
	String[][] ug=new String[ug1][];
	String[][] phd=new String[phd1][];
	int pg2=0;
	int ug2=0;
	int phd2=0;
	//Separating the students on the basis of program
	for(int i=0;i<n;i++){
		if(a[i][2].equalsIgnoreCase("PG")){
			
			pg[pg2]=a[i];
			pg2++;
		}
		else if(a[i][2].equalsIgnoreCase("UG")){
			
			ug[ug2]=a[i];
			ug2++;
		}
		else if(a[i][2].equalsIgnoreCase("PhD")){
	
			phd[phd2]=a[i];
			phd2++;
		}
	}
	Lab1_ap ob=new Lab1_ap();//creating object of the class
	//sorting the arrays
	phd=ob.sort(phd,phd1);
	ug=ob.sort(ug,ug1);
	pg=ob.sort(pg,pg1);
	
	String [][] finale=new String[m][];
	String [][] finalf=new String[m][];
	int sd,sdd;
	int count=0,count1=0;
	//diving the number of rooms in halves 
	if(m%2==0)
	{
		sd=m/2;
		sdd=m/2;
	}
	else
	{
		sdd=m/2+1;
		sd=m-sdd;
	}
	//if pg are more than 50%
	if(pg1>=sd)
		{	int c=0;
			for(int q=0;q<sd;q++)
			{
				finale[q]=pg[c];
				count++;
				c++;
			}
		}
	//if pg are less than 50% then ug students allocation 
	else if(pg1<sd)
		{ 
		int c=0;
			for(int q=0;q<pg1;q++)
			{
				finale[q]=pg[c];
				count++;
				c++;
			}
			int cc=sd-pg1;
			int co=0;
			while(ug1!=0 &&cc>0)
			{
				finale[count]=ug[co];
				co++;
				count++;
				cc--;
			}
		}
	//if phd are more than 50%
		if(phd1>=sdd)
		{
			int c=0;
			for(int q=0;q<sdd;q++)
			{
				finalf[q]=phd[c];
				c++;
				count1++;
			}
		}
	//if phd are less than 50% then ug students allocation 
		else if(phd1<sdd)
		{	int c=0;
			for(int q=0;q<phd1;q++)
			{
				finalf[q]=phd[c];
				count1++;
				c++;
			}
			int cc=sdd-phd1;int co=0;
			
			while(ug1!=0 &&cc>0)
			{
				finalf[count1]=ug[co];
				count1++;
				co++;
				cc--;
			}
			
		}
		//making the final array with all the shortlisted people
		String[][] fin=new String[m][];
		int cd=0;
		int coi=0;
		for(int l=0;l<count;l++){
			fin[l]=finale[cd];
			cd++;
			coi++;
		}
		int ds=0;
		for(int l=coi;l<m;l++){
			fin[l]=finalf[ds];
			ds++;
		}
		finalanswer(fin,a);//function call
		
		/*for(int k=0;k<fin.length;k++){
			for(int l=0;l<4;l++)
			System.out.print(fin[k][l]+" ");
		System.out.println();
		}*/
	}
	//function that compares and allocates according to first come first serve basis 
	public void finalanswer(String[][] aa,String[][] bb){
		for(int i=0;i<bb.length;i++){
			for(int j=0;j<aa.length;j++){
				if(bb[i][2]==aa[j][2]){
					for(int k=0;k<4;k++){
					System.out.print(bb[i][k]+ " ");
					}
					System.out.println();
					break;
				}
				
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		//input
		int n= sc.nextInt();
		int m= sc.nextInt();
		String[][] array=new String[n][4];
		
		//creating arrays of arrays
		
		for(int i=0;i<n;i++)
		{
		String la= sc.next();
		la+=sc.nextLine();
		String[] b = new String[4];
		b=la.split(" ");
		array[i]=b; //arrays of arrays
		}
		Lab1_ap ob=new Lab1_ap();//creating object of the class
		ob.alot(array,n,m);//function call and passing the arrays
		
	}
	
}
