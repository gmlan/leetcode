package leetcode.tree;

import org.junit.Test;

import leetcode.model.TreeNode;
import leetcodehelper.BSTSaver;

public class ClosestBinarySearchTreeValue_270 {
	
	class Counter{
		public int val;
	}
	
	@Test 
	public void test3() {
		Counter counter = new Counter();
		counter.val = 1;
		System.out.println("Out Increase : " + counter.val);
		increase(counter);
		System.out.println("Out Increase : " + counter.val);
	}
	
	private void increase(Counter counter) {
		counter.val++;
		System.out.println("In Increase : " + counter.val);
	}
	
	@Test
	public void test(){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(8);
		
		
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(18);
	//	root.right.right.right = new TreeNode(38);
		
	//	System.out.println(new BSTSaver().serialize(root));
		
		
		
	//	TreeNode aNode = new BSTSaver().deserialize("10(5(1)(9(8)))(15(12)(18))");
		
		
	//	System.out.println(ClosestBinarySearchTreeValue(aNode, 14));
		

		TreeNode aNode = BSTSaver.deserialize("5(3()(4))(6)");		
		System.out.println(ClosestBinarySearchTreeValue(aNode, 2));
	}
	
	@Test
	public void test2(){
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(4);	
		root.left.right.left = new TreeNode(10);	
		root.right = new TreeNode(60);
		String tmp = BSTSaver.serialize(root);
		System.out.println(tmp);
		
		TreeNode node = BSTSaver.deserialize(tmp);
		
		System.out.println(BSTSaver.serialize(node));
		
	//	TreeNode aNode = new BSTSaver().deserialize("10(5(1)(9(8)))(15(12)(18))");
		
		
	//	System.out.println(ClosestBinarySearchTreeValue(aNode, 14));
		

	//	TreeNode aNode = new BSTSaver().deserialize("5(3()(4))(6)");		
	//	System.out.println(ClosestBinarySearchTreeValue(aNode, 2));
	}
	
	private int ClosestBinarySearchTreeValue(TreeNode node, int target) {
		
		traversal(node, target);
		return res;
	}
	
	private void traversal(TreeNode node, int target) {
		if (node == null)
			return;
		
		int tmp = Math.abs(target - node.val);
		if (tmp < min) {
			min = tmp;
			res = node.val;
		}
		
		if (target < node.val)
			traversal(node.left, target);
		else {
			traversal(node.right, target);
		}
	}
	
	private int min = Integer.MAX_VALUE;
	private int res = 0 ;
}
