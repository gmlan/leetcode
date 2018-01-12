package leetcode.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import leetcode.helper.PrintHelper;

public class ZigzagMatrix {
	
	@Test
	public void test() {
		
		int[][] matrix = new int[][] {
			{ 1, 2, 3, 4},
			{ 7, 8, 9,10},
			{13,14,15,16},
			{17,18,19,20},
			{21,22,23,24}
			};
			
		PrintHelper.PrintInt(traversal(matrix));
		
	}

	private boolean valid(int[][] matrix, int x, int y) {		
		return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
	}
	
	
	private int[] findNextPoint(int[][] matrix, int x, int y) {		
		int resX = 0, resY = 0;
		if (direct) {//From (0,0) -> (1,1)
			if (valid(matrix, x - 1,  y + 1)) {
				resX = x - 1;
				resY = y + 1;
			}
			else{
				if (valid(matrix, x, y + 1)) {//move right first
					resX = x;
					resY = y + 1;				
				}
				else {//move down
					resX = x + 1;
					resY = y;
				}
				
				direct = !direct;
			}
		}
		else { //From (1,1) -> (0,0)
			if (valid(matrix, x + 1, y - 1)) {
				resX = x + 1;
				resY = y - 1;
			}
			else { 
				if (valid(matrix, x + 1, y)) {//move down first
					resX = x + 1;
					resY  = y;
				}
				else {//move right 
					resX = x;
					resY = y + 1;
				}
				
				direct = !direct;				
			}
		}
		
		int[] res = new int[]{resX, resY};
		return res;
		
	}
	
	
	private boolean direct = false;
	
	public List<Integer> traversal(int[][] matrix){
		List<Integer> res = new ArrayList<>();
		if (matrix != null && matrix[0].length != 0) {
			
			int x = 0, y = 0;
				
			res.add(matrix[x][y]);
			
			if (matrix[0].length == 1)
				return res;
			

			y = y + 1;
			res.add(matrix[x][y]); //Add start point (0,1)
			
			while(res.size() < matrix.length * matrix[0].length) {
				int[] pt = findNextPoint(matrix, x, y);
				res.add(matrix[pt[0]][pt[1]]);
				
				x = pt[0];
				y = pt[1];
			}
		}
		
		return res;
	}
}
