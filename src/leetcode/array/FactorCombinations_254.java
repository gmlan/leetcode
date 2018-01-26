package leetcode.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FactorCombinations_254 {

	@Test
	public void test() {
		factorCombinate(32);
	}

	private List<List<Integer>> factorCombinate(int n) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		traversal(res, new ArrayList<Integer>(), n, 2);
		return res;
	}

	private void traversal(List<List<Integer>> res, List<Integer> tmp, int n, int start) {

		if (n <= 1) {
			if (tmp.size() > 1) {
				for (int t : tmp)
					System.out.print(t + " ");
				System.out.println();
				res.add(new ArrayList<>(tmp));
			}
		}
		
		for (int i = start; i <= n; i++) {
			if (n % i == 0) {
				tmp.add(i);

				traversal(res, tmp, n / i, i);

				tmp.remove(tmp.size() - 1);
			}
		}

	}
}
