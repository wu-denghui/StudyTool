	package BiShi;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年8月26日
 * @Description
 *    n人分组，an[i][j] 表示 第i人是否与an[i][j相识 例如：an[2][3]=7表示第二个人与第七个人相识
 *     根据是否相识分组  求最小组数
 * 
 */
public class zjtd2018_1 {


		public static void main(String[] args) {
			zjtd2018_1  zjtd2018_1=new zjtd2018_1();
//			Scanner read = new Scanner(System.in);
//			int n = read.nextInt();
			int n=10;
			int[][] an={{0},{0},{5,3,0},{8,4,0},{9,0},{9,0},{3,0},{0},{7,9,0},{0},{9,7,0}};
			
			//bool[i]=j  表示第i个人分入了第j组，值为0表示为未分组
			int[] bool = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
					bool[i]= 0;
			}
//			for (int i = 1; i < n + 1; i++) {
//				for (int j = 0; j < n + 1; j++) {
//					int m = read.nextInt();
//					if (m == 0) {
//						break;
//					} else {
//						an[i][j] = m;
//					}
//				}
//			}
			System.out.println(zjtd2018_1.getM(an, bool, n));
		}

		public int getM(int[][] an, int[] bool, int n) {
			int count = 0;
			if (an == null || bool == null) {
				return -1;
			}
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
			ArrayList<Integer> list;
			for (int i = 0; i < n; i++) {
				list = new ArrayList<Integer>();
				map.put(i, list);
			}
			for (int i = 0; i < n; i++) {
				intoList(an, bool, map.get(i), i+1,i);
			}
			for (int i = 0; i < n; i++) {
				if (map.get(i).size() != 0) {
					count++;
				}
			}
			return count;

		}

		public void intoList(int[][] an, int[] bool, ArrayList<Integer> list, int i,int index) {

			for (int j = 0; j < an[i].length; j++) {
				if (an[i][j] != 0 && bool[an[i][j]]==0) {
					list.add(an[i][j]);
					bool[an[i][j]] = index;
					intoList(an, bool, list, an[i][j],index);
				}
				if (an[i][j] != 0 && bool[an[i][j]]!=0) {
					bool[i]=bool[an[i][j]];
				}
			}
			if (bool[i]==0) {
				list.add(i);
				bool[i] = index;
			}

		}


}
