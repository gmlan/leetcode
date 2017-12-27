package leetcode.model;

public  class TrieNode {
    public boolean isWord;
    public char ch;
    public TrieNode[] childNodes = new TrieNode[26];
    
    public TrieNode(char ch){
        this.isWord = false;
        this.ch = ch;         
    }
    
    
}