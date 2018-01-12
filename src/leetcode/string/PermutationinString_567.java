package leetcode.string;

import org.junit.Test;

public class PermutationinString_567 {

	@Test
	public void test(){
		System.out.println(checkInclusion("ab","cba"));
	}
	
	 public boolean checkInclusion(String s1, String s2) {
	        if (s1 == null || s2 == null || s2.length() == 0 || s2.length() < s1.length())
	            return false;
	        
	        if (s1.length() == 0)
	            return true;
	        
	        
	        int[] arr = new int[26];
	        for (char ch : s1.toCharArray())
	            arr[ch - 'a']++;
	        
	        int counter = s1.length();
	        int left = 0, right = 0;
	        
	        for (char ch : s2.toCharArray()){
	           
	            if (arr[ch -'a'] >= 1)
	                counter--;//found a char in s1
	            
	            arr[ch -'a']--;
	            right++;
	                        
	            if (counter == 0)
	                return true;    
	            
	            if (right - left == s1.length() - 1){
		            
	                if (arr[ch -'a'] >= 0){
	                    counter++;//found a char in s1
	                }
	                
	                arr[ch - 'a']++;
	                left++;
	            }
	        }
	        
	        
	        return false;        
	    }
}
