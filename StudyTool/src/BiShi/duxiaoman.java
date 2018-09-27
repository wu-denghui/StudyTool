/**
 * 
 */
package BiShi;


import java.util.HashMap;
/**
 * @author 24663
 * @date 2018年9月13日
 * @Description 
 * 在Z省，有若干个个城市坐落在一条直线上，从左到右依次标号1,2,3,…，
 * 其中每个城市有一个火车站点，现今已经开放了n条火车路线，第i条火车路线是从第Yi个城市到第Xi个城市，
 * 因为Z省地势奇特，标号小的城市地势较低，所以火车是从高往低开的，再通过神秘力量传送回高地，即Yi一定大于Xi，
 * 它在沿途的所有城市都会停靠（显然不包括起点Yi，但是包括终点Xi），火车停靠就需要火车站台来运营维护。
 * 火车站台随着运营线路的数量不同，其损耗速度、维护成本也各异，现在我们想知道所有站台中，所运营的线路数最大是多少。
 * 3
Hint
第一条涉及站台6，5，4
第二条涉及站台5，4，3，2
第三条涉及站台4，3，2
第四条涉及站台1
所以显然站台4运营的线路最多，有3条
 */
import java.util.Scanner;
public class duxiaoman {
	public static void main(String[] args) {
		duxiaoman dxiaoman=new duxiaoman();
		Scanner read=new Scanner(System.in);
		int n=read.nextInt();
		int[] x=new int[n+1];
		int[] y=new int[n+1];	
		int max=0;
		for (int i=1; i <= n; i++) {
			x[i]=read.nextInt();
			max=Math.max(max, x[i]);
			y[i]=read.nextInt();
			max=Math.max(max, y[i]);
		}
		System.out.println(dxiaoman.getMa(x,y,max));
	}

	public int getMa(int[] x, int[] y,int n) {
        int[] result=new int[n+1];
		int max=0;
		for (int i = 1; i <x.length; i++) {
			int start=y[i];
			int end=x[i];
			for (int j = start-1; j >=end; j--) {
				if (result[j]!=0) {
                    result[j]=result[j]+1;
					max=Math.max(max, result[j]);
				}else{
                    result[j]=1;
					max=Math.max(max,1);
				}
			}
		}
		return max;
	}



}
