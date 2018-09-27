/**
 * 
 */
package LintCode_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 24663
 * @date 2018年8月21日
 * @Description
 */
public class Subset {
		public static void main(String[] args) {
			Subset subset=new Subset();
			int[] nums={1,2,2 };
			System.out.println(subset.subsets(nums));

		}
//------------------------------------------------------------------------------------------------------------------
		public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> results = new ArrayList<>();
	        if (nums == null) {
	            return results;
	        }
	        if (nums.length == 0) {
	            results.add(new ArrayList<Integer>());
	            return results;
	        }
	        Arrays.sort(nums);
	        helper(new ArrayList<Integer>(), nums, 0, results);
	        return results;
	    }
	    private void helper(ArrayList<Integer> subset,int[] nums,int startIndex,List<List<Integer>> results) {
	    	if (!results.contains(subset)) {
	    		results.add(new ArrayList<Integer>(subset));
			}
	        for (int i = startIndex; i < nums.length; i++) {
	            subset.add(nums[i]);
	            helper(subset, nums, i + 1, results);
	            subset.remove(subset.size() - 1);
	        }
	    }
	    
	    
	    
}
