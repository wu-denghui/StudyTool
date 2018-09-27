/**
 * 
 */
package BiShi;

import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年9月9日
 * @Description
 */
public class jd_2 {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = read.nextInt();
			b[i] = read.nextInt();
			c[i] = read.nextInt();
		}
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (a[i] < a[j] && b[i] < b[j] && c[i] < c[j]) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}

}
