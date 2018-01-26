package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
 
import org.junit.Test;

import leetcode.helper.PrintHelper;
import leetcode.model.TreeNode;

public class findLeavesOfBTree_366 {

	@Test
	public void test(){
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		
		
		List<List<Integer>> res = findLeavesOfBTree(root);
		for(List<Integer> r : res)
			PrintHelper.PrintInt(r);
	}
		
	public List<List<Integer>> findLeavesOfBTree(TreeNode node){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		while(node != null){
			List<Integer> list = new ArrayList<>();
			findLeavesOfBTree(node.left, list, null, true);
			findLeavesOfBTree(node.right, list, null, false);
			res.add(list);
			PrintHelper.PrintInt(list);
		}
		
		return res;
	}
	 
	private void findLeavesOfBTree(TreeNode node, List<Integer> res, TreeNode parent, boolean left){
		if (node == null)
			return;
		
		if (node.left == null && node.right == null){
			if (parent != null)
				if (left)
					parent.left = null;
				else 
					parent.right = null;
			
			res.add(node.val);
			return;
		}
		 
		findLeavesOfBTree(node.left, res, node, true);
		findLeavesOfBTree(node.right, res, node, false);
	}
}
