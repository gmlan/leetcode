package leetcode.array;


import org.junit.Test;

import leetcode.helper.PrintHelper;

public class Sorting {

	@Test
	public void test(){
		
		System.out.print("Bubble Sort : ");
		PrintHelper.Print(bubbleSort(new int[]{4,2,5,6,2,9,6,7}));
		
		System.out.print("Insert Sort : ");
		PrintHelper.Print(insertSort(new int[]{4,2,5,6,2,9,6,7}));
		
		System.out.print("Select Sort : ");
		PrintHelper.Print(selectSort(new int[]{4,2,5,6,2,9,6,7}));
		
		System.out.print("Quick Sort : ");
		PrintHelper.Print(quickSort(new int[]{4,2,5,6,2,9,6,7}));
		
		System.out.print("Merge Sort : ");
		PrintHelper.Print(mergeSort(new int[]{4,2,5,6,2,12,2,3,4,5,6,3232,3,329,6,7}));
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	private int[] bubbleSort(int[] nums){		
		for (int i = 0; i < nums.length; i++){
			for (int j = 0; j < nums.length - i - 1; j++){
				if (nums[j] > nums[j + 1])
					swap(nums, j, j + 1);
			}
		}		
		return nums;
	}
	
	private int[] insertSort(int[] nums){		
		for (int i = 0; i < nums.length; i++){				
			int cur = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > cur){
				nums[j+1] = nums[j];
				j--;
			}
			nums[j + 1]  = cur;
		}		
		return nums;
	}
	
	private int[] selectSort(int[] nums){		
		for (int i = 0; i < nums.length; i++){			 
			for (int j = i; j < nums.length; j++){
				if (nums[j] < nums[i]){
					swap(nums, i,j);
				}
			}
		}		
		return nums;
	}
	
	
	/* Begin Quick Sort */
	
	private int[] quickSort(int[] nums) {
	
		partition(nums, 0, nums.length - 1);
		return nums;
	}
	
	private void partition(int[] nums, int low, int high){
		if (low > high)
			return;
		
		int pivot = pivot(nums, low, high);
		partition(nums, low, pivot - 1);
		partition(nums, pivot + 1, high);
	}
	
	private int pivot(int[] nums, int low, int high){
		
		int pivot = high;
		int start = low;
		for (int i = low; i < high; i++){
			if (nums[i] < nums[pivot]){
				swap(nums, i, start++);
			}
		}
		
		swap(nums, start, pivot);
		return start;
	}
	/* End Quick Sort */
	
	
	/* Begin Merge Sort */
	
	private int[] mergeSort(int[] nums) {		
		splitArray(nums, 0, nums.length - 1);
		return nums;
	}
	
	
	private void splitArray(int[] nums, int low, int high){
		if (low >= high)
			return;
		
		int mid = low + (high - low) / 2;
		splitArray(nums, low, mid);
		splitArray(nums, mid + 1, high);		
		mergeArray(nums, low, mid, high);
	}
	
	private void  mergeArray(int[] nums, int low, int mid, int high) {
		int[] helper = new int[high - low + 1];
		
		int i = low, j = mid + 1;
		int index = 0;
		
		while(i <= mid && j <= high){
			if (nums[i] < nums[j]){
				helper[index++] = nums[i++];
			}
			else{
				helper[index++] = nums[j++];
			}
		}
		
		while(i <= mid)
			helper[index++] = nums[i++];
	
		while(j <= high)
			helper[index++] = nums[j++];
		
		
		//from helper to nums
		for (int x = 0; x < helper.length; x++){
			nums[x + low] = helper[x];
		}		
	}
	
	
	/* End Merge Sort */
	
	
}
