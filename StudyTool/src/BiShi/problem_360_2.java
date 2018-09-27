/**
 * 
 */
package BiShi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年8月27日
 * @Description
 * 小明有一个花园，花园里面一共有m朵花，对于每一朵花，都是不一样的，小明用1～m中的一个整数表示每一朵花。
他很喜欢去看这些花，有一天他看了n次，并将n次他看花的种类是什么按照时间顺序记录下来。
记录用a[i]表示，表示第i次他看了a[i]这朵花。
小红很好奇，她有Q个问题,问[l,r]的时间内，小明一共看了多少朵不同的花儿，小明因为在忙着欣赏他的花儿，所以想请你帮他回答这些问题。
输入
输入两个数n,m;(1<=n<=2000,1<=m<=100);分别表示n次看花，m表示一共有m朵花儿。
接下来输入n个数a[1]~a[n]，a[i]表示第i次，小明看的花的种类;
输入一个数Q(1<=Q<=1000000);表示小红的问题数量。
输入Q行 每行两个数 l,r(1<=l<=r<=n); 表示小红想知道在第l次到第r次，小明一共看了多少不同的花儿。
输出
一共Q行
每一行输出一个数 表示小明在[l,r]的时间内看了多少种花。
 */
public class problem_360_2 {
	public static void main(String[] args) {
		problem_360_2 problem_360_2 =new problem_360_2();
        Scanner next=new Scanner(System.in);
        int N=next.nextInt();
        int M=next.nextInt();
        int[] n=new int[N+1];
        for (int i = 1; i < n.length; i++) {
			n[i]=next.nextInt();
		}
        int Q=next.nextInt();
        int[][] q=new int[Q][2];
        for (int i = 0; i < q.length; i++) {
			q[i][0]=next.nextInt();
			q[i][1]=next.nextInt();
		}
        for (int i = 0; i < q.length; i++) {
			System.out.println(problem_360_2.getAnswer(n, q[i][0], q[i][1]));
		}
	}
   
	  public int getAnswer(int[] n,int begin,int end){
		  ArrayList< Integer> list=new ArrayList<Integer>();
		  for (int i = begin; i <=end; i++) {
			if (!list.contains(n[i])) {
				list.add(n[i]);
			}
		}
		return list.size();
	  }

}
