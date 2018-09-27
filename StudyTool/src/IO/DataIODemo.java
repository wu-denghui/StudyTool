/**
 * 
 */
package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 24663
 * @date 2018年7月17日
 * @Description
 */
public class DataIODemo {
	
	public static void main(String[] args) {
		DataIODemo dataIODemo=new DataIODemo();
		dataIODemo.writeFile("D:/noo.txt");
		dataIODemo.readFile("D:/noo.txt");
		
		
	}
	public  void  readFile(String pathName){
		File file = new File(pathName);
		if (!file.exists()) {
			System.out.println("文件不存在，请检查路径!");
		}
		DataInputStream dis = null;
		try {
		 dis=new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	 
	public void writeFile(String  pathName){
		File file = new File(pathName);
		try {
			if (!file.exists()) {
				File parent = file.getParentFile();
				parent.mkdirs();
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DataOutputStream dis = null;
		try {
		 dis=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			dis.writeInt(2);
			dis.writeChar('d');
			dis.writeInt(5);
			dis.writeUTF("傻逼一样");
            dis.writeChar('a');
            dis.writeInt(10);
            dis.writeDouble(Math.random());
            dis.writeBoolean(true);
            dis.writeUTF("北京尚学堂");
			dis.flush();
	        /*
	        DataOutputStream dos = null; //声明数据输出流对象
	        File f = new File("D:" + File.separator + "order.txt");//指定文件的保存路径
	        OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
	        dos = new DataOutputStream(new FileOutputStream(f));//实例化数据输出流对象   
	        String names[] = {"衬衣","手套","围巾"};//商品名称
	        float prices[] = {98.3f,30.3f,50.5f};    //商品价格 
	        int nums[] = {3,2,1};    //商品数量 
	        for(int i = 0;i<names.length;i++){   
	            //循环写入   
	            dos.writeChar(names[i]);    //写入字符串
	            dos.writeChar('\t');    //加入分隔符
	            dos.writeFloat(prices[i]);  //写入小数 
	            dos.writeChar('\t'); //加入分隔符  
	            dos.writeInt(nums[i]); //写入整数 
	            dos.writeChar('\n');    //换行
	         
	            oStreamWriter.write(names[i]);
	            oStreamWriter.write('\t');
	            oStreamWriter.write(prices[i]+"");  //写入小数 
	            oStreamWriter.write('\t'); //加入分隔符
	            oStreamWriter.write(nums[i]); //写入整数  
	            oStreamWriter.write('\n');  //换行
	            }  
	        oStreamWriter.close();  //关闭输出流
             */		
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	  
	}

}
