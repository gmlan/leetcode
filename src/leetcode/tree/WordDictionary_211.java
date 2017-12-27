package leetcode.tree;

import org.junit.Test;
 

public class WordDictionary_211 {
	@Test 
	public void TestCase_211(){
		WordDictionary w = new WordDictionary();
		w.addWord("bad");
		System.out.println(w.search("b.."));
	}
	
	class WordDictionary {
	
	    TireNode root = new TireNode('#');
	    
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        if (word != null) {
	            
	            TireNode cur = root;            
	            char[] chs = word.toCharArray();
	            
	            for (int i = 0 ; i < chs.length; i++) {       
	                char ch = chs[i];
	                if (cur.nodes[ch - 'a'] == null)
	                    cur.nodes[ch - 'a'] = new TireNode(ch);
	                if(i == chs.length - 1)//last one
	                    cur.nodes[ch - 'a'].flag = true;
	                
	                cur = cur.nodes[ch - 'a'];
	            }
	        }        
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return search(word, root);
	    }
	    
	    private boolean search(String word, TireNode node){
	        if (node == null || word == null || word.length() == 0)
	            return false;
	        
	        char ch = word.charAt(0);
	        if (word.length() == 1){
	            if (ch == '.'){
	                for (TireNode n : node.nodes){
	                    if (n != null && node.flag)
	                        return true;
	                }
	                
	                return false;
	            }
	            else{
	                if (node.nodes[ch - 'a'] != null && node.nodes[ch - 'a'].flag)
	                    return true;
	                else
	                    return false;
	            }
	        }
	        else{
	            if (ch == '.'){
	                boolean res = false;
	                
	                for (TireNode n : node.nodes){
	                    if (n != null)
	                        res = res || search(word.substring(1,word.length()), n);
	                }
	                
	                return res;
	            }
	            else{
	                return search(word.substring(1,word.length()), node.nodes[ch - 'a']);
	            }
	        }
	    }
	    
	    class TireNode {
	        public char val;
	        public boolean flag;
	        public TireNode[] nodes;
	        
	        public TireNode(char ch){
	            this.val = ch;
	            nodes = new TireNode[26];
	        }
	    }
	}
}
