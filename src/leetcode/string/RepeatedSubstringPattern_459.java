package leetcode.string;

import org.junit.*;

public class RepeatedSubstringPattern_459 {

		@Test
		public void run(){
			System.out.println(repeatedSubstringPattern("asdf"));
		}
		
		
		public boolean repeatedSubstringPattern(String s) {
		        if (s == null || s.length() == 0)
		            return false;
		        
		        for (int i = 1; i <= s.length() / 2; i++){
		            String pattern = s.substring(0,i);
		            
		            if (s.length() % pattern.length() != 0)
		                continue;
		            
		            if (search(s, pattern))
		                return true;
		        }
		        
		        return false;
		}
		    
		    
		    private boolean search(String s, String pattern) {
		        
		        int len = pattern.length();
		        
		        if (s == null || s.length() < len)
		            return false;
		        
		        if (s.length() == len)
		            return s.equals(pattern);
		        
		        
		        return s.substring(0, len).equals(pattern) 
		            && search(s.substring(len,s.length()), pattern);
		        
		    }
}
