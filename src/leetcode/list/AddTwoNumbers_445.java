package leetcode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import leetcode.model.ListNode;

public class AddTwoNumbers_445 {
	@Test
	public void test(){
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode res = addTwoNumbers(l1, l2);
	}
	
	@Test
	public void listToArray(){
		List<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list.stream().mapToInt(i->i).toArray());
	}
	
	  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        if (l1 == null) 
	            return l2;
	        if (l2 == null)
	            return l1;
	        
	        int len1 = getDepth(l1);
	        int len2 = getDepth(l2);
	        
	        int max = Math.max(len1, len2);
	        
	        ListNode t1 = addLength(l1, max - len1);
	        ListNode t2 = addLength(l2, max - len2);
	        
	        //Now t1 & t2 has the same length
	        
	        ListNode res = merge(t1, t2);
	        
	        
	        if (carry == 1){
	            ListNode head = new ListNode(1);
	            head.next = res;
	            res = head;
	        }
	        
	        return res;
	    }
	    
	    private int carry = 0;
	    
	    private ListNode merge(ListNode n1, ListNode n2){
	        if (n1 == null && n2 == null)
	            return null;
	        
	        int total = n1.val + n2.val + carry;        
	        
	        ListNode res = new ListNode(total % 10);
	        res.next = merge(n1.next, n2.next);
	        
	        carry = carry / 10;
	        
	        return res;        
	    }
	    
	    private ListNode addLength(ListNode node, int len){
	        if (len == 0)
	            return node;
	        
	        ListNode cur = node;
	        while (len > 0){            
	            ListNode tmp = new ListNode(0);
	            tmp.next = cur;
	            cur = tmp;            
	            len--;
	        }
	        return cur;
	    }
	    
	    private int getDepth(ListNode node){
	        int len = 0;
	        
	        while (node != null){
	            len++;
	            node = node.next;
	        }
	        
	        return len;
	    }
}
