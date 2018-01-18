package leetcode.list;

 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
 
import leetcode.helper.PrintHelper;

public class ListToArray {
	@Test
	public void IntegerListToArray(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		
	}
	
	@Test
	public void IntegerArrayToList(){
		PrintHelper.PrintInt(Arrays.asList(1,2,3,4));
	}
	
	@Test
	public void StringListToArray(){
		
		List<String> res = new ArrayList<String>();
		 
		res.add("this");
		res.add(" a ");
		res.add(" test ");
		
		PrintHelper.Print(res);
			
		
		PrintHelper.Print(res.toArray(new String[0]));
	}
	
	@Test
	public void StringArrayToList(){
		
		String[] arr = new String[]{"This ", "is ", "test"};
		PrintHelper.Print(Arrays.asList(arr));
	}
}
