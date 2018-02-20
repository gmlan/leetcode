package leetcode.test;
 
class Solution {
	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(6);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(8);
	    root.left.left = new TreeNode(0);
	    root.left.right = new TreeNode(4);
	    root.left.right.left = new TreeNode(3);
	    root.left.right.right = new TreeNode(5);
	    
	    root.right = new TreeNode(8);
	    root.right.left = new TreeNode(7);
	    root.right.right = new TreeNode(9);
	    
	    
	    LCAOfBST lca = new LCAOfBST();
	 //   System.out.println(lca.findLCA(root,root.left.right, root.right).val);
	    System.out.println(lca.findLCA(root,root.right.left, root.right.right).val);
	  }
	}

	class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  public TreeNode(int val){
	    this.val = val;
	  }
	}


	class LCAOfBST{

	    TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2){
	      if (n1 == null || n2 == null) return null;
	      
	      if (root == n1) return n1;
	      if (root == n2) return n2;
	      
	      //Both n1 & n2 are not null
	      int mul = (root.val-n1.val) * (root.val - n2.val);
	      if (mul < 0)
	        return root;
	      else if (mul > 0)
	        return findLCA(root.left, n1,n2);
	      else 
	        return findLCA(root.right, n1,n2);      
	      
	    }
	}