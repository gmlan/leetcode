package leetcode.tree;

import org.junit.Test;

import leetcode.model.TrieNode;
 
public class ImplementTrie_208 {

	@Test
	public void test(){
		 Trie obj = new Trie();
		 obj.insert("apple");
		 System.out.println(obj.search("apple"));
		 System.out.println(obj.startsWith("app"));
	}
	

	class Trie {
	    TrieNode root = new TrieNode('#');
	    
	    /** Initialize your data structure here. */
	    public Trie() {
	        
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        insert(root, word);
	    }
	    
	    private void insert(TrieNode node, String word){
	        if(word == null || word.length() == 0)
	            return;
	        
	        if(node.childNodes[word.charAt(0) - 'a'] == null){        
	            node.childNodes[word.charAt(0) - 'a'] = new TrieNode(word.charAt(0));            
	        }
	        
	        if(word.length() == 1)
	            node.childNodes[word.charAt(0) - 'a'].isWord = true;
	        
	        insert(node.childNodes[word.charAt(0) - 'a'], word.substring(1,word.length()));
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {         
	        return search(root, word);
	    }
	    
	    private boolean search(TrieNode node, String word){
	        if(node == null || word == null || word.length() == 0)
	            return false;
	        
	        return (word.length() == 1 
	                && node.childNodes[word.charAt(0) - 'a'] != null 
	                && node.childNodes[word.charAt(0) - 'a'].isWord) 
	            || search(node.childNodes[word.charAt(0) - 'a'], word.substring(1,word.length()));
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        if(root == null || prefix == null || prefix.length() == 0)
	            return false;
	        
	        TrieNode cur = root;
	        for (char ch : prefix.toCharArray()){
	            if (cur.childNodes[ch -'a'] == null)
	                return false;
	            
	            cur = cur.childNodes[ch -'a'];                
	        }
	                
	        return true;
	        
	    }


	    
	}
}
