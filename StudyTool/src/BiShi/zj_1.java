/**
 * 
 */
package BiShi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年9月9日
 * @Description 无重复字符的最大子字符串
 */
public class zj_1 {
	public static void main(String[] args) {
		
		String str="ababcdeef";
		System.out.println(str.substring(2, 6).contains("g"));
	}
	
	public int getMaxc(String str){
		LinkedList<Character> list = new LinkedList<Character>();
		//前i个字符中无重复字符的最大子字符串
		int[] f=new int[str.length()+1];
		f[0]=0;
		f[1]=1;
		for (int i = 1; i < f.length; i++) {
			list.add(str.charAt(i-1));
				if (!list.contains(str.charAt(i-1))) {
					f[i]=f[i-1]+1;
				}else{
					int temp=f[i-1];
					if (isContains(list,temp)) {
						f[i]=f[i-1];
					}else{
						f[i]=f[i-1]+1;
					}
				}
			}
		return f[str.length()];
		
		
	}
	/**
	 * @param list
	 * @param temp
	 * @return
	 * @Description 
	 */
	public boolean isContains(LinkedList<Character> list, int temp) {
		return false;
	}
	public int getMax(String string) {
		int max = 0;
		if (string == null) {
			return max;
		}
		if (string.length() == 1) {
			return 1;
		} else {
			List<Character> list = new LinkedList<Character>();
			for (int i = 0; i < string.length(); i++) {
				for (int j = i; j < string.length(); j++) {
					if (!list.contains(string.charAt(j))) {
						list.add(string.charAt(j));
					} else {
						max = Math.max(max, list.size());
						list.clear();
						break;
					}
				}
			}
		}
		return max;
	}
}
