package leetcode.string;

import org.junit.Test;

public class CompareVersion_165 {
	
	@Test
	public void test() {
		System.out.println(compareVersion("1.1.1.1", "1.1.1.3"));
		 
	}

	 public int compareVersion(String version1, String version2) {
	        String[] s1 = version1.split("\\.");
	        String[] s2 = version2.split("\\.");
	        
	     //   System.out.println(s1.length);
	     //   System.out.println(s2.length);
	        int i = 0;
	        while (i < s1.length && i < s2.length){
	     //       System.out.println(s1[i] + "  " + s2[i]);
	            if (Integer.valueOf(s1[i]) < Integer.valueOf(s2[i]))
	                return -1;
	            else if (Integer.valueOf(s1[i]) > Integer.valueOf(s2[i]))
	                return 1;           
	            
	            i++;
	        }
	        
	        if (i > s1.length && i > s2.length)
	            return 0;
	        
	        if (i > s1.length)
	            return -1;
	        
	        return 1;
	 }
	
}
