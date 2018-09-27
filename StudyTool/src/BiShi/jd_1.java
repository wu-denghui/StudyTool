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
 * @Description
 */
public class jd_1 {
	public static void main(String[] args) {
		jd_1 jd_1=new jd_1();
		Scanner read = new Scanner(System.in);
		int index = 0;
		int N = read.nextInt();
		while (index < N) {
			int n = read.nextInt();
			int m = read.nextInt();
			boolean[][] bool = new boolean[n+1][n+1];
			int count = 0;
			while (count < m) {
				int x = read.nextInt();
				int y = read.nextInt();
				bool[x][y] = true;
				bool[y][x] = true;
				count++;
			}
			System.out.println(jd_1.isCg(bool, n));
			index++;
		}
	}

	public String isCg(boolean[][] bool, int n) {
		List<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		for (int i = 1; i <= n; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			list.add(i);
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					continue;
				}
				if (!bool[i][j]) {
					list.add(j);
				}
			}
			if (!result.contains(list)) {
				result.add(list);
			}
		}
		
		if (removeWrong(result, bool, n)==01) {
			return "No";
		} else {
			return "Yes";
		}

	}

	private int removeWrong(List<LinkedList<Integer>> result, boolean[][] bool, int n) {
		boolean in;
		int size=result.size();
		for (int i = 0; i < result.size(); i++) {
			in=false;
			for (int j = 0; j < result.get(i).size(); j++) {
				for (int k = 1; k <= n; k++) {
					if (!result.get(i).contains(k)) {
						int temp = result.get(i).get(j);
						if (!bool[temp][k]) {
							   in=true;
							break;
						}
					}
				}
				if (in=true) {
					size--;
					break;
				}
			}
		}
		return size;
	}
}
