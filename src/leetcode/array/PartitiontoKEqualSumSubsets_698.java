package leetcode.array;

import java.util.Arrays;

import org.junit.Test;

public class PartitiontoKEqualSumSubsets_698 {
	
	@Test
	public void test(){
		System.out.println(canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
	}
	
	 public boolean canPartitionKSubsets(int[] nums, int k) {
	        if (nums == null || nums.length == 0)   
	            return false;
	        
	        int sum = 0;
	        for (int n : nums)
	            sum += n;
	        
	        if (sum % k != 0)
	            return false;
	        
	        int subSum = sum / k;
	        Arrays.sort(nums);
	        
	        
	       int n = nums.length - 1;
	       if (nums[n] > subSum)
	            return false;
	               
	        while (n >= 0 && nums[n] == subSum){
	            n--;
	            k--;
	        }
	         
	        
	        
	        return partition(new int[k], nums, n, subSum);
	    }
	    
	    
	    private boolean partition(int[] subSets, int[] nums, int index, int target){
	        if (index < 0)
	            return true;
	        
	        int selected = nums[index];
 	        for (int i = 0; i < subSets.length; i++){
	            if (subSets[i] + selected <= target){
	                subSets[i] += selected;
	                if (partition(subSets, nums, index - 1, target)){
	                    return true;
	                }
	                subSets[i] -= selected;
	            }
	        }
	        
	        return false;
	    }
}
