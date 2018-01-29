import java.util.concurrent.*;
import java.math.BigInteger;
import java.util.*;
public class triangle extends RecursiveTask<BigInteger>{
	
	public BigInteger compute() {
		if(n.compareTo(new BigInteger("0"))==0||k.compareTo(new BigInteger("0"))==0||n.compareTo(k)==0){
			return new BigInteger("1");
		}
		triangle left=new triangle(this.n.subtract(new BigInteger("1")),this.k.subtract(new BigInteger("1")));
		triangle right=new triangle(this.n.subtract(new BigInteger("1")),this.k);
		left.fork();
		return right.compute().add(left.join());
	}
	
	triangle(BigInteger nn,BigInteger kk){
		n=nn;k=kk;
	}
	
	public BigInteger n,k;
	
	BigInteger recurse(BigInteger n,BigInteger k){
		if(n.compareTo(new BigInteger("0"))==0||k.compareTo(new BigInteger("0"))==0||n.compareTo(k)==0){
			return new BigInteger("1");
		}
		
		BigInteger left=recurse(n.subtract(new BigInteger("1")),this.k.subtract(new BigInteger("1")));
		
		BigInteger right=recurse(n.subtract(new BigInteger("1")),k);
		
		return (left.add(right));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		BigInteger n=sc.nextBigInteger();
		BigInteger k=sc.nextBigInteger();
		
		triangle task3=new triangle(n,k);
		double s = System.currentTimeMillis();
		BigInteger r =task3.recurse(n, k);
		double e   = System.currentTimeMillis();
		double totalTime3 = e - s;
		
		ForkJoinPool pool=new ForkJoinPool(1);
		triangle task=new triangle(n,k);
		double shuru = System.currentTimeMillis();
		BigInteger yo=pool.invoke(task);
		double khatam = System.currentTimeMillis();
		double yolo = khatam - shuru;
		
		System.out.println(yolo/totalTime3);
		System.out.println(yo);
		
		ForkJoinPool pooll=new ForkJoinPool(2);
		triangle taskk=new triangle(n,k);
		double shuruu = System.currentTimeMillis();
		BigInteger yoo=pooll.invoke(taskk);
		double khatamm = System.currentTimeMillis();
		double yoloo = khatamm - shuruu;
		
		System.out.println(yoloo/totalTime3);
		System.out.println(yoo);
		
		ForkJoinPool poolll=new ForkJoinPool(3);
		triangle taskkk=new triangle(n,k);
		double shuruuu = System.currentTimeMillis();
		BigInteger yooo=poolll.invoke(taskkk);
		double khatammm = System.currentTimeMillis();
		double yolooo = khatammm - shuruuu;
		
		System.out.println(yolooo/totalTime3);
		System.out.println(yooo);
		
		System.out.println("Ratio of time for 2nd by 1st Thread pool-");
		System.out.println(yoloo/yolo);
		
		System.out.println("Ratio of time for 3rd by 1st Thread pool-");
		System.out.println(yolooo/yolo);
	}

}