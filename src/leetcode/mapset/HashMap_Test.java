package leetcode.mapset;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

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
