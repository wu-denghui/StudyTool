package Algorithm;
public class Package {  
    /** 
     * ��N����Ʒ��һ������ΪW�ı�������i����Ʒ��������w[i]����ֵ��v[i]�� 
     * ��⽫��Щ��Ʒװ�뱳����ʹ��Щ��Ʒ�������ܺͲ����������������Ҽ�ֵ�ܺ���� 
     */  
    public static void main(String[] args) {  
        int w=11;//����װ������������ܳ�����ֵ��ʹ���ܼ�ֵ���  
        int n=5;//�����Ʒ  
        int[] value={1,6,18,22,28};//��Ӧ��Ʒ�ļ�ֵ  
        int[] weight={1,2,5,6,7};//��Ӧÿ��Ʒ������  
        System.out.println("���ý����"+findMaxValue(w,n,weight,value));  
    }  
  
    private static int findMaxValue(int w,int n, int[] weight, int[] value) {  
        int[][]max=new int[n+1][w+1];  
          
        for(int i=0;i<=w;i++)//M[n,W]  
            max[0][i]=0;  
        for(int i=0;i<=n;i++)//M[n,W]  
        	max[i][0]=0;  
        for(int j=1;j<=n;j++) {
            for(int k=1;k<=w;k++){
                if(weight[j-1]>k){
                	//��j����Ʒ��Ӧ�������±��1����0��ʼ��  
                    max[j][k]=max[j-1][k];
                    //�������һ����Ʒ��������k�������Ʒһ������ѡ  
                }else{  
                    int a=max[j-1][k];//��ѡ��j����Ʒ  
                    int b=value[j-1]+max[j-1][k-weight[j-1]];
                    //����ѡ��j����Ʒ��ѡ�������Ʒ  
                    max[j][k]=a>b ? a:b;
                    //ѡ���j���Ͳ�ѡ��j����Ʒ���Ǹ��󣬷����ĸ���  
                } 
        }
    }
          
        //��������������ӡ��������  
        for (int[] is : max) {  
            for (int i : is) {  
                System.out.print(i+"  ");  
            }  
            System.out.println();  
        }  
        return max[n][w];  
          
    }  
  
  
}  