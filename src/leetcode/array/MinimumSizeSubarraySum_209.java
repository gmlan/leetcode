package leetcode.array;
 
import org.junit.Test;

public class MinimumSizeSubarraySum_209 {

	@Test
	public void test(){
		int[] arr = {2,3,1,2,4,3};
		minSubArrayLen(7, arr);		 
	}
	
   public int minSubArrayLen(int s, int[] nums) {
	        int min = Integer.MAX_VALUE;
	        int start = 0;
	        int sum = 0;
	        for (int i = 0 ; i < nums.length; i++){
	            sum += nums[i];
	            
	            while (sum >= s){
	                min = Math.min(min, i - start + 1);
	                
	                sum -= nums[start++];
	            }
	        }
	        
	        return min == Integer.MAX_VALUE ? 0 : min;
	    }
 
	
}