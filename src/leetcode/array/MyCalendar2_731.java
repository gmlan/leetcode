package leetcode.array;
 
import java.util.*;

import org.junit.Test;

public class MyCalendar2_731 {

	@Test
	public void test(){
		MyCalendarTwo calendarTwo = new MyCalendarTwo();
		
		System.out.println(calendarTwo.book(36,41));
		System.out.println(calendarTwo.book(28,34));
		System.out.println(calendarTwo.book(40,46));
		System.out.println(calendarTwo.book(25,34));
	//	System.out.println(calendarTwo.book(36,44));
		System.out.println(calendarTwo.book(32,40));
		System.out.println(calendarTwo.book(34,39)); 
	}
	
	class MyCalendarTwo { 
		    
		    private List<Event> events = new ArrayList<>();
		    private List<Event> overlaps = new ArrayList<>();
		    
		    private boolean checkOverlap(Event et){
		        for (Event lap : overlaps){
		            if (Math.max(lap.start, et.start) < Math.min(lap.end, et.end)){
		                return false;
		            }
		        }
		        overlaps.add(et);
		        return true;
		    }
		    
		    public boolean book(int start, int end) {
		        Event cur = new Event(start, end);
		        overlaps.clear();
		        for (Event et : events){            
		            Event curlap = new Event(Math.max(cur.start, et.start), Math.min(cur.end, et.end));            
		            if (!checkOverlap(curlap)){
		                return false;
		            }
		        }
		        events.add(cur);
		        return true;
		    }
		    
		    class Event  {
		        public int start;
		        public int end;
		        public Event(int s, int e){
		            this.start = s;
		            this.end = e;
		        }
		    }
		}
	 
	
	class MyCalendarTwo1 {
	    private List<int[]> books = new ArrayList<>();    
	    public boolean book(int s, int e) {
	        MyCalendar overlaps = new MyCalendar();
	        for (int[] b : books)
	            if (Math.max(b[0], s) < Math.min(b[1], e)) // overlap exist
	                if (!overlaps.book(Math.max(b[0], s), Math.min(b[1], e))) return false; // overlaps overlapped
	        books.add(new int[]{ s, e });
	        return true;
	    }

	    private   class MyCalendar {
	        List<int[]> books = new ArrayList<>();
	        public boolean book(int start, int end) {
	            for (int[] b : books)
	                if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
	            books.add(new int[]{ start, end });
	            return true;
	        }
	    }
	}
}
