package Algorithm;

import java.util.Scanner;  

public class JosephusKill {  
    //约瑟夫环问题，输入总人数与每报多少数自杀，输出最后活下来的两个人  
    public static void main(String[] args){  
        System.out.println("请输入总人数与每第几个位置自杀：");  
        Scanner sc=new Scanner(System.in);  
        int m=sc.nextInt();//总人数  
        int n=sc.nextInt();//每第几个位置自杀  
        int loc=0;//当前下标  
        int tur=1;//每个报数循环的相对位置  
        int count=m;//记录还剩下多少人  
          
        boolean []flag=new boolean[m];  
        while(count>1){  
            //通过循环遍历数组，将每第三个位置且未死的人设置为已死  
            if(flag[loc%m]==false){//这个位置上的人没死，继续判断  
                if(tur%n==0){//判断是否是处在每个循环的第三个位置  
                	int deadth=loc%m;
                    flag[deadth]=true;  
                    System.out.println("第"+ (deadth+1)+"人被处决");
                    loc++;  
                    tur=1;  
                    count--;//剩下的人数  
                }  
                else{  
                    //当前人未处在第三个位置，则继续往下一个位置移动并报数  
                    loc++;  
                    tur++;  
                }  
            }  
            else{  
                //i位置上的人已经死了，则跳到下一个位置，但是这个位置不报数  
                loc++;  
            }  
              
        }  
        System.out.print("活下来的人的位置是：");  
        for(int i=0;i<m;i++){  
            //遍历出未死的人  
            if(flag[i]==false){  
                System.out.print((i+1)+" ");  
            }  
        }  
          
    }  
}  