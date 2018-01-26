package leetcode.mapset;

import java.awt.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.event.ListSelectionEvent;

import org.junit.Test;

public class HashMap_Test {

	class Person{
		public int id;
		public String name;
		public Person(int id, String name){
			this.id = id;
			this.name = name;
		}
	}
	
	@Test
	public void TreeMapClass_test()
	{
		System.out.println("TreeMap_test");
		//Map<String, Integer> map = new TreeMap<>();
		Map<Person, Integer> map = new TreeMap<>();
		
		try{
		Comparable<? super Person> comparable = (Comparable<? super Person>) new Person(1, "name");
			
		map.put(new Person(1,"name 1"), 10);
		map.put(new Person(2,"name 2"), 20);
	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		for(Map.Entry<Person, Integer> entry : map.entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
		
		  int[][] m = new int[2][2];

	}
	
	public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int[][] m = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){         
            m[i][i] = nums[i];
            max = Math.max(nums[i],max);
        }
        
        
         
        for (int j = 0; j < nums.length; j++)
            for (int i = 0; i < j; i++){
                m[i][j] = m[i][j - 1] * nums[j];
                max = Math.max(max, m[i][j]);
            }
            
        
        return max;
            
    }
	
	@Test
	public void maxProduct_Test(){
	 	
		
		
	}
	
	@Test
	public void TreeMap_test()
	{
		System.out.println("TreeMap_test");
		//Map<String, Integer> map = new TreeMap<>();
		Map<Integer, Integer> map = new TreeMap<>((a,b)->(b-a));
		
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, 30);
		map.put(4, 40);
		map.put(5, 50);
	
		for(Map.Entry<Integer, Integer> entry : map.entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
	}
	
	
	@Test
	public void LinkedHashMap_Test(){
		System.out.println("LinkedHashMap_Test");
		
		Map<String, Integer> map = new LinkedHashMap<>(4, 0.5f, false);
		map.put("2011-01-07", 20);
		map.put("2011-01-06", 30);
		map.put("2011-01-05", 40);
		map.put("2011-01-04", 50);
		
		map.get("2011-01-06");
	
		for(Map.Entry<String, Integer> entry : map.entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
	}
}
