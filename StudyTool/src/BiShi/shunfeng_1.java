/**
 * 
 */
package BiShi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年9月15日
 * @Description
 */
public class shunfeng_1 {

	public static void main(String[] args) {
		shunfeng_1 ma=new shunfeng_1();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < args.length; i++) {
			
		}
		String partern = in.nextLine();
		char[] ch = partern.toCharArray();
		ArrayList<Integer>  list=ma.getResult(partern);
		System.out.println(ma.getString(partern, ch, list));
	}
	
	public  String getString(String partern,char[] ch,ArrayList<Integer> list){
		if (partern==null||partern.length()==0||list.isEmpty()) {
			return null;
		}
		int sum=0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
			if (list.get(i)==list.get(i+2)&&list.get(i)>list.get(i+1)) {
				return  partern.substring(sum-list.get(i),sum+1+list.get(i+2));
			}
		}
		return null;
	}

	public ArrayList<Integer> getResult(String partern) {
		ArrayList<Integer> list=new ArrayList<>();
		if (partern==null||partern.length()==0) {
			return list;
		}
		char[] ch = partern.toCharArray();
		int i = 0;
		while (i < ch.length){
			int sum = 1;
			int index = i + 1;
			while (index<ch.length&&ch[i] == ch[index]){
				sum++;
				index++;
			}
			list.add(sum);
			i=index;
		}
		return list;
	}
}
