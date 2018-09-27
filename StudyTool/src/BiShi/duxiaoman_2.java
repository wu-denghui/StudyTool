package BiShi;

import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年9月13日
 * @Description
 */
public class duxiaoman_2 {

	public static void main(String[] args) {
		duxiaoman_2 dxiaoman = new duxiaoman_2();
		Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		int[] prices = new int[n];
		for (int i = 1; i <= n; i++) {
			prices[i] = read.nextInt();
		}
		System.out.println(dxiaoman.getMax(prices));
	}
	private int getMax(int[] prices) {
        int reslut = 0;
        int count=0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            if (diff > 0) {
                reslut += diff;
                count++;
            }
        }
        System.out.println(count);
        return reslut;
	}
}
