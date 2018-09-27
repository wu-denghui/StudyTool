package LintCode_1;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.stylesheets.LinkStyle;

/**
 * @author 24663
 * @date 2018年9月13日
 * @Description
 * 给定一个数字列表，返回其所有可能的排列。
 */
public class TI_15 {
	public static void main(String[] args) {
		TI_15 ti_15 = new TI_15();
		int[] nums = { 1,2 };
		System.out.println(ti_15.permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		getAllList(result, nums,new boolean[nums.length],new LinkedList<Integer>());
		return result;
	}
	public void getList(List<List<Integer>> result,LinkedList<Integer> list,int[] nums){
		if (list.size()==nums.length) {
			result.add(new LinkedList<Integer>(list));
			return;
		}
        for (int i : nums) {
			if (!list.contains(i)) {
				list.add(i);
				getList(result, list, nums);
				list.removeLast();
			}
		}
	}
//-------------------------------------------------------------------------------------------------------------------------------------------

	private void getAllList(List<List<Integer>> result, int[] nums, boolean[] visited, LinkedList<Integer> list) {
		if (nums==null) {
			result.add(list);
		}
		if (list.size()==nums.length) {
			result.add(new LinkedList<Integer>(list));
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			list.add(nums[i]);
			visited[i]=true;
			getAllList(result, nums, visited, list);
			visited[i]=false;
			list.removeLast();
		}
	}

}
