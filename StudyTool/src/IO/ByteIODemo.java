package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.mysql.jdbc.Buffer;
import com.sun.swing.internal.plaf.basic.resources.basic;

import sun.security.util.Length;

public class ByteIODemo {

	public static void main(String[] args) {
		ByteIODemo fileDemo=new ByteIODemo();
		fileDemo.WriteFile("D:/book.txt", "终于hongxxx123");
//		byte[] mm=fileDemo.readFileReturn("D:/book.txt");
//		System.out.println(mm[9]);
//		fileDemo.WriteFile("D:/xx.txt", mm);
//	    fileDemo.copyFile("D:/book.txt", "D:/book2.txt");

	}

	/**
	 * 新建文件
	 * @param PathName 新建文件的路径
	 *            
	 */

	public void createFile(String PathName) {
		// 创建一个原本不存在的文件 三种格式的文件都可以创建
		File newFile = new File(PathName);
		// File newFile1 = new File("E:/new.txt");
		// File newFile2 = new File("E:/new.docx");
		// File newFile3 = new File("E:/new.properties");
		System.out.println(newFile.exists());
		/*
		 * 判断映射的文件是否真实存在 file.exists() true存在 false不存在 如果存在即可直接操作, 否则需要调用
		 * file.createNewFile() 创建真实文件 但是以上方式只会适用创建文件本身,不包括父文件的创建(如果父文件不存在)
		 * 所以一般需要对父文件存在与否作判断
		 */
		File parent = newFile.getParentFile(); // 获取父文件
		if (!parent.exists())
			parent.mkdirs(); // 创建所有父文件夹
		try {
			newFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(newFile.exists());
	}
	
	public  void WriteFile(String pathName,String info){
		//String  newString=new String
		File file = new File(pathName);
		if (!file.exists()) {
			File parent = file.getParentFile(); // 获取父文件
			if (!parent.exists())
				parent.mkdirs(); // 创建所有父文件夹
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		FileOutputStream fos;
		BufferedOutputStream bos;
		DataOutputStream dos;
		try {
			// true表示内容会追加到文件末尾；false表示重写整个文件内容。
			fos=new FileOutputStream(file,false);
			bos=new BufferedOutputStream(fos);
			dos=new DataOutputStream(fos);
			// 使用FileOutputStream向文件中写入字节信息
			fos.write(info.getBytes("UTF-8"));
//			fos.write(info.getBytes(), 0,4 );
//			byte y='y';
//			fos.write(y);
			// 使用DataOutputStream+FileOutputStream向文件中写入字节信息
			dos.write(info.getBytes("UTF-8"));
//			dos.write(info.getBytes(), 0,4 );
//			byte x='y';
//			dos.write(x);
			//使用BufferedOutputStream+FileOutputStream向文件中写入字节信息
			//这种方式下最后要调用flush清除缓存内容，否则无法写入
			bos.write(info.getBytes("UTF-8"));
			 byte z='y';
			 bos.write(z);
			 bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  void WriteFile(String pathName,byte[] by){
		//String  newString=new String
		File file = new File(pathName);
		if (!file.exists()) {
			File parent = file.getParentFile(); // 获取父文件
			if (!parent.exists())
				parent.mkdirs(); // 创建所有父文件夹
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		FileOutputStream fos;
		BufferedOutputStream bos;
		DataOutputStream dos;
		try {
			// true表示内容会追加到文件末尾；false表示重写整个文件内容。
			fos=new FileOutputStream(file,false);
			bos=new BufferedOutputStream(fos);
			dos=new DataOutputStream(fos);

			dos.write(by);
//        bos.write(by); DataOutputStream写入不了文件
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *    读取文件字节
	 * @param PathName  文件路径
	 */
	public void readFile(String pathName) {
		File file = new File(pathName);
		FileInputStream fs;
		DataInputStream dis;
		BufferedInputStream bis;
		byte[] by=new byte[1024];
		try {
			fs = new FileInputStream(file);
			dis = new DataInputStream(fs);
			bis = new BufferedInputStream(fs);
			//使用FileInputStream读取文件字节信息
			fs.read(by);
			System.out.println(by[0]);
			//使用FileInputStream+DataInputStream读取文件字节信息
			dis.read(by);
			//使用FileInputStream+BufferedInputStream读取文件字节信息
			bis.read(by);
			while( bis.read(by)!=-1) {
				System.out.println(by[0]);
			}
			System.out.println(1111111);
			// 如果在读取所需字节数之前已经到达文件末尾 (end of file)，则将抛出EOFException（IOException的一种）。
			// 如果因为到达文件末尾以外的其他原因无法读取字节，则将抛出 IOException 而不是 EOFException。
			// 尤其是，在输入流已关闭的情况下，将抛出 IOException。
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			System.out.println("读取所需字节数之前已经到达文件末尾");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	public byte[] readFileReturn(String pathName) {
		File file = new File(pathName);
		FileInputStream fs;
		DataInputStream dis;
		ByteArrayOutputStream bis = null;
		byte[] by=new byte[1024];
		try {
			fs = new FileInputStream(file);
			dis = new DataInputStream(fs);
			bis = new ByteArrayOutputStream();
			//使用FileInputStream读取文件字节信息
//			fs.read(by);
//			System.out.println(by[0]);
			//使用FileInputStream+DataInputStream读取文件字节信息
//			dis.read(by);
			//使用FileInputStream+BufferedInputStream读取文件字节信息
			int length;
			  while ((length = dis.read(by)) > 0) {
		            bis.write(by, 0, length);
		        }
			// 如果在读取所需字节数之前已经到达文件末尾 (end of file)，则将抛出EOFException（IOException的一种）。
			// 如果因为到达文件末尾以外的其他原因无法读取字节，则将抛出 IOException 而不是 EOFException。
			// 尤其是，在输入流已关闭的情况下，将抛出 IOException。
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			System.out.println("读取所需字节数之前已经到达文件末尾");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return bis.toByteArray();

	}
	public  void  copyFile(String filePath1,String filePath2){
		File file1=new File(filePath1);
		File file2=new File(filePath2);
		FileInputStream fis;
		BufferedInputStream bis = null;
		FileOutputStream fos;
		BufferedOutputStream   bos = null;
		byte[] by=new byte[1024];
		try {
			fis=new FileInputStream(file1);
			bis=new BufferedInputStream(fis);
			fos=new  FileOutputStream(file2);
			bos=new BufferedOutputStream(fos);
			int  length;
			while( (length=bis.read(by))!=-1) {
				bos.write(by,0,length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
