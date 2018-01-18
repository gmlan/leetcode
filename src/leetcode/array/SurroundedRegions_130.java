package leetcode.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SurroundedRegions_130 {

	@Test
	public void test(){
		
		char[][]  board = new char[][]{
			{'X','O','X','X'},
			{'X','O','O','X'},
			{'X','X','X','X'},
			{'X','O','X','X'}
		};
		
		solve(board);
	}
	
	 public void solve(char[][] board) {
	        if (board != null && board.length != 0 && board[0].length != 0){
	            
	            for (int i = 0; i < board.length; i++)
	                for (int j = 0; j < board[0].length; j++){
	                    List<String> list = new ArrayList<>();
	                    if (board[i][j] == 'O' && isSurrounded(board,i,j,list)){
	                        //capture(board,i,j);
	                        for (String s : list){
	                            String[] or = s.split(":");
	                            board[Integer.parseInt(or[0])][Integer.parseInt(or[1])] = 'X';
	                        }
	                    }
	                }
	            
	        }
	    }
	    private boolean isSurrounded(char[][] board, int x, int y, List<String> list){
	          
	        // 'O' and reach board, return false;
	        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
	            return false;
	       
	        if (board[x][y] == 'X' || list.contains(x + ":" + y))
	            return true;
	    
	        list.add(x + ":" + y);
	     
	        boolean res = isSurrounded(board, x + 1, y, list) &&
	            isSurrounded(board, x - 1, y, list) &&
	            isSurrounded(board, x, y + 1, list) &&
	            isSurrounded(board, x, y - 1, list);
	        
	        return res;
	    }
}
