package leetcode.array;

import java.util.*; 

import org.junit.Test;

import leetcodehelper.PrintHelper;

public class PrintHelper_Test {

	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		
		
		set.add("a");
		set.add("b");
		
		for(String s : set)
			System.out.println(s);
		
		list.addAll(set);
		
	
		
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
