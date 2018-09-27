/**
 * 
 */
package NKExercise;

/**
 * @author 24663
 * @date 2018年8月24日
 * @Description
 * 
 * 有一个机器人的位于一个 m × n 个网格左上角。
   机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
   问有多少条不同的路径？
 */
public class Path {

	public static void main(String[] args) {
		int n=3;
		int m=3;
		int sum=n+m-2;
		int fm=1;
		int fz=1;
		for (int i = sum; i >sum-n+1; i--) {
			fz=fz*i;
		}
		for (int i = n-1; i >=1; i--) {
			fm=i*fm;
		}
       int result=fz/fm;
       System.out.println(result);
	}

}
