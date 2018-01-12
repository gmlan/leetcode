package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class NumberConnectedComponentsUndirectedGraph_323 {

	@Test
	public void test(){
	/*	int[][] edges = {
				{0,1},
				{1,2},
				{3,4}
		};*/
		
		int[][] edges = {
				{0,1},
			 
				
		};
		
		System.out.println(countComponents(edges, 5));
	}
	
	private int countComponents(int[][] edges, int n){
		HashMap<Integer, Set<Integer>> map = new HashMap<>();
		
		Set<Integer> visited = new HashSet<>();		
		int count = 0;		
		for (int i = 0 ; i < n; i++)
			map.put(i, new HashSet<>());
		
		for(int i = 0; i < edges.length; i++){	
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);
		}
		
		
		for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
			if (!visited.contains(entry.getKey())){
				count++;
				traversal(visited, map, entry.getKey());
			}
		}
		
		
		return count;
	}
	
	private void traversal(Set<Integer> visited, HashMap<Integer, Set<Integer>> map, int node){
		if (visited.contains(node))
			return;
		
		visited.add(node);
		for(Integer n : map.get(node))
			traversal(visited, map, n);
	}
}
