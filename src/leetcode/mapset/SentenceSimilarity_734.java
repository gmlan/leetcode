package leetcode.mapset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class SentenceSimilarity_734 {
	@Test
	public void test(){
		String[][] pairs = {
				{"fine","great"},
				{"acting","drama"},
				{"skills", "talent"}
		};
		
		System.out.println(sentenceSimilarity("great acting skills".split(" "), "fine drama talent".split(" "), pairs));
	}
	
	private boolean sentenceSimilarity(String[] a, String[] b, String[][] pairs) {
		if (a == null 
				|| b == null 
				|| a.length == 0 
				|| b.length == 0 
				|| a.length != b.length)
			return false;
		
		Map<String, Set<String>> map = new HashMap<>();
		
		for (int i = 0; i < pairs.length; i++){
			if (!map.containsKey(pairs[i][0]))
				map.put(pairs[i][0], new HashSet<>());
			map.get(pairs[i][0]).add(pairs[i][1]);
		}
		
		for (int  i = 0; i < a.length; i++){
			if (a[i].equals(b[i]))
				continue;
			if (!map.getOrDefault(a[i], new HashSet<>()).contains(b[i])
					&& !map.getOrDefault(b[i],  new HashSet<>()).contains(a[i]))
				return false;
		}
		
		return true;
	}
}
