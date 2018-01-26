package leetcode.queue;

import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.junit.Test;

public class PriorityQueue_TestCase {
	

	@Test
	public void Kth_Largest_Element_In_An_Array(){
		/*PriorityQueue<Integer> queue = new PriorityQueue();

		queue.offer(50);
		queue.offer(10);
		queue.offer(30);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}*/
		
		 // Creating empty priority queue
        PriorityQueue<String> pQueue =
                          new PriorityQueue<String>();
 
        // Adding items to the pQueue
        pQueue.add("Java");
        pQueue.add("Python");
        pQueue.add("C");
        pQueue.add("C++");
 
        // Printing the most priority element
        System.out.println("Head value using peek function:"
                                           + pQueue.peek());
 
        // Printing all elements
        System.out.println("The queue elements:");
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
	}
	
	@Test
	public void test(){
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->(a-b));
	}
}
