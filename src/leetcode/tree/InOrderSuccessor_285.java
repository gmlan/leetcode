package leetcode.tree;
 
import java.util.Stack;

import org.junit.*;

import leetcode.model.TreeNode;

public class InOrderSuccessor_285 {
	@Test
	public void Run(){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(9);
		
		root.right = new TreeNode(30);
		root.right.left = new TreeNode(20);
		root.right.right = new TreeNode(50);
		root.right.right.right = new TreeNode(60);
		
		System.out.println(successor(root, root.right.left).val);
		System.out.println(successor1(root, root.right.left).val);
	}
	
	private TreeNode successor(TreeNode root, TreeNode target){
		TreeNode res = null;
		while (root != null){
			if (target.val < root.val){
				res = root;
				root = root.left;
			}
			else {
				root = root.right;
			}
		} 
		
		return res;
	}
	
	public TreeNode successor1(TreeNode root, TreeNode target){
		if (root == null)
			return null;
		
		TreeNode res = null;
		
		
		Stack<TreeNode> queue  = new Stack<>();
	 
		TreeNode pre = root;
		
		TreeNode last = null;
		
		while (pre != null || !queue.isEmpty()){
			while (pre != null){
				queue.push(pre);
				pre = pre.left;
			}
			
			TreeNode top = queue.pop();		
			
			if (last != null && last.val == target.val){
				res = top;
			}
			
			last = top;
						
			//System.out.println(top.val);
			pre = top.right;
			
		}
		
	//	System.out.println("----------" + res.val);
		return res;
	}
}
