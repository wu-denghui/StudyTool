/**
 * 
 */
package LintCode_1;

import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年9月4日
 * @Description 描述 合并两个排序的整数数组A和B变成一个新的数组。 您在真实的面试中是否遇到过这个题？ 是 样例
 *              给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 */
public class TI_6 {
	public static void main(String[] args) {
		TI_6 ti_6 = new TI_6();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] an = new int[n];
		for (int i = 0; i < an.length; i++) {
			an[i] = in.nextInt();
		}
		int m = in.nextInt();
		int[] bn = new int[m];
		for (int i = 0; i < bn.length; i++) {
			bn[i] = in.nextInt();
		}
		int[] result = ti_6.mergeSortedArray(an, bn);
		for (int i = 0; i < result.length; i++) {
			if (i == result.length - 1) {
				System.out.println(result[i]);
			}else {
				System.out.print(result[i] + ",");
			}
		}

	}
	public int[] mergeSortedArray(int[] A, int[] B) {
		int[] result = new int[A.length + B.length];
		int i = 0, j = 0, index = 0;
		while (index < result.length) {
			while (i >= A.length && j < B.length) {
				result[index++] = B[j++];
			}
			while (i < A.length && j >= B.length) {
				result[index++] = A[i++];
			}
			if (i < A.length && j < B.length && A[i] <= B[j]) {
				result[index++] = A[i++];
			}
			if (i < A.length && j < B.length && A[i] > B[j]) {
				result[index++] = B[j++];
			}
		}
		return result;
	}

}
