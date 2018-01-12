package leetcode.tree;

import java.util.Stack;
import org.junit.Test;

import leetcode.model.TreeNode;

public class LargestBSTSubtree_333 {
	@Test
	public void test(){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		
		root.right = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
	//	System.out.println(traversal(root).count);
		
		
		System.out.println(largetsBSTSubTree(root));
	}
	
	
	public int largetsBSTSubTree(TreeNode root) {
		if (root == null)
			return 0;
		
		CheckResult left = traversal(root.left);
		CheckResult right = traversal(root.right);
		
		if (left.isBST && right.isBST){
			return Math.max(left.count, right.count);
		}
		else if (left.isBST){//left is not BST only
			return Math.max(largetsBSTSubTree(root.right), left.count);
		}
		else if (right.isBST){//right is BST only
			return Math.max(largetsBSTSubTree(root.left), right.count);
		}
		else{//left and right are both not BST
			return Math.max(largetsBSTSubTree(root.left), largetsBSTSubTree(root.right));
		}
	}
	
	
	private CheckResult traversal(TreeNode root){
		if (root == null)
			return new CheckResult(false, 0);
		
		TreeNode pre = null;
		boolean isBST = true;
		int counter = 0;

		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<>();
		while (cur != null || !stack.isEmpty()) {			
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			
			TreeNode top = stack.pop();
			counter++;						
			if (isBST && pre != null && pre.val >= top.val){
				isBST = false;
			}
			
			pre = top;			
			cur = top.right;			
		}
		
		
		
		return new CheckResult(isBST, counter);
	}
	
	
	
	class CheckResult {
		public boolean isBST;
		public int count;
		
		public CheckResult(boolean isBST, int count){
			this.isBST = isBST;
			this.count  = count;
		}
	}
}
