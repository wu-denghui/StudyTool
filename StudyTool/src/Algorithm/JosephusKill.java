package Algorithm;

import java.util.Scanner;  

public class JosephusKill {  
    //Լɪ�����⣬������������ÿ����������ɱ���������������������  
    public static void main(String[] args){  
        System.out.println("��������������ÿ�ڼ���λ����ɱ��");  
        Scanner sc=new Scanner(System.in);  
        int m=sc.nextInt();//������  
        int n=sc.nextInt();//ÿ�ڼ���λ����ɱ  
        int loc=0;//��ǰ�±�  
        int tur=1;//ÿ������ѭ�������λ��  
        int count=m;//��¼��ʣ�¶�����  
          
        boolean []flag=new boolean[m];  
        while(count>1){  
            //ͨ��ѭ���������飬��ÿ������λ����δ����������Ϊ����  
            if(flag[loc%m]==false){//���λ���ϵ���û���������ж�  
                if(tur%n==0){//�ж��Ƿ��Ǵ���ÿ��ѭ���ĵ�����λ��  
                	int deadth=loc%m;
                    flag[deadth]=true;  
                    System.out.println("��"+ (deadth+1)+"�˱�����");
                    loc++;  
                    tur=1;  
                    count--;//ʣ�µ�����  
                }  
                else{  
                    //��ǰ��δ���ڵ�����λ�ã����������һ��λ���ƶ�������  
                    loc++;  
                    tur++;  
                }  
            }  
            else{  
                //iλ���ϵ����Ѿ����ˣ���������һ��λ�ã��������λ�ò�����  
                loc++;  
            }  
              
        }  
        System.out.print("���������˵�λ���ǣ�");  
        for(int i=0;i<m;i++){  
            //������δ������  
            if(flag[i]==false){  
                System.out.print((i+1)+" ");  
            }  
        }  
          
    }  
}  