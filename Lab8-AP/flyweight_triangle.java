import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import javax.swing.plaf.synth.SynthSpinnerUI;
public class flyweight_triangle extends RecursiveTask<BigInteger> {

	private final BigInteger n,k;
	
	private flyweight_triangle(BigInteger n,BigInteger k){
		this.n=n;
		this.k=k;
	}
	
	private static volatile Map<String, flyweight_triangle> instances=new HashMap<String,flyweight_triangle>();

	public static synchronized flyweight_triangle getInstance(BigInteger n,BigInteger k){
		String key=n+","+k;
		if(!instances.containsKey(key)){
			instances.put(key, new flyweight_triangle(n,k));
		}
		return instances.get(key);
	}
	
	public BigInteger compute() {
		if(n.compareTo(new BigInteger("0"))==0||k.compareTo(new BigInteger("0"))==0||n.compareTo(k)==0){
			return new BigInteger("1");
		}
		flyweight_triangle left=getInstance(this.n.subtract(new BigInteger("1")),this.k.subtract(new BigInteger("1")));
		flyweight_triangle right=getInstance(this.n.subtract(new BigInteger("1")),this.k);
		left.fork();
		return right.compute().add(left.join());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		BigInteger n=sc.nextBigInteger();
		BigInteger k=sc.nextBigInteger();
		
		
		ForkJoinPool pool=new ForkJoinPool(1);
		flyweight_triangle task=new flyweight_triangle(n,k);
		double shuru = System.currentTimeMillis();
		BigInteger yo=pool.invoke(task);
		double khatam = System.currentTimeMillis();
		double yolo = khatam - shuru;
		
		System.out.println("Time for 1st Thread pool-" +yolo);
		System.out.println("Value of nck-" +yo);
		
		
		ForkJoinPool pooll=new ForkJoinPool(2);
		flyweight_triangle taskk=new flyweight_triangle(n,k);
		double shuruu = System.currentTimeMillis();
		BigInteger yoo=pooll.invoke(taskk);
		double khatamm = System.currentTimeMillis();
		double yoloo = khatamm - shuruu;
		
		System.out.println("Time for 2nd Thread pool-" +yoloo);
		System.out.println("Value of nck-" +yoo);
		
		ForkJoinPool poolll=new ForkJoinPool(3);
		flyweight_triangle taskkk=new flyweight_triangle(n,k);
		double shuruuu = System.currentTimeMillis();
		BigInteger yooo=poolll.invoke(taskkk);
		double khatammm = System.currentTimeMillis();
		double yolooo = khatammm - shuruuu;
		
		System.out.println("Time for 3rd Thread pool-" +yolooo);
		System.out.println(yolooo);
		System.out.println("Value of nck-" +yooo);
		
		System.out.println("Ratio of time for 2nd by 1st Thread pool-");
		System.out.println(yoloo/yolo);
		
		System.out.println("Ratio of time for 3rd by 1st Thread pool-");
		System.out.println(yolooo/yolo);
	}

}