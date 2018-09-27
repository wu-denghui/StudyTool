package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IoDemo {
	public static void main(String[] args) {
		File  book=new File("E:/book.txt");
		File parent = book.getParentFile(); // 获取父文件
		if( !parent.exists() ) parent.mkdirs(); //创建所有父文件夹
		try {
			book.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			//字节输入流
			FileInputStream fis=new FileInputStream(book);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
