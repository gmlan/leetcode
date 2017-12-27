package leetcode.array;
import org.junit.*;
import java.util.*;

public class SetMismatch_645 {

	@Test
	public void test(){
		 HashMap<Integer, Integer> map = new HashMap<>();
		 
	}
	
	
    public int[] findErrorNums(int[] nums) {
        
        for (int i = 0 ; i < nums.length; i++){
            while (nums[i] != nums[nums[i] - 1]){
                int tmp = nums[i];
                nums[i]  = nums[nums[i] - 1];
                nums[nums[i] - 1] = tmp;
            }
        }
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i + 1){
                return new int[]{nums[i], i+1};
            }
        }
        return new int[2];
    }
}
