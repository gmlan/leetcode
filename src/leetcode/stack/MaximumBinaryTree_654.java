package leetcode.stack;

import java.util.Stack;

import org.junit.Test;

import leetcode.model.TreeNode;

public class MaximumBinaryTree_654 {

	@Test
	public void test(){
		int[] nums = {3,2,1,6,0,5};
		System.out.println(constructMaximumBinaryTree(nums));
	}
	
	 public TreeNode constructMaximumBinaryTree(int[] nums) {
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        
	        for (int n : nums){            
	            TreeNode node = new TreeNode(n);
	            while (!stack.isEmpty() && stack.peek().val < n){
	                node.left = stack.pop();
	            }
	            
	            if (!stack.isEmpty()){
	                stack.peek().right = node;                
	            }
	            
	            stack.push(node);
	        }
	        
	        return stack.peek();
	    }
}
