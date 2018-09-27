/**
 * 
 */
package BiShi;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年9月20日
 * @Description
 */
public class bcz_1 {
	
	public static void main(String[] args) {
		bcz_1 bcz_1=new bcz_1();
		Scanner in=new Scanner(System.in);
		String  time1=in.nextLine();
		String[] ti1=time1.split(":");
		String time2=in.nextLine();
		String[] ti2=time2.split(":");
		double[] end=new double[ti1.length];
		for (int i = 0; i < end.length; i++) {
			end[i]=Integer.valueOf(ti1[i]);
		}
		double[] start=new double[ti2.length];
		for (int i = 0; i < start.length; i++) {
			start[i]=Integer.valueOf(ti2[i]);
		}
		DecimalFormat    df   = new DecimalFormat("######0");  
		double h=0;
		if (start[1]>=end[1]) {
		h=((start[0]-end[0])/12)*360+((start[1]-end[1])/60/12)*360;
		}else{
		h=((start[0]-end[0]-1)/12)*360+((60-start[1]+end[1])/60/12)*360;
		}
		double m=(start[0]-end[0])*360+((start[1]-end[1])/60)*360;
		double s=(start[0]-end[0])*360*60+(start[1]-end[1])*360+((start[2]-end[2])/60)*360;
		System.out.println(df.format(h));
		System.out.println(df.format(m));
		System.out.println(df.format(s));
	}

}
