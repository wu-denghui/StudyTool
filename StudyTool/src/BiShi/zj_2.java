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
public class zj_2 {
	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		int  M=read.nextInt();
		int[][] an=new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				an[i][j]=read.nextInt();
			}
		}
//		System.out.println(ma.getSum(an));
	}
	
	
	/**
	 * @param an
	 * @Description 
	 */
	private int getSum(int[][] an) {
		int zb=0;
		int yb=0;
		int sum=0;
        for (int i = 0; i < an.length; i++) {
			for (int j = 0; j < an.length; j++) {
				//找到第一个为1的数
				while(an[zb][yb]==1){
					while (isRight(an, zb, yb)) {
						yb++;
					}
					if (isDown(an, zb, yb)) {
						zb++;
					}
					if (isLeft(an, zb, yb)) {
						yb--;
					}
					if (isUp(an, zb, yb)) {
						zb--;
					}
				}
			}
		}
		return sum;
	}


	public boolean   isLeft(int[][] an,int zb,int yb){
		if (yb-1<0) {
			return false;
		}
		if (an[zb][yb-1]==1) {
			return true;
		}
		return false;
	}
	public boolean   isUp(int[][] an,int zb,int yb){
		if (zb-1<0) {
			return false;
		}
		if (an[zb-1][yb]==1) {
			return true;
		}
		return false;
	}
	public boolean   isDown(int[][] an,int zb,int yb){
		if (zb+1>an.length-1) {
			return false;
		}
		if (an[zb+1][yb]==1) {
			return true;
		}
		return false;
	}
	public boolean   isRight(int[][] an,int zb,int yb){
		if (yb+1>an.length-1) {
			return false;
		}
		if (an[zb][yb+1]==1) {
			return true;
		}
		return false;
	}

}
