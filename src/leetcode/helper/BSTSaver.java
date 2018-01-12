package leetcode.helper;
 

import leetcode.model.TreeNode;

public class BSTSaver {

	public static class innerStaticClass{
		
	}
	
	class innerClass{
		
	}
	
	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
        
    	if(root == null)
    		return "";
    	
    	StringBuilder sBuilder = new StringBuilder();
    	sBuilder.append(root.val);
    	
    	if (root.left != null || root.right != null) {    		
    		sBuilder.append("(");
    		sBuilder.append(serialize(root.left));
    		sBuilder.append(")");
    		
    		if(root.right != null) {
    			sBuilder.append("(");
        		sBuilder.append(serialize(root.right));
        		sBuilder.append(")");        		
    		}
    	}
    	
    	return sBuilder.toString();
    }
 
    
    public static TreeNode deserialize(String data) {
    	return internalDeserialize(data, new Counter());
    }
    
    
    // Decodes your encoded data to tree.
    private static TreeNode internalDeserialize(String data, Counter counter) {
        if (data == null || data.length() == 0 || counter.val == data.length())
        	return null;
        
        StringBuilder sBuilder = new StringBuilder();
        while(counter.val < data.length()){
        	char tmp = data.charAt(counter.val);
        	if (tmp != '(' && tmp != ')') {
        		sBuilder.append(tmp);
        		counter.val++;
        	}
        	else {
        		break;
        	}
        } 
        
        TreeNode root = null;
        if(sBuilder.toString().length() != 0)
        {
        	root = new TreeNode(Integer.parseInt(sBuilder.toString()));
	        
	        if (counter.val < data.length() && data.charAt(counter.val)=='(') {
	        	counter.val++;
	        	root.left = internalDeserialize(data,counter);	        	
	        	counter.val++;
	        	
	        	if (counter.val < data.length() && data.charAt(counter.val)=='(') {
	        	
	        		counter.val++;
	        		root.right = internalDeserialize(data,counter);
	        		counter.val++;
	        	}
	        }
        }
    	return root;
    }
}

class Counter {
	public int val;
}

