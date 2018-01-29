import java.util.*;
import java.util.ArrayList;
import java.math.*;

import javax.swing.plaf.synth.SynthSpinnerUI;
class _creature
{
  String c_name;
  int c_cost;
  int c_asset;
  int  c_power;
  int c_health;
  String type;

  _creature(int ccost,int casset, int cpower, int chealth){
  c_name="";
  c_cost=ccost;
  c_asset=casset;
  c_power=cpower;
  c_health=chealth;
  type="";
 }
  void setname(String aa) {
	  this.c_name=aa;
  }
  void settype(String bb) {
	  this.type=bb;
  }
  
  public String getName() {
		return c_name;
	}
	public void setName(String name) {
		this.c_name = name;
}
	public int getCost() {
		return c_cost;
	}
	public void setCost(int cost) {
		this.c_cost = cost;
	}
	public int getAsset() {
		return c_asset;
	}
	public void setAsset(int asset) {
		this.c_asset = asset;
	}
	public int getPower() {
		return c_power;
	}
	public void setPower(int power) {
		this.c_power = power;
	}
	public int getHealth() {
		return c_health;
	}
	public void setHealth(int health,int damage) {
		this.c_health = health-damage;
	}
	
	
  
}

//human

class _human extends _creature
{	
	String hname="";
   _human(int hcost,int hasset, int hpower, int hhealth)
 {
   super(hcost,hasset,hpower,hhealth);
 }
   
   void setnamehuman(String cc) {
	   this.hname=cc;
 }
   public int combat(int c_power) {
	   Random rn = new Random();
	   int answer = rn.nextInt(c_power);
	   return answer;
   }
}

//daemons

class  _daemons extends _creature
 {
  String daname=" ";
  _daemons(int dacost,int daasset, int dapower, int dahealth)
 {
   super(dacost,daasset,dapower,dahealth);
 }
  
  void setnamedaemon(String bb) {
	  this.daname=bb;
  }
  public int combat(int c_power) {
	   Random rn = new Random();
	   int answer = rn.nextInt(c_power);
	   return answer;
  }
}
// wolf

class _wolf extends _creature
 {
String wname=" ";
_wolf(int wcost,int wasset, int wpower, int whealth)
 {
   super(wcost,wasset,wpower,whealth);
 }
  void setnamewolf(String dd) {
	  this.wname=dd;
  }
  public int combat(int c_power) {
	   Random rn = new Random();
	   int answer = rn.nextInt(c_power);
	   return answer;
  }
}



//firedragon
class _fire_dragon extends _creature
{
String fdrname=" ";
	_fire_dragon(int fdrcost, int fdrasset, int fdrpower, int fdrhealth) {
		super(fdrcost, fdrasset, fdrpower, fdrhealth);
	}
	void setnamefire(String ee) {
		this.fdrname=ee;
	}
	public int combat(int c_power) {
		   Random rn = new Random();
		   int answer = rn.nextInt(c_power);
		   return answer;
	   }

}
//icedragon
class _ice_dragon extends _creature
{
	String idrname=" ";
	_ice_dragon(int idrcost, int idrasset, int idrpower, int idrhealth) {
		super(idrcost, idrasset, idrpower, idrhealth);
		
	}
	void setnameice(String ff) {
		this.idrname=ff;
	}
	public int combat(int c_power) {
		   Random rn = new Random();
		   int answer = rn.nextInt(c_power);
		   return answer;
	   }

}

