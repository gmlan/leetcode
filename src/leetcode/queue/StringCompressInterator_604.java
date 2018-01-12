package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class StringCompressInterator_604 {

	@Test
	public void test(){
		StringInterator stringInterator = new StringInterator("a1b2c3d4e1");
		while(stringInterator.hasNext()){
			System.out.println(stringInterator.next());
		}
	}
	
	class StringInterator{
		
		Queue<Character> queue = new LinkedList<>();
		
				
		public StringInterator(String s){
			int prev = -1;
			
			for (int i = 0; i < s.length(); i++){
				char ch = s.charAt(i);
				if (ch >= 'a' && ch <= 'z'){//keep start index
					prev = i;
				}
				else if (i == s.length() - 1 //last one 
						|| (s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z' ) //end of counter
						){
					
					ch = s.charAt(prev);
					int counter = Integer.parseInt(s.substring(prev+1, i + 1));
					for (int j = 0; j < counter; j++)
						queue.offer(ch);
				}
			}
		}
		
		public boolean hasNext(){
			return !queue.isEmpty();
		}
		
		public char next(){
			if(hasNext())
				return queue.poll();
			else
				return ' ';
			
		}
	}
}
