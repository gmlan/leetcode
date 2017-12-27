package leetcode.stack;
import java.util.*;

import org.junit.Test;

public class BaseballGame_682 {
	@Test
	public void test(){
		String[] s  = {"5","2","C","D","+"};
		
		
		System.out.println(calPoints(new String[]{"3","2"}));
		
	}
	
	 public int calPoints(String[] ops) { 
		 Stack<Integer> stack = new Stack<Integer>();
	        
	        int res = 0;
	        
	        for (String s : ops){
	           System.out.println(s == "C");
	            
	           if (s.equals("+")){
	               int top = stack.pop();
	               int tmp = stack.peek() + top;
	               stack.push(top);
	               stack.push(tmp);
	           }
	            else if(s.equals("C")) {
	                stack.pop();
	            }
	            else if (s.equals("D")) {
	                stack.push(2 * stack.peek());
	            }
	            else {
	                stack.push(Integer.parseInt(s));
	            }
	        }
	        
	        
	        while (!stack.isEmpty())
	            res += stack.pop();
	        
	        
	        return res;
	 }
}