//-----------------------------------------------------------------------
public class Lab3{
   public  int fight(_creature gb,_creature bb,int round) {
	   
	   int s=gb.c_power;
	   Random rn = new Random();
	   int answer_good = rn.nextInt(s);
	   
	   int t=bb.c_power;
	   Random rn1=new Random();
	   int answer_bad=rn1.nextInt(t);
	   
	   if(gb.type.equalsIgnoreCase("firedragon")) {
		   int aa1=100;
		   Random rns11 = new Random();
		   int lol1 = rns11.nextInt(aa1);
		   if(15>=lol1) {
			   answer_good=answer_good+25;
		 }
	   }
	   
	   if(bb.type.equalsIgnoreCase("daemons")) {
		   int aa=2;
		   Random rns = new Random();
		   int lol = rns.nextInt(aa);
		   if(lol==1) {
			   answer_bad=answer_bad+answer_bad;
		   }
	   }
	   if(bb.type.equalsIgnoreCase("icedragon")) {
		   int aa1=100;
		   Random rns1 = new Random();
		   int lol1 = rns1.nextInt(aa1);
		   if(15>=lol1) {
			   answer_bad=answer_bad+25;
		   }
		   int aa=100;
		   Random rns = new Random();
		   int lola = rns.nextInt(aa);
		   if(5>=lola) {
			   int tt=bb.c_power;
			   Random rn11=new Random();
			   int ad=rn11.nextInt(tt);
			   answer_bad=answer_bad+ad;
		   }
	   }
	   gb.setHealth(gb.c_health,answer_bad);
	   bb.setHealth(bb.c_health,answer_good);
	   
	   int good_de=gb.getHealth();
	   int bad_de=bb.getHealth();
	   
	   if(0>=good_de && 0>=bad_de) {
		   System.out.println("Round draw");
		   return 5;
	   }
	   else if(0>=good_de && bad_de>0) {
		   System.out.println(gb.c_name+"Loses In Round "+round);
		   return 2;
	   }
	   else if(0>=bad_de && good_de>0) {
		   System.out.println(bb.c_name+"Loses In Round -"+round);
		   return 3;
	   }
	   else if(good_de>0 && bad_de>0) {
		   return 4;
	   }
	  
	   else {
		   return 100;
	   }
	   
   }
	//----------------------------------------------------------------------
   public static void main(String[] args) {
   List<_creature> good=new ArrayList <_creature>();
   List<_creature> bad=new ArrayList <_creature>();
   
   Scanner sc=new Scanner(System.in);       
   System.out.println("Enter Team  Good’s total money");  
   int good_money=sc.nextInt();  
   System.out.println("Enter Team Bad’s total money");
   int bad_money=sc.nextInt();

   // human input   
   
  System.out.println("Enter cost, asset , power and health for Human (space-separated) -");
	int h_c=sc.nextInt();
	int h_a=sc.nextInt();
	int h_p=sc.nextInt();
	int h_h=sc.nextInt();   
   
   int min_good=h_c;//min value
   
   //fire dragon
   System.out.println("Enter cost, asset , power and health for Fire Dragon (space-separated) -");
 	int fd_c=sc.nextInt();
 	int fd_a=sc.nextInt();
 	int fd_p=sc.nextInt();
 	int fd_h=sc.nextInt();   
 	
 	
    if(min_good>fd_c) {
    	min_good=fd_c;
    }
    //ice dragon
    System.out.println("Enter cost, asset , power and health for Ice Dragon (space-separated) -");
  	int id_c=sc.nextInt();
  	int id_a=sc.nextInt();
  	int id_p=sc.nextInt();
  	int id_h=sc.nextInt();   
  	
  	int min_bad=id_c;
  // daemon input

 	System.out.println("Enter cost, asset , power and health for Daemon (space-separated) -");
    int d_c=sc.nextInt();
	int d_a=sc.nextInt();
	int d_p=sc.nextInt();
	int d_h=sc.nextInt();   

    if(min_bad>d_c) 
    	min_bad=d_c;
    
  // wolf input

     System.out.println("Enter cost, asset , power and health for Wolf (space-separated) -");
     int w_c=sc.nextInt();
     int w_a=sc.nextInt();
     int w_p=sc.nextInt();
     int w_h=sc.nextInt(); 
     
     	if(min_good>w_c) {
     		min_good=w_c;
     	}



// use a while good_money
while(good_money>=min_good) {
	System.out.println("Select Creatures For Team Good");
	System.out.println("1. Human");
	System.out.println("2. Fire Dragon");
	System.out.println("3. Wolf");
	System.out.println("4. Exit Selection");
	int option_good=sc.nextInt();
	
if  (option_good==1 && good_money>=h_c) 
  { 
    System.out.println("Enter Name Of The Human");
    String name=sc.next();
    _human obj2 =new _human(h_c,h_a,h_p,h_h);
    obj2.setname(name);
    obj2.settype("human");
    good.add(obj2);
    
    good_money=good_money-h_c;

   }
	
else  if  (option_good==2 && good_money>=fd_c) 
  { 
    System.out.println("Enter Name Of The Fire-dragon");
    String name=sc.next(); 
    _fire_dragon obj3 =new _fire_dragon(fd_c,fd_a,fd_p,fd_h);
    obj3.setname(name);
    obj3.settype("firedragon");
    good.add(obj3);
    good_money=good_money-fd_c;
   }
 
else if  (option_good==3 && good_money>=w_c) 
  { 
    System.out.println("Enter Name of the Wolf");
    String name=sc.next(); 
    _wolf obj6 =new _wolf(w_c, w_a , w_p,w_h);
    obj6.setname(name);
    obj6.settype("wolf");
    good.add(obj6);
    good_money=good_money-w_c;
   }

else if  (option_good==4) 
  { 

    break;

   }
else {
	System.out.println("Insufficent Funds/Wrong option");
}

    
 }
//use a while bad_money
while(bad_money>=0 && bad_money>=min_bad) {
	System.out.println("Select Creatures For Team Bad");
	System.out.println("1. Daemon");
	System.out.println("2. Ice Dragon");
	System.out.println("3. Exit Selection");
	int option_bad=sc.nextInt();  
	if  (option_bad==1 && bad_money>=d_c) 
  { 
    System.out.println("Enter Name Of The Daemons");
    String name=sc.next();
    _daemons obj5 =new _daemons(d_c, d_a , d_p , d_h);
    obj5.setname(name);
    obj5.settype("daemons");
    bad.add(obj5);
    bad_money=bad_money-d_c;

   }
	 
	else if  (option_bad==2&& bad_money>=id_c) 
  { 
    System.out.println("Enter Name Of The Ice-Dragon");
    String name=sc.next(); 
    _ice_dragon obj4 =new _ice_dragon(id_c,id_a,id_p,id_h);
    obj4.setname(name);
    obj4.settype("icedragon");
    bad.add(obj4);
    bad_money=bad_money-id_c;
   }

	else if  (option_bad==3) 
  { 
     break;

   }
else {
		  System.out.println("Insufficent Funds/wrong option");
	  }

    
 }
////////////////////////////////////////////////////////////////////////
//############################################################################

int round=1;
System.out.println("The War Begins-");
while(good.size()!=0 && bad.size()!=0) {
	
	System.out.println ("Round"+round);
	System.out.println("Enter Creature from Good’s Team to fight in the war -");
	String names_good=sc.next();
	
	System.out.println("Enter Creature from Bad’s Team to fight in the war -");
	String names_bad=sc.next();
	
	
	_creature good_bhai=null;
	for(int l=0;l<good.size();l++) {
		if(good.get(l).c_name.equals(names_good)) {
			good_bhai=good.get(l);
		
		}
	}

	_creature bad_bhai=null;
	for(int l=0;l<bad.size();l++) {
		if(bad.get(l).c_name.equals(names_bad)) {
			bad_bhai=bad.get(l);
		
		}
	
	}
	Lab3 hl=new Lab3();
	int idk=hl.fight(good_bhai,bad_bhai,round);
	///////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////
	if(idk==2) {
		good.remove(good_bhai);
		round=round+1;
		bad_money=bad_money +bad_bhai.c_asset;
		System.out.println("Money Of Bad’s Team is"+bad_money);
		System.out.println("Money Of Good’s Team is"+good_money);
		while(good_money>=min_good) {
			System.out.println("Select Creatures For Team Good");
			System.out.println("1. Human");
			System.out.println("2. Fire Dragon");
			System.out.println("3. Wolf");
			System.out.println("4. Exit Selection");
			int option_good=sc.nextInt();
			
		if  (option_good==1 && good_money>=h_c) 
		  { 
		    System.out.println("Enter Name Of The Human");
		    String name=sc.next();
		    _human obj2 =new _human(h_c,h_a,h_p,h_h);
		    obj2.setname(name);
		    obj2.settype("human");
		    good.add(obj2);
		    
		    good_money=good_money-h_c;

		   }
			
		else  if  (option_good==2 && good_money>=fd_c) 
		  { 
		    System.out.println("Enter Name Of The fire dragon");
		    String name=sc.next(); 
		    _fire_dragon obj3 =new _fire_dragon(fd_c,fd_a,fd_p,fd_h);
		    obj3.setname(name);
		    obj3.settype("firedragon");
		    good.add(obj3);
		    good_money=good_money-fd_c;
		   }
		 
		else if  (option_good==3 && good_money>=w_c) 
		  { 
		    System.out.println("Enter Name of the wolf");
		    String name=sc.next(); 
		    _wolf obj6 =new _wolf(w_c, w_a , w_p,w_h);
		    obj6.setname(name);
		    obj6.settype("wolf");
		    good.add(obj6);
		    good_money=good_money-w_c;
		   }

		else if  (option_good==4) 
		  { 

		    break;

		   }
		else {
			System.out.println("Insufficent Funds/wrong option");
		}

		    
		 }
		//use a while bad_money
		while(bad_money>=0 && bad_money>=min_bad) {
			System.out.println("Select Creatures For Team Bad");
			System.out.println("1. Daemon");
			System.out.println("2. Ice Dragon");
			System.out.println("3. Exit Selection");
			int option_bad=sc.nextInt();  
			if  (option_bad==1&& bad_money>=d_c) 
		  { 
		    System.out.println("Enter Name Of The Daemons");
		    String name=sc.next();
		    _daemons obj5 =new _daemons(d_c, d_a , d_p , d_h);
		    obj5.setname(name);
		    obj5.settype("daemons");
		    bad.add(obj5);
		    bad_money=bad_money-d_c;

		   }
			 
			else if  (option_bad==2&& bad_money>=id_c) 
		  { 
		    System.out.println("Enter Name Of The Ice Dragon");
		    String name=sc.next(); 
		    _ice_dragon obj4 =new _ice_dragon(id_c,id_a,id_p,id_h);
		    obj4.setname(name);
		    obj4.settype("icedragon");
		    bad.add(obj4);
		    bad_money=bad_money-id_c;
		   }

			else if  (option_bad==3) 
		  { 
		     break;

		   }
		else {
				  System.out.println("Insufficent Funds/wrong option");
			  }

		    
		 }
	}
	////////////////////////////////////
	///////////////////////////////////
	if(idk==3) {
		bad.remove(bad_bhai);
		round=round+1;
		good_money=good_money +good_bhai.c_asset;
		System.out.println("Money Of Good’s Team is"+good_money);
		System.out.println("Money Of Bad’s Team is"+bad_money);
		while(good_money>=min_good) {
			System.out.println("Select Creatures For Team Good");
			System.out.println("1. Human");
			System.out.println("2. Fire Dragon");
			System.out.println("3. Wolf");
			System.out.println("4. Exit Selection");
			int option_good=sc.nextInt();
			
		if  (option_good==1 && good_money>=h_c) 
		  { 
		    System.out.println("Enter Name Of The Human");
		    String name=sc.next();
		    _human obj2 =new _human(h_c,h_a,h_p,h_h);
		    obj2.setname(name);
		    obj2.settype("human");
		    good.add(obj2);
		    
		    good_money=good_money-h_c;

		   }
			
		else  if  (option_good==2 && good_money>=fd_c) 
		  { 
		    System.out.println("Enter Name Of The fire dragon");
		    String name=sc.next(); 
		    _fire_dragon obj3 =new _fire_dragon(fd_c,fd_a,fd_p,fd_h);
		    obj3.setname(name);
		    obj3.settype("firedragon");
		    good.add(obj3);
		    good_money=good_money-fd_c;
		   }
		 
		else if  (option_good==3 && good_money>=w_c) 
		  { 
		    System.out.println("Enter Name of the wolf");
		    String name=sc.next(); 
		    _wolf obj6 =new _wolf(w_c, w_a , w_p,w_h);
		    obj6.setname(name);
		    obj6.settype("wolf");
		    good.add(obj6);
		    good_money=good_money-w_c;
		   }

		else if  (option_good==4) 
		  { 

		    break;

		   }
		else {
			System.out.println("Insufficent Funds/wrong option");
		}

		    
		 }
		//use a while bad_money
		while(bad_money>=0 && bad_money>=min_bad) {
			System.out.println("Select Creatures For Team Bad");
			System.out.println("1. Daemon");
			System.out.println("2. Ice Dragon");
			System.out.println("3. Exit Selection");
			int option_bad=sc.nextInt();  
			if  (option_bad==1&& bad_money>=d_c) 
		  { 
		    System.out.println("Enter Name Of The Daemons");
		    String name=sc.next();
		    _daemons obj5 =new _daemons(d_c, d_a , d_p , d_h);
		    obj5.setname(name);
		    obj5.settype("daemons");
		    bad.add(obj5);
		    bad_money=bad_money-d_c;

		   }
			 
			else if  (option_bad==2&& bad_money>=id_c) 
		  { 
		    System.out.println("Enter Name Of The Ice Dragon");
		    String name=sc.next(); 
		    _ice_dragon obj4 =new _ice_dragon(id_c,id_a,id_p,id_h);
		    obj4.setname(name);
		    obj4.settype("icedragon");
		    bad.add(obj4);
		    bad_money=bad_money-id_c;
		   }

			else if  (option_bad==3) 
		  { 
		     break;

		   }
		else {
				  System.out.println("Insufficent Funds/wrong option");
			  }

		    
		 }
	}
	if(idk==4) {
		System.out.println("Money Of Good’s Team is"+good_money);
		System.out.println("Money Of Bad’s Team is"+bad_money);
		round++;
	}
	if(idk==5) {
		bad.remove(bad_bhai);
		good.remove(good_bhai);
		round=round+1;
		System.out.println("Money Of Good’s Team is"+good_money);
		System.out.println("Money Of Bad’s Team is"+bad_money);
		while(good_money>=min_good) {
			System.out.println("Select Creatures For Team Good");
			System.out.println("1. Human");
			System.out.println("2. Fire Dragon");
			System.out.println("3. Wolf");
			System.out.println("4. Exit Selection");
			int option_good=sc.nextInt();
			
		if  (option_good==1 && good_money>=h_c) 
		  { 
		    System.out.println("Enter Name Of The Human");
		    String name=sc.next();
		    _human obj2 =new _human(h_c,h_a,h_p,h_h);
		    obj2.setname(name);
		    obj2.settype("human");
		    good.add(obj2);
		    
		    good_money=good_money-h_c;

		   }
			
		else  if  (option_good==2 && good_money>=fd_c) 
		  { 
		    System.out.println("Enter Name Of The fire dragon");
		    String name=sc.next(); 
		    _fire_dragon obj3 =new _fire_dragon(fd_c,fd_a,fd_p,fd_h);
		    obj3.setname(name);
		    obj3.settype("firedragon");
		    good.add(obj3);
		    good_money=good_money-fd_c;
		   }
		 
		else if  (option_good==3 && good_money>=w_c) 
		  { 
		    System.out.println("Enter Name of the wolf");
		    String name=sc.next(); 
		    _wolf obj6 =new _wolf(w_c, w_a , w_p,w_h);
		    obj6.setname(name);
		    obj6.settype("wolf");
		    good.add(obj6);
		    good_money=good_money-w_c;
		   }

		else if  (option_good==4) 
		  { 

		    break;

		   }
		else {
			System.out.println("Insufficent Funds/wrong option");
		}

		    
		 }
		//use a while bad_money
		while(bad_money>=0 && bad_money>=min_bad) {
			System.out.println("Select Creatures For Team Bad");
			System.out.println("1. Daemon");
			System.out.println("2. Ice Dragon");
			System.out.println("3. Exit Selection");
			int option_bad=sc.nextInt();  
			if  (option_bad==1 && bad_money>=d_c) 
		  { 
		    System.out.println("Enter Name Of The Daemons");
		    String name=sc.next();
		    _daemons obj5 =new _daemons(d_c, d_a , d_p , d_h);
		    obj5.setname(name);
		    obj5.settype("daemons");
		    bad.add(obj5);
		    bad_money=bad_money-d_c;

		   }
			 
			else if  (option_bad==2&& bad_money>=id_c) 
		  { 
		    System.out.println("Enter Name Of The Ice Dragon");
		    String name=sc.next(); 
		    _ice_dragon obj4 =new _ice_dragon(id_c,id_a,id_p,id_h);
		    obj4.setname(name);
		    obj4.settype("icedragon");
		    bad.add(obj4);
		    bad_money=bad_money-id_c;
		   }

			else if  (option_bad==3) 
		  { 
		     break;

		   }
		else {
				  System.out.println("Insufficent Funds/wrong option");
			  }

		    
		 }
	}
}
int a=good.size();
int b=bad.size();
if(a>0) {
	System.out.println("Team Good wins the war. The money the team has is "+good_money);
}
if(b>0) {
	System.out.println("Team Bad wins the war. The money the team has is "+bad_money);
}
	//int sa=good.indexOf();
	//1System.out.println(sa);
	//System.out.println(good.get(0).c_name);
	//System.out.println(good.get(0).c_cost);
	//System.out.println(good.get(1).c_name);
	}//main()
}  //combat

