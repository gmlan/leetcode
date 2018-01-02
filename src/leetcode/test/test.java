package leetcode.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import leetcodehelper.PrintHelper;

public class test {
//	@Test
//	public void test() {
//		LinkedHashSet<Integer> set = new LinkedHashSet<>();
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		
//		Iterator<Integer> iterator = set.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
//	}
//	
	@Test
	public void test_set() {
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);

		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	
	@Test
	public void test() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		
		PrintHelper.PrintInt(list);
		list.remove(Integer.valueOf(1));
		
		PrintHelper.PrintInt(list);
		 
	}
}
