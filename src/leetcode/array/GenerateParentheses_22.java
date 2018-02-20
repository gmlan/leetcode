package leetcode.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import leetcode.helper.PrintHelper;

public class GenerateParentheses_22 {

	@Test
	public void test(){
	   PrintHelper.Print(generateParenthesis(3));	
	   System.out.println(Integer.MAX_VALUE);
	   ClassA a = new ClassA();
	   ClassA.StaticPrint();
	   a.InstancePrint();
	   ClassA.StaticPrint();
	   
	 
	   ClassB.run();
	}
	public List<String> generateParenthesis(int n) {
	    List<String> list = new ArrayList<String>();
	    generateOneByOne("", list, n, n);
	    return list;
	}
	public void generateOneByOne(String sublist, List<String> list, int left, int right){
	    if(left > right){
	        return;
	    }
	    if(left > 0){
	        generateOneByOne( sublist + "(" , list, left-1, right);
	    }
	    if(right > 0){
	        generateOneByOne( sublist + ")" , list, left, right-1);
	    }
	    if(left == 0 && right == 0){
	        list.add(sublist);
	        return;
	    }
	}

	
	static class ClassB{
		static void run(){
			
		}
	}
}


class ClassA {
	
	static void StaticPrint(){
		System.out.println("Static Print");
	}
	
	void InstancePrint(){
		System.out.println("Instance Print");
	}
}

