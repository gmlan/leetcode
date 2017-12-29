package leetcode.array;

import org.junit.Test;

public class Search2DMatrix_74 {
	
	@Test
	public void test(){
		int[][] matrix = new int[][]{
			{-10, -8,-8, -8},
			{-5, -4, -2, 0}
		};
		System.out.println(searchMatrix(matrix, 7));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)   
          return false;
      
      
      int row = matrix.length;
      int col = matrix[0].length;
      
      int start = 0;
      int end = row * col - 1;
                   
      while (start <= end) {
          int mid = start +  (end - start) / 2;
          
          if (matrix[mid / col][mid % col] == target){
              return true;
          }
          else if (matrix[mid / col][mid % col] < target){
              start = mid + 1;
          }
          else {
              end = mid - 1;
          }
      }
      
      
      
      return false;
  }
}
