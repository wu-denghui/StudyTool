/**
 * 
 */
package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 24663
 * @date 2018年7月25日
 * @Description
 */
public class DateDemo implements Comparable<DateDemo>{

	/**
	 * @param args
	 * @Description 
	 */
	public static void main(String[] args) {
		//显示当前日期
		Date  date=new Date();
		System.out.println(date);
		//Wed Jul 25 15:41:38 CST 2018
		
		
		
		
		
		
		
		
		
		
		
//        按指定格式显示当前日期
/*		要指定时间格式，使用时间模式字符串。在这个模式中，所有的ASCII字母被保留为模式字母，其定义如下：
		字符	描述	例子
		G	时代指示器	AD
		y	四位数年份	2001
		M	年中的月份	July or 07
		d	月份中日期	10
		h	时间 A.M./P.M.(1~12)	12
		H	天中的小时 (0~23)	22
		m	小时中的分钟	30
		s	分钟中的秒钟	55
		S	毫秒	234
		E	星期中的天	Tuesday
		D	年中的天	360
		F	月中星期中的天	2 (second Wed. in July)
		w	年中的星期	40
		W	月中的星期	1
		a	A.M./P.M. 标记	PM
		k	天中的小时(1~24)	24
		K	小时A.M./P.M. (0~11)	10
		z	时区	东部标准时间
		'	脱离文本	分隔符
		"	单引号	`
*/		Date  d=new Date();
		SimpleDateFormat  sdf=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(d));
		//2018-07-25 星期三  15:41:38
		
		
		
		
		//根据字符串确定一个时间
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
     	String string="2018.12.12 24:56:52";
     	try {
			System.out.println(sdf2.parse(string));
			//Thu Dec 13 00:56:52 CST 2018
		} catch (ParseException e) {
			e.printStackTrace();
		}
     	
     	
     	
     	
     	//测量执行时间
     	  try {
              long start = System.currentTimeMillis( );
              System.out.println(start);
              //休眠十秒
              Thread.sleep(1000);
              long end = System.currentTimeMillis( );
              System.out.println(end);
              long diff = end - start;
              System.out.println("Difference is : " + diff);
           } catch (Exception e) {
              System.out.println("Got an exception!");
           }
        }

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(DateDemo o) {
		// TODO Auto-generated method stub
		return 0;
	}

	}

