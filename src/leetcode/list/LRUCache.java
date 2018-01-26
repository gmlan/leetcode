package leetcode.list;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LRUCache {

	@Test
	public void test(){
		  List<Integer> cache = new LinkedList<Integer>();
		  cache.add(1);
		  cache.add(2);
		  
		  System.out.println(cache.get(0));
		  
		  for(int n : cache)
			  System.out.println(n);
	}
	
	 public int Solution(int[] array, int size) {
	        if (array == null)  return 0;
	        List<Integer> cache = new LinkedList<Integer>();
	        int count = 0;
	        for (int i = 0; i < array.length; i++) {
	            if (cache.contains(array[i])) {
	                cache.remove(new Integer(array[i]));
	            }
	            else {
	                count++;
	                if (size == cache.size())
	                    cache.remove(0);
	            }
	            cache.add(array[i]);
	        }
	        return count;
	    }
	 
}
