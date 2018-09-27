package Algorithm;
public class Package {  
    /** 
     * 有N件物品和一个容量为W的背包。第i件物品的重量是w[i]，价值是v[i]。 
     * 求解将哪些物品装入背包可使这些物品的重量总和不超过背包容量，且价值总和最大。 
     */  
    public static void main(String[] args) {  
        int w=11;//背包装入的总重量不能超过该值，使得总价值最大  
        int n=5;//五个物品  
        int[] value={1,6,18,22,28};//对应物品的价值  
        int[] weight={1,2,5,6,7};//对应每个品的重量  
        System.out.println("所得结果："+findMaxValue(w,n,weight,value));  
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
                	//第j个物品对应重量的下标减1，从0开始。  
                    max[j][k]=max[j-1][k];
                    //当加入的一个物品重量大于k，这个物品一定不能选  
                }else{  
                    int a=max[j-1][k];//不选第j个物品  
                    int b=value[j-1]+max[j-1][k-weight[j-1]];
                    //可以选第j个物品，选择这个物品  
                    max[j][k]=a>b ? a:b;
                    //选择第j个和不选第j个物品，那个大，返回哪个；  
                } 
        }
    }
          
        //遍历数组结果，打印出来看看  
        for (int[] is : max) {  
            for (int i : is) {  
                System.out.print(i+"  ");  
            }  
            System.out.println();  
        }  
        return max[n][w];  
          
    }  
  
  
}  