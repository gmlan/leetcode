package leetcode.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

import org.junit.Test;

import leetcode.test.A.B;

public class OuterClass {

	@Test
	public void test(){
		Map.Entry<Integer, Integer> aEntry = new Entry<Integer,Integer>() {
						 
			@Override
			public Integer getValue() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer getKey() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer setValue(Integer arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	/*
	public static void main(String[] args) {
		StaticClass staticClass = new StaticClass();
		staticClass.run();
		
		B b = new B();
		b.run();
		
		A a = new A();
		A.C c = a.new C();
		c.run();
		c.run();
		
		System.out.println(a.name);
		
		new A().new C().run();
	}
	*/
	
	static class StaticClass{
		public void run(){
			System.out.println("StaticClass:run();");
		}
	}
	
	
	@Test
	public void linkedHashSet(){
		LinkedList<Integer> list = new LinkedList<>();
		Stack<Integer> aIntegers = new Stack<>();
		aIntegers.add(1);
		aIntegers.add(2);
		System.out.println(aIntegers.peek());
	}
}


class A{
	String name = "A:name";
	
	static class B{
		public void run(){
			System.out.println("static class : B:run();");			
		}
	}
	
	class C {
		public void run(){
			System.out.println("Inner Class : C:run();");
			System.out.println(name);
			name = "changed name";
		}
	}
}
 