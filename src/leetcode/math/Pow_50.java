package leetcode.math;

import java.util.HashMap;

import org.junit.Test;

public class Pow_50 {

	@Test
	public void test(){
	    System.out.println("abcd".substring(1,2));
		
		Pow p = new Pow();
		long a = Integer.MIN_VALUE;
		a = -a;
		System.out.println(p.myPow(2, Integer.MIN_VALUE));
	}
	
	
	class Pow {
	    public double myPow(double x, long n) {
	        if(n == 0  || x == 1)
	            return 1;
	        
	        if(n == 1)
	            return x;
	        
	        if(n < 0)
	            return 1.0 / pow(x,-1*n);
	        
	        return pow(x,n);
	    }
	    
	    private HashMap<Long, Double> map = new HashMap<>();
	    
	    /// n > 0 only
	    private double pow(double x, long l){
	        if(l == 1) return x;
	        
	        if(map.containsKey(l))
	            return map.get(l);
	        
	        double res =  pow(x, l/2)*pow(x, l/2);
	        if(l%2 != 0)
	             res *= x;
	        
	        map.put(l, res);
	        
	        return res;
	    }
	}
}
