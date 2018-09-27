/**
 * 
 */
package BiShi;


/**
 * @author 24663
 * @date 2018年9月20日
 * @Description
 */
import java.util.Scanner;
public class bcz_02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] an = new int[n];
		for (int i = 0; i < an.length; i++) {
			an[i] = in.nextInt();
		}
		int start = 0;
		int end = 0;
		for (int i = 0; i < an.length; i++) {
			start = i;
			end = i;
			for (int j = i + 1; j < an.length; j++) {
				if (an[j] - an[i] == 1) {
					i++;
					end++;
				} else {
					break;
				}
			}
			if (end>=3) {
				break;
			}
		}
		System.out.println(start);
		System.out.println(end);
		for (int i = 0; i < an.length; i++) {
			if (i<start) {
				System.out.print(an[i]+" ");
			}else if (i>end) {
				System.out.print(an[i]+" ");
			}else if (i==start) {
				System.out.print(an[start]+"-"+an[end]+" ");
			}else{
				
			}
		}
	}
}