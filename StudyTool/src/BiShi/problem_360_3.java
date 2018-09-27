/**
 * 
 */
package BiShi;

import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年8月27日
 * @Description
 * 小红有两个长度为n的排列A和B。每个排列由[1,n]数组成，且里面的数字都是不同的。
现在要找到一个新的序列C，要求这个新序列中任意两个位置(i,j)满足:
如果在A数组中C[i]这个数在C[j]的后面，那么在B数组中需要C[i]这个数在C[j]的前面。
请问C序列的长度最长为多少呢？
输入
第一行一个整数，表示N。
第二行N个整数，表示A序列。
第三行N个整数，表示B序列。
满足:N<=50000
输出
输出最大的长度
样例输入
5
1 2 4 3 5
5 2 3 4 1
 */
public class problem_360_3 {

	public static void main(String[] args) {
		problem_360_3 problem_360_3=new problem_360_3();
        Scanner next=new Scanner(System.in);
        int N=next.nextInt();
        int[] A=new int[N];
        int[] B=new int[N];
        for (int i = 0; i < A.length; i++) {
        	A[i]=next.nextInt();
        }
        for (int i = 0; i < B.length; i++) {
        	B[i]=next.nextInt();
        }
        System.out.println(problem_360_3.getLength(A, B));
	}
	public  int getLength(int[] A,int[] B){
		int count=A.length;
		for (int i = 0; i < A.length; i++) {
			for (int j = i+1; j < A.length; j++) {
				if (getIndex(B, A[i])==-1) {
					break;
				}
				if (getIndex(B, A[j])==-1) {
					continue;
				}
				if (getIndex(B, A[i])<getIndex(B, A[j])) {
					count--;
					break;
				}
			}
		}
		return count;
	}
	public int getIndex(int[] B,int target){
		for (int i = 0; i < B.length; i++) {
			if (B[i]==target) {
				return i;
			}
		}
		return -1;
	}

}
