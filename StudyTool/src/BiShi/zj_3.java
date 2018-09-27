/**
 * 
 */
package BiShi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年9月9日
 * @Description
 */
public class zj_3 {
	public static void main(String[] args) {
		zj_3 zj_3=new zj_3();
		Scanner read = new Scanner(System.in);
		String ps=read.nextLine();
		String ts=read.nextLine();
		int n = read.nextInt();
		int m = read.nextInt();
		boolean[][] bool = new boolean[n + 1][m + 1];
		for (int i = 0; i <=n; i++) {
			bool[i][i] = true;
		}
		int index = 0;
		while (index < m) {
			int x = read.nextInt();
			int y = read.nextInt();
			bool[x][y] = true;
			index++;
		}
		System.out.println(zj_3.getSum(bool,n));
	}

	public int getSum(boolean[][] bool,int n) {
		int sum=0;
		for (int i = 1; i < bool.length; i++) {
			for (int j = 1; j < bool.length; j++) {
				LinkedList<Integer> list = new LinkedList<>();
				int count;
				if (bool[j][i]) {
					// list加入直接关注i的人
					list.add(j);
				}
				// list加入间接关注i的人
				count=getCD(bool, list,list.size());
				if (count==n) {
					sum++;
				}
			}
		}
		return sum;
	}

	/**
	 * @param bool
	 * @param list
	 * @Description
	 */
	private int getCD(boolean[][] bool, LinkedList<Integer> list,int size) {
			for (int i = 0; i < size; i++) {
				int temp = list.get(i);
				for (int j = 1; j < bool.length; j++) {
					if (bool[j][temp]&&!list.contains(j)) {
						list.add(j);
					}
				}
			}
			if (list.size() == size) {
				return list.size();
			}else{
				return getCD(bool, list,list.size());
				
			}
	}
}
