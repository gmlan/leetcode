package leetcode.bits;
 

import java.util.*;

import org.junit.Test;
 

public class GrayCode_89 {

	@Test
	public void test() {
		
		Integer aa = 1111;
		Integer bb = 1111;
		
		System.out.println(aa == bb);
		
		int a= 3;
		int b = (a << 1);
		
		System.out.println(b);

		for(Integer n : grayCode(a))
			System.out.println(n);
	}
	
	
	 public List<Integer> grayCode(int n) {
	        List<Integer> res = new ArrayList<>();
	        int x = (1 << n);
	        for (int i = 0; i < x; i++){
	            System.out.println(i);
	        }
	        return res;
	 }
}
