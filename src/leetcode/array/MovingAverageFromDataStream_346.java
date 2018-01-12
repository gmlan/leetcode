package leetcode.array;

import org.junit.Test;

public class MovingAverageFromDataStream_346 {
	@Test
	public void test(){
		MovingAverage movingAverage = new MovingAverage(3);
		System.out.println(movingAverage.next(1));
		System.out.println(movingAverage.next(10));
		System.out.println(movingAverage.next(3));
		System.out.println(movingAverage.next(5));
	}
	
	class MovingAverage{
		
		private int[] arr = null;		
		private int index = 0;
		private int len = 0;
		
		public MovingAverage(int size){
			arr = new int[size];
		}
		
		
		public double next(int val) {
			arr[index++ % arr.length] = val;
		   
			if (len != arr.length)
				len = index;
			
			
			double sum = 0.0;
			for (int n : arr)
				sum += n;
			
			return sum / len;
		}
	}
}
