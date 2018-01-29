import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Comparator;

class World 
{	
	double health;
	int x_position;
	int y_position;
	double timestamp;
	int turn=0;
	World(double health,int x_position,int y_position,double timestamp)
	{
	this.health=health;
	this.x_position=x_position;
	this.y_position=y_position;
	this.timestamp=timestamp;
	}
	
}

abstract class animal extends World implements Comparable<animal>
{
	int type;
	String typer;
	static PriorityQueue<animal> queue=new PriorityQueue<animal>();
	public int compareTo(animal b) {  
	    if(timestamp>b.timestamp){  
	        return 1;  
	    }
	    else if(timestamp<b.timestamp){  
	        return -1;  
	        
	    }
	    else if(timestamp==b.timestamp) {
	    	if(health>b.health) {
	    	return -1;
	    	}
	    	else if(health<b.health) {
	    	return 1;
	    	}
	    	else if(health==b.health) {
	    	
	    	if(type<b.type) {
	    	return 1;
	    	}
	    	else if(type>b.type) {
	    	return -1;
	    	}
	    	else if(type==b.type) {
	    	if(Math.sqrt((x_position*x_position)+(y_position*y_position))>Math.sqrt((b.x_position*b.x_position)+(b.y_position*b.y_position))){
	    	return 1;
	    	}
	    	else {
	    	return -1;
	    	
	    	}
	    	
	    	}
	    	else {
	    	return 0;
	    	}
	    	
	    	}
	    	else {
    	return 0;
    	}
	    }
	    else{  
	    return 0;  
	    }  
	} 

	animal(double health,int x_position,int y_position,double timestamp) {
	super(health, x_position, y_position, timestamp);
	} 
	void settype(int type) {
	this.type=type;
	}
	void settyper(String typer) {
	this.typer=typer;
	}
	void settimestamp(double timestamp) {
	this.timestamp=timestamp;
	}
	void setx(int x) {
	this.x_position=x;
	}
	void sety(int y) {
	this.y_position=y;
	}
	void sethealth(double he) {
	this.health=he;
	}
	public abstract animal turn(animal ani,grassland grass1,grassland grass2);
	
}
class herbivore extends animal
{
	
	double grasscapacity;
	
	herbivore(double health,int x_position,int y_position,double timestamp) {
	super(health, x_position, y_position, timestamp);
	// TODO Auto-generated constructor stub
	}
	
	void setgrasscapacity(double grasscapacity) {
	this.grasscapacity=grasscapacity;
	}
	double getgrasscapacity(){
	return grasscapacity;
	}
	
