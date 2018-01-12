package leetcode.mapset;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LoggerRateLimiter_359 {
	@Test
	public void test(){
		
		int i = 128;
		int a = i >>> 1;
		
		System.out.println(shouldPrintMessage(1, "foo"));
		System.out.println(shouldPrintMessage(2, "bar"));
		System.out.println(shouldPrintMessage(3, "foo"));
		System.out.println(shouldPrintMessage(8, "bar"));
		System.out.println(shouldPrintMessage(10, "foo"));
		System.out.println(shouldPrintMessage(11, "foo"));
		System.out.println(shouldPrintMessage(11, "foo"));
	}
	
	
	
	private Map<String, Integer> map = new HashMap<>();
	
	
	private boolean shouldPrintMessage(int timespan, String msg){
		if (!map.containsKey(msg) || timespan - map.get(msg) >= 10){
			map.put(msg, timespan);
			return true;
		}
		
		return false;
	}
}
