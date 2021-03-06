package leetcode.array;

import java.util.*;


import org.junit.Test;

import leetcode.helper.PrintHelper;

public class PrintHelper_Test {

	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		
		Integer[] a = new Integer[]{5,4,3,2,1};
		
		List<Integer> lst = Arrays.asList(a);
		PriorityQueue<Integer> queue  = new PriorityQueue<>(lst);
		System.out.println(queue.poll());
		
	
	 	
	 
	
		
		System.out.print("size():" + list.size());
		PrintHelper.Print(list);
	}
	
	
	@Test
	public void test2() {
	       HashMap<String, List<String>> map = new HashMap<String, List<String>>();
           
	       List<List<String>> res = new ArrayList<List<String>>();
	       
	       PrintHelper.Print(Arrays.asList("this is an apple".split(" ")));
	       res.addAll(map.values());
	}

	    
}
