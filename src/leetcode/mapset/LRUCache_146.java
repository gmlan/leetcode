package leetcode.mapset;

import java.util.*;

import org.junit.Test;

public class LRUCache_146 {

	@Test
	public void test() {
		LRUCache cache  = new LRUCache(1);
		cache.put(2, 1);	
		System.out.println(cache.get(2));
		
		cache.put(3, 2);		
		System.out.println(cache.get(2));
		
		
	}
	
	class LRUCache {

		 Node header = null;
		    Node tail = null;
		
		    
		    
		    Map<Integer, Node> map = new HashMap<Integer, Node>();
		    int capacity;
		    
		    public LRUCache(int capacity) {   
		        this.capacity = capacity;
		        header = new Node(0,0);
		        tail = new Node(0,0);
		        header.next = tail;
		        tail.prev = header;
		    }
		    
		    public int get(int key) {
		        if (map.containsKey(key)) {
		            moveNodeToHead(map.get(key));
		            return map.get(key).val;
		        }
		        
		        return -1;        
		    }
		    
		    
		    public void put(int key, int value) {
		        if (capacity == 0)
		            return;
		        
		        if (map.containsKey(key)){
		            Node node = map.get(key);
		            node.val = value;
		            moveNodeToHead(node);
		        }
		        else{
		            if (map.size() == capacity){
		            	int last = tail.prev.key;
		                removeNode(map.get(last));
		                map.remove(last);
		            }
		            Node node = new Node(key, value);  
		            map.put(key, node);
		            addNodeToHead(node);
		        }
		    }
		    
		    private void moveNodeToHead(Node node){
		        removeNode(node);
		        addNodeToHead(node);
		    }
		    
		    
		    private void addNodeToHead(Node node){
		        node.next = header.next;
		        header.next.prev = node;
		        node.prev = header;
		        header.next = node;
		    }
		    
		    private void removeNode(Node node){
		        Node prev = node.prev;
		        Node next = node.next;
		        
		        prev.next = next;
		        next.prev = prev;
		        node.prev = null;
		        node.next = null;
		    }
		    
	    	    
	}
	
	class Node {
        public Node prev = null, next = null;
        
        public int val;
        public int key;
        
        public Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }
}
