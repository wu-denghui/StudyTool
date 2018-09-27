
package BiShi;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年8月27日
 * @Description
 * 有一个城市需要修建，给你N个民居的坐标X,Y，问把这么多民居全都包进城市的话，城市所需最小面积是多少（注意，城市为平行于坐标轴的正方形）

输入
第一行为N，表示民居数目（2≤N≤1000）

下面为N行，每行两个数字Xi，Yi，表示该居民的坐标（-1e9≤xi,yi≤1e9）

输出
城市所需最小面积
 */
public class problem_360_1 {

	public static void main(String[] args) {
		problem_360_1 problem_360_1=new problem_360_1();
             Scanner next=new Scanner(System.in);
             int N=next.nextInt();
             int[] x=new int[N];
             int[] y=new int[N];
             for (int i = 0; i < x.length; i++) {
				x[i]=next.nextInt();
				y[i]=next.nextInt();
			}
        System.out.println(problem_360_1.getMin(x, y));		
	}
	public int getMin(int[] x,int[] y){
		int minx = Integer.MAX_VALUE,miny=Integer.MAX_VALUE;
		int maxx = 0,maxy=0;
		for (int i = 0; i < y.length; i++) {
            miny=Math.min(miny, y[i]);
            maxy=Math.max(maxy, y[i]);
		}
		for (int i = 0; i < x.length; i++) {
            minx=Math.min(minx, x[i]);
            maxx=Math.max(maxx, x[i]);
		}
		int side=Math.max((maxy-miny), (maxx-minx));
		return  side*side;
	}

}