	public animal turn(animal ani,grassland grass1,grassland grass2) {
	herbivore herb;
	animal animal;
	herb =(herbivore) ani;
	int flag=0;
	int aa=queue.size();
	String oooh=null;
	    PriorityQueue<animal> temp=new PriorityQueue<animal>();

	for(int i=0;i<aa;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("car1")|| animal.typer.equals("car2")) {
	flag=1;
	}
	}
	int siz=temp.size();
	for(int k=0;k<siz;k++) {
	queue.add(temp.remove());
	}
	//carnivores present or not complete
	if(flag==0) {
	//if both carnivore died
	Random rand=new Random();
//case1
	 if((grass1.x_centre-herb.x_position)*(grass1.x_centre-herb.x_position)+(grass1.y_centre-herb.y_position)*(grass1.y_centre-herb.y_position)<=((grass1.radius)*(grass1.radius))) {
	 //it is in grassland1
	 herb.turn=0;
	 int d=5;
	 double dex=grass2.x_centre-herb.x_position;
	 double dey=grass2.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=5*Math.cos(angle);
	 double curry=5*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	 //health
	 herb.sethealth(herb.health-25);
	 
	 }
	 else if((grass2.x_centre-herb.x_position)*(grass2.x_centre-herb.x_position)+(grass2.y_centre-herb.y_position)*(grass2.y_centre-herb.y_position)<=((grass2.radius)*(grass2.radius))) {
	 //it is in grassland2
	 herb.turn=0;
	 int d=5;
	 double dex=grass1.x_centre-herb.x_position;
	 double dey=grass1.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=5*Math.cos(angle);
	 double curry=5*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	 //health
	 herb.sethealth(herb.health-25);
	 }
	 else {
	 herb.turn=herb.turn+1;
	 if((rand.nextInt(2-1)+1)==1) {
	 if(grass1.distance(herb.x_position, herb.y_position)>grass2.distance(herb.x_position, herb.y_position)) {
	 //grass2 nearest
	 int d=5;
	 double dex=grass2.x_centre-herb.x_position;
	 double dey=grass2.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=5*Math.cos(angle);
	 double curry=5*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	 //health
	 }
	 else {
	 //grass1 nearest
	 int d=5;
	 double dex=grass1.x_centre-herb.x_position;
	 double dey=grass1.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=5*Math.cos(angle);
	 double curry=5*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	 //health
	 }
	 }
	 else {
	 //stay
	 //no health change
	 
	 }
	 }
	}
	else {
//case2
	if((grass2.x_centre-herb.x_position)*(grass2.x_centre-herb.x_position)+(grass2.y_centre-herb.y_position)*(grass2.y_centre-herb.y_position)<=((grass2.radius)*(grass2.radius))||(grass1.x_centre-herb.x_position)*(grass1.x_centre-herb.x_position)+(grass1.y_centre-herb.y_position)*(grass1.y_centre-herb.y_position)<=((grass1.radius)*(grass1.radius))) {
	//if it is in grassland
	//(point 4)
	//(case i)
	herb.turn=0;
	if((grass2.x_centre-herb.x_position)*(grass2.x_centre-herb.x_position)+(grass2.y_centre-herb.y_position)*(grass2.y_centre-herb.y_position)<=((grass2.radius)*(grass2.radius))) {
	double gras2=grass2.Grass_Available;
	if(gras2>=herb.grasscapacity) {
	Random rn = new Random();
	int answer = rn.nextInt(100);
	if(answer<90) {
	//stay and eat max;
	if(grass2.Grass_Available>0) {
	herb.sethealth(herb.health+(herb.health*0.5));
	grass2.setgrassavailable(herb.grasscapacity);
	}
	}
	else {
	//doesnt stay
	Random rand=new Random();
	herb.sethealth(herb.health-25);
	 if((rand.nextInt(2-1)+1)==1) {
	herb.sethealth(herb.health-25);
	 if((rand.nextInt(2-1)+1)==1) {
	 //grass1 move
	 int d=3;
	 double dex=grass1.x_centre-herb.x_position;
	 double dey=grass1.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=d*Math.cos(angle);
	 double curry=d*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	 }
	}
	else {
	//away from carnivore
	int aas=queue.size();
	carnivore carni1 = null;
	carnivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("car1")) {
	carni1=(carnivore) animal;
	val1=carni1.setdistance(herb.x_position,herb.y_position);
	}
	else if(animal.typer.equals("car2")) {
	carni2=(carnivore) animal;
	val2=carni2.setdistance(herb.x_position,herb.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else {
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	}
	else if(carni2==null && carni1!=null) {
	//nearest carnivore Carnivore 1
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else{
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	 }
	}
	}
	else {
	//point 4
	//case (b) for grassland 2
	Random rn = new Random();
	int answer = rn.nextInt(100);
	if(answer<20) {
	//stay and eat max;
	if(grass2.Grass_Available>0) {
	herb.sethealth(herb.health+(herb.health*0.2));
	grass2.setgrassavailable(grass2.Grass_Available);
	}
	}
	else {
	Random rn1 = new Random();
	int answer1 = rn1.nextInt(100);
	herb.sethealth(herb.health-25);
	if(answer1<30) {
	//grass1 move
	int d=2;
	 double dex=grass1.x_centre-herb.x_position;
	 double dey=grass1.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=d*Math.cos(angle);
	 double curry=d*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	}
	else {
	//away from carnivore
	int aas=queue.size();
	carnivore carni1 = null;
	carnivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("car1")) {
	carni1=(carnivore) animal;
	val1=carni1.setdistance(herb.x_position,herb.y_position);
	}
	else if(animal.typer.equals("car2")) {
	carni2=(carnivore) animal;
	val2=carni2.setdistance(herb.x_position,herb.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else {
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	}
	else if(carni2==null && carni1!=null) {
	//nearest carnivore Carnivore 1
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else{
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	}
	}
	}
	}
	if((grass1.x_centre-herb.x_position)*(grass1.x_centre-herb.x_position)+(grass1.y_centre-herb.y_position)*(grass1.y_centre-herb.y_position)<=((grass1.radius)*(grass1.radius))) {
	double gras1=grass1.Grass_Available;
	if(gras1>=herb.grasscapacity) {
	Random rn = new Random();
	int answer = rn.nextInt(100);
	if(answer<90) {
	//stay and eat max;
	herb.sethealth(herb.health+(herb.health*0.5));
	grass1.setgrassavailable(herb.grasscapacity);
	}
	else {
	//doesnt stay
	Random rand=new Random();
	herb.sethealth(herb.health-25);
	 if((rand.nextInt(2-1)+1)==1) {
	herb.sethealth(herb.health-25);
	 if((rand.nextInt(2-1)+1)==1) {
	 int d=3;
	 double dex=grass2.x_centre-herb.x_position;
	 double dey=grass2.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=d*Math.cos(angle);
	 double curry=d*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	 }
	}
	else {
	//away from carnivore
	int aas=queue.size();
	carnivore carni1 = null;
	carnivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("car1")) {
	carni1=(carnivore) animal;
	val1=carni1.setdistance(herb.x_position,herb.y_position);
	}
	else if(animal.typer.equals("car2")) {
	carni2=(carnivore) animal;
	val2=carni2.setdistance(herb.x_position,herb.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else {
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	}
	else if(carni2==null && carni1!=null) {
	//nearest carnivore Carnivore 1
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else{
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	 }
	}
	}
	else {
	//point 4
	//case (b) for grassland 1
	Random rn = new Random();
	int answer = rn.nextInt(100);
	if(answer<20) {
	//stay and eat max;
	if(grass1.Grass_Available>0) {
	herb.sethealth(herb.health+(herb.health*0.2));
	grass1.setgrassavailable(grass1.Grass_Available);
	}
	}
	else {
	Random rn1 = new Random();
	int answer1 = rn1.nextInt(100);
	herb.sethealth(herb.health-25);
	if(answer1<30) {
	//grass2 move
	int d=2;
	 double dex=grass2.x_centre-herb.x_position;
	 double dey=grass2.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=d*Math.cos(angle);
	 double curry=d*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	}
	else {
	//away from carnivore
	int aas=queue.size();
	carnivore carni1 = null;
	carnivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("car1")) {
	carni1=(carnivore) animal;
	val1=carni1.setdistance(herb.x_position,herb.y_position);
	}
	else if(animal.typer.equals("car2")) {
	carni2=(carnivore) animal;
	val2=carni2.setdistance(herb.x_position,herb.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else {
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	}
	else if(carni2==null && carni1!=null) {
	//nearest carnivore Carnivore 1
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else{
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	}
	}
	}
	}
	
	
	
	}
	else {
	//if it is not in grassland
	//(point 3)
	herb.turn=herb.turn+1;
	Random rn = new Random();
	int answer = rn.nextInt(100);
	if(answer<5) {
	//stay
	//health ??
	}
	else {
	//distance nearest
	Random rn1 = new Random();
	int oo = rn1.nextInt(100);
	if(oo<65) {
	 if(grass1.distance(herb.x_position, herb.y_position)>grass2.distance(herb.x_position, herb.y_position)) {
	 //grass2 nearest
	 int d=5;
	 double dex=grass2.x_centre-herb.x_position;
	 double dey=grass2.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=5*Math.cos(angle);
	 double curry=5*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	 }
	 else {
	 //grass1 nearest
	 int d=5;
	 double dex=grass1.x_centre-herb.x_position;
	 double dey=grass1.y_centre-herb.y_position;
	 double angle=Math.atan2(dey,dex);
	 double currx=5*Math.cos(angle);
	 double curry=5*Math.sin(angle);
	 int currx1=(int) currx;
	 int curry1=(int) curry;
	 herb.setx(currx1);
	 herb.sety(curry1);
	 }
	}
	else {
	//away from carnivore
	int aas=queue.size();
	carnivore carni1 = null;
	carnivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("car1")) {
	carni1=(carnivore) animal;
	val1=carni1.setdistance(herb.x_position,herb.y_position);
	}
	else if(animal.typer.equals("car2")) {
	carni2=(carnivore) animal;
	val2=carni2.setdistance(herb.x_position,herb.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else {
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	}
	else if(carni2==null && carni1!=null) {
	//nearest carnivore Carnivore 1
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	
	}
	else{
	//nearest carnivore Carnivore 2
	double xh= herb.x_position;
	double yh=herb.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	herb.setx(fx1);
	herb.sety(fy1);
	}
	}
	
	}
	
	}
	
	}
	
	if(herb.turn>=7){
	herb.sethealth(herb.health-5);
	}
	return herb;
	
	
	}
	double setdistance1(int x_position,int y_position) {
	double val=Math.sqrt(((this.x_position -x_position)*(this.x_position-x_position))+((this.y_position -y_position)*(this.y_position -y_position)));
	return val;
	
	}
}
 class carnivore extends animal
{
	carnivore(double health,int x_position,int y_position,double timestamp) {
	super(health, x_position, y_position, timestamp);
	// TODO Auto-generated constructor stub
	}
	double setdistance(int x_position,int y_position) {
	double val=Math.sqrt(((this.x_position -x_position)*(this.x_position-x_position))+((this.y_position -y_position)*(this.y_position -y_position)));
	return val;
	
	}

	public animal turn(animal ani,grassland grass1,grassland grass2) {
	carnivore car;
	car =(carnivore) ani;
	animal animal;
	int flag=0;
	int aa=queue.size();
	    PriorityQueue<animal> temp=new PriorityQueue<animal>();

	for(int i=0;i<aa;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("her1")|| animal.typer.equals("her2")) {
	flag=1;
	}
	}
	int siz=temp.size();
	for(int k=0;k<siz;k++) {
	queue.add(temp.remove());
	}
	//carnivores present or not complete
	//carnivores present or not complete
	if(flag!=0){
	String s="";
	int aas=queue.size();
	herbivore carni1 = null;
	herbivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("her1")) {
	carni1=(herbivore) animal;
	val1=carni1.setdistance1(car.x_position,car.y_position);
	}
	else if(animal.typer.equals("her2")) {
	carni2=(herbivore) animal;
	val2=carni2.setdistance1(car.x_position,car.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	if(Math.sqrt((car.x_position-carni2.x_position)*(car.x_position-carni2.x_position)+(car.y_position-carni2.y_position)*(car.y_position-carni2.y_position))<=1){
	s=carni2.typer;
	car.sethealth(car.health+(carni2.health*2)/3);
	}
	
	}
	else {
	if(Math.sqrt((car.x_position-carni1.x_position)*(car.x_position-carni1.x_position)+(car.y_position-carni1.y_position)*(car.y_position-carni1.y_position))<=1){
	s=carni1.typer;
	car.sethealth(car.health+(carni1.health*2)/3);
	}
	}
	}
	else if(carni1!=null&&carni2==null) {
	if(Math.sqrt((car.x_position-carni1.x_position)*(car.x_position-carni1.x_position)+(car.y_position-carni1.y_position)*(car.y_position-carni1.y_position))<=1){
	s=carni1.typer;
	car.sethealth(car.health+(carni1.health*2)/3);
	}
	
	
	}
	else if(carni1==null&&carni2!=null){
	//nearest herbivore Herbivore 2
	if(Math.sqrt((car.x_position-carni2.x_position)*(car.x_position-carni2.x_position)+(car.y_position-carni2.y_position)*(car.y_position-carni2.y_position))<=1){
	s=carni2.typer;
	car.sethealth(car.health+(carni2.health*2)/3);
	}
	}
	for(animal element:queue){
	if(element.typer.equals(s)){
	queue.remove(element);
	}
	}
	}
	if(flag==0) {
	//if both carnivore died
	Random rand=new Random();
//case1
	 if((grass1.x_centre-car.x_position)*(grass1.x_centre-car.x_position)+(grass1.y_centre-car.y_position)*(grass1.y_centre-car.y_position)<=((grass1.radius)*(grass1.radius))) {
	 //it is in grassland1
	 
	 car.sethealth(car.health-30);
	 }
	 else if((grass2.x_centre-car.x_position)*(grass2.x_centre-car.x_position)+(grass2.y_centre-car.y_position)*(grass2.y_centre-car.y_position)<=((grass2.radius)*(grass2.radius))) {
	 //it is in grassland2
	 car.sethealth(car.health-30);
	 
	 }
	 else {
	car.sethealth(car.health-60);
	 }
	}
	else{
	//if any carnivore is alive
	if((grass1.x_centre-car.x_position)*(grass1.x_centre-car.x_position)+(grass1.y_centre-car.y_position)*(grass1.y_centre-car.y_position)<=((grass1.radius)*(grass1.radius))) {
	//if in grassland1
	Random rand=new Random();
	int value=rand.nextInt(100);
	if(value<25){
	//stay
	car.sethealth(car.health-30);
	}
	else{
	int aas=queue.size();
	herbivore carni1 = null;
	herbivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("her1")) {
	carni1=(herbivore) animal;
	val1=carni1.setdistance1(car.x_position,car.y_position);
	}
	else if(animal.typer.equals("her2")) {
	carni2=(herbivore) animal;
	val2=carni2.setdistance1(car.x_position,car.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	//nearest herbivore Herbivore 2
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	
	}
	else {
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	}
	}
	else if(carni1!=null&&carni2==null) {
	if(val1<val2) {
	//nearest herbivore Herbivore 1
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	}
	}
	else {
	//nearest herbivore Herbivore 2
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	}
	}
	}
	else if((grass2.x_centre-car.x_position)*(grass2.x_centre-car.x_position)+(grass2.y_centre-car.y_position)*(grass2.y_centre-car.y_position)<=((grass2.radius)*(grass2.radius))) {
	//if in grassland 2
	Random rand=new Random();
	int value=rand.nextInt(100);
	if(value<25){
	//stay
	car.sethealth(car.health-30);
	}
	else{
	int aas=queue.size();
	herbivore carni1 = null;
	herbivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("her1")) {
	carni1=(herbivore) animal;
	val1=carni1.setdistance1(car.x_position,car.y_position);
	}
	else if(animal.typer.equals("her2")) {
	carni2=(herbivore) animal;
	val2=carni2.setdistance1(car.x_position,car.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	//nearest herbivore Herbivore 2
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	
	}
	else {
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	}
	}
	else if(carni1!=null&&carni2==null) {
	
	//nearest herbivore Herbivore 1
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	
	}
	else {
	//nearest herbivore Herbivore 2
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=2/(2+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	}
	}
	}
	else{
	//if not in grassland
	Random rand=new Random();
	int value=rand.nextInt(100);
	if(value<8){
	//stay
	car.sethealth(car.health-60);
	}
	else{
	int aas=queue.size();
	herbivore carni1 = null;
	herbivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("her1")) {
	carni1=(herbivore) animal;
	val1=carni1.setdistance1(car.x_position,car.y_position);
	}
	else if(animal.typer.equals("her2")) {
	carni2=(herbivore) animal;
	val2=carni2.setdistance1(car.x_position,car.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	//nearest herbivore Herbivore 2
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	
	}
	else {
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	}
	}
	else if(carni1!=null&&carni2==null) {
	
	//nearest herbivore Herbivore 1
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni1.x_position;
	double yc=carni1.y_position;
	double d= val1;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	
	}
	else {
	//nearest herbivore Herbivore 2
	double xh= car.x_position;
	double yh=car.y_position;
	double xc=carni2.x_position;
	double yc=carni2.y_position;
	double d= val2;//distance
	
	double t=4/(4+d);
	double fx= (xh-(t*xc))/(1-t);
	double fy=(yh-(t*yc))/(1-t);
	int fx1=(int) fx;
	int fy1=(int) fy;
	car.setx(fx1);
	car.sety(fy1);
	}
	}
	}
	}
	if(flag!=0){
	int s=car.turn;
	int aas=queue.size();
	herbivore carni1 = null;
	herbivore carni2 = null;
	double val1=0;
	double val2=0;
	for(int i=0;i<aas;i++) {
	animal=queue.remove();
	temp.add(animal);
	if(animal.typer.equals("her1")) {
	carni1=(herbivore) animal;
	val1=carni1.setdistance1(car.x_position,car.y_position);
	}
	else if(animal.typer.equals("her2")) {
	carni2=(herbivore) animal;
	val2=carni2.setdistance1(car.x_position,car.y_position);
	}
	}
	int sizq=temp.size();
	for(int k=0;k<sizq;k++) {
	queue.add(temp.remove());
	}
	if(carni2!=null && carni1!=null) {
	if(val1>val2) {
	if(Math.sqrt((car.x_position-carni2.x_position)*(car.x_position-carni2.x_position)+(car.y_position-carni2.y_position)*(car.y_position-carni2.y_position))<=5){
	car.turn=car.turn+1;
	}
	
	}
	else {
	if(Math.sqrt((car.x_position-carni1.x_position)*(car.x_position-carni1.x_position)+(car.y_position-carni1.y_position)*(car.y_position-carni1.y_position))<=5){
	car.turn=car.turn+1;
	}
	}
	}
	else if(carni1!=null&&carni2==null) {
	if(Math.sqrt((car.x_position-carni1.x_position)*(car.x_position-carni1.x_position)+(car.y_position-carni1.y_position)*(car.y_position-carni1.y_position))<=5){
	car.turn=car.turn+1;
	}
	
	
	}
	else {
	//nearest herbivore Herbivore 2
	if(Math.sqrt((car.x_position-carni2.x_position)*(car.x_position-carni2.x_position)+(car.y_position-carni2.y_position)*(car.y_position-carni2.y_position))<=5){
	car.turn=car.turn+1;
	}
	}
	if(car.turn==s){
	car.turn=0;
	}
	}
	if(car.turn>=7){
	car.sethealth(car.health-6);
	}
	return car;
	
	
	}
	
}

class grassland{
	double x_centre;
	double y_centre;
	double radius;
	double Grass_Available;
	grassland(double x_centre,double y_centre,double radius,double Grass_Available){
	this.x_centre=x_centre;
	this.y_centre=y_centre;
	this.radius=radius;
	this.Grass_Available=Grass_Available;
	}
	double distance(double x_position,double y_position) {
	double val=Math.sqrt(((this.x_centre-x_position)*(this.x_centre-x_position))+((this.y_centre -y_position)*(this.y_centre -y_position)));
	return val;
	
	}
	void setgrassavailable(double val) {
	this.Grass_Available=this.Grass_Available-val;
	}
	
}




public class Lab4 {
	public static animal ooh;
	
	public void priority(herbivore obj1,herbivore obj2,carnivore obj3,carnivore obj4) {
	ooh.queue.add(obj1);
	ooh.queue.add(obj2);
	ooh.queue.add(obj3);
	ooh.queue.add(obj4);
	
	} 
	public double max() {
	PriorityQueue<animal> temp=new PriorityQueue<animal>();
	int size=ooh.queue.size();
	double lol = 0;
	for(int i=0;i<size;i++) {
	animal ani;
	ani=ooh.queue.remove();
	lol=ani.timestamp;
	temp.add(ani);
	}
	int ss=temp.size();
	for(int j=0;j<ss;j++) {
	ooh.queue.add(temp.remove());
	}
	return lol;
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Total Final Time for Simulation:");
	int time=sc.nextInt();
	System.out.println("Enter x, y centre, radius and Grass Available for First Grassland:");
	
	int x_firstgrass=sc.nextInt();
	int y_firstgrass=sc.nextInt();
	int radius_firstgrass=sc.nextInt();
	double available_firstgrass=sc.nextDouble();
	System.out.println("Enter x, y centre, radius and Grass Available for Second Grassland:");
	
	int x_secondgrass=sc.nextInt();
	int y_secondgrass=sc.nextInt();
	int radius_secondgrass=sc.nextInt();
	double available_secondgrass=sc.nextDouble();
	System.out.println("Enter Health and Grass Capacity for Herbivores:");
	
	double health_herbivores=sc.nextDouble();
	double grass_herbivores=sc.nextDouble();
	System.out.println("Enter x, y position and timestamp for First Herbivore:");
	
	int x_first_herbivore=sc.nextInt();
	int y_first_herbivore=sc.nextInt();
	double timestamp_first_herbivore=sc.nextDouble();
	System.out.println("Enter x, y position and timestamp for Second Herbivore:");
	
	int x_second_herbivore=sc.nextInt();
	int y_second_herbivore=sc.nextInt();
	double timestamp_second_herbivore=sc.nextDouble();
	System.out.println("Enter Health for Carnivores:");
	
	double health_carnivores=sc.nextDouble();
	System.out.println("Enter x, y position and timestamp for First Carnivore:");
	
	int x_first_carnivores=sc.nextInt();
	int y_first_carnivores=sc.nextInt();
	double timestamp_first_carnivores=sc.nextDouble();
	System.out.println("Enter x, y position and timestamp for Second Carnivore:");
	
	int x_second_carnivores=sc.nextInt();
	int y_second_carnivores=sc.nextInt();
	double timestamp_second_carnivores=sc.nextDouble();
	
	herbivore obj1=new herbivore(health_herbivores,x_first_herbivore,y_first_herbivore,timestamp_first_herbivore);
	obj1.setgrasscapacity(grass_herbivores);
	obj1.settype(100);
	obj1.settyper("her1");
	
	herbivore obj2=new herbivore(health_herbivores,x_second_herbivore,y_second_herbivore,timestamp_second_herbivore);
	obj2.setgrasscapacity(grass_herbivores);
	obj2.settype(100);
	obj2.settyper("her2");
	
	carnivore obj3=new carnivore(health_carnivores,x_first_carnivores,y_first_carnivores,timestamp_first_carnivores);
	obj3.settype(0);
	obj3.settyper("car1");
	
	carnivore obj4=new carnivore(health_carnivores,x_second_carnivores,y_second_carnivores,timestamp_second_carnivores);
	obj4.settype(0);
	obj4.settyper("car2");
	
	grassland grass1=new grassland(x_firstgrass,y_firstgrass,radius_firstgrass,available_firstgrass);
	grassland grass2=new grassland(x_secondgrass,y_secondgrass,radius_secondgrass,available_secondgrass);
	Lab4 ob=new Lab4();
	ob.priority(obj1,obj2,obj3,obj4);
	System.out.println("The Simulation Begins -");
	
	
	animal ani;
	animal lol;
	int okay=(int)time;
	int max=(int)ob.max();
	while(time>0 && ooh.queue.size()!=0) {
	ani=ooh.queue.remove();
	if(ani.typer.equals("her1")) {
	
	System.out.println("It is First Herbivore.");
	
	}
	
	else if(ani.typer.equals("her2")) {
	System.out.println("It is Second Herbivore");
	}
	else if(ani.typer.equals("car1")) {
	System.out.println("It is First Carnivore");
	}
	else if(ani.typer.equals("car2")) {
	System.out.println("It is Second Carnivore");
	}
	
	lol=ani.turn(ani,grass1,grass2);
	
	if (lol.health>0 && okay-1>=max) {
	System.out.println("It’s health after taking turn is " + lol.health);
	Random rn=new Random();
	max=rn.nextInt(((okay-max)+1))+max;
	lol.settimestamp(max);
	ooh.queue.add(lol);
	
	}
	else {
	System.out.println("It is dead.");
	}
	time--;
	}
	}
}