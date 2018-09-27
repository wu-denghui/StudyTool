package StructDemo;

import java.util.LinkedList;

public class GraphDemo {
	// 用邻接矩阵创建一个带权有向图
	// 广度、深度遍历图
	//普利姆算法 求最小生成树
	//求取出度和入度
	public static void main(String[] args) {
		Graph graph = new Graph(9);
		int[] a = { 0, 1, 2, 3, 4,5,6,7,8 };
		graph.setDingDian(a);
		
		int[][] an = {
				      {0,10,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,11,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
		              {10,0,18,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,16,Graph.MAX_WEIGHT,12},
		              {Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,0,22,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,8},
		              {Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,22,0,20,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,16,21},
		              {Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,20,0,26,Graph.MAX_WEIGHT,7,Graph.MAX_WEIGHT},
		              {11,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,26,0,17,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
		              {Graph.MAX_WEIGHT,16,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,17,0,19,Graph.MAX_WEIGHT},
		              {Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,16,7,Graph.MAX_WEIGHT,19,0,Graph.MAX_WEIGHT},
		              {Graph.MAX_WEIGHT,12,8,21,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,0}
		              };
		
		graph.setJuzhen(an);
		int duI = graph.getinterDegree(2);
		int duO = graph.getOuterDegree(2);
		// System.out.println(duI);
		// System.out.println(duO);
		//graph.DFS();
		System.out.println("\n");
		//graph.BFS();
		System.out.println("\n");
		graph.prim();
	}

}

// 图的实现类
class Graph {
	public int size;
	public int[] dingDian;// 顶点数组
	public int[][] juzhen;// 矩阵
	public  static final int MAX_WEIGHT = 1000;
	private boolean[] ifvisited;

	boolean[] getIfvisited() {
		return ifvisited;
	}

	void setIfvisited(boolean[] ifvisited) {
		this.ifvisited = ifvisited;
	}

	public Graph(int size) {
		super();
		this.size = size;
		this.dingDian = new int[size];
		this.juzhen = new int[size][size];
		this.ifvisited = new boolean[size];

	}

	public Graph(int size, int[] dingDian, int[][] juzhen) {
		super();
		this.size = size;
		this.dingDian = dingDian;
		this.juzhen = juzhen;
	}

	int getSize() {
		return size;
	}

	void setSize(int size) {
		this.size = size;
	}

	int[] getDingDian() {
		return dingDian;
	}

	void setDingDian(int[] dingDian) {
		this.dingDian = dingDian;
	}

	int[][] getJuzhen() {
		return juzhen;
	}

	void setJuzhen(int[][] juzhen) {
		this.juzhen = juzhen;
	}

	int MAX_WEIGHT() {
		return Graph.MAX_WEIGHT;
	}
//普利姆算法 求最小生成树
	
	public void prim(){
		int [] lowcost = new int[size];//最小代价顶点权值的数组,为0表示已经获取最小权值
		int [] adjvex = new int[size];//放顶点权值
		int min,minId,sum = 0;
		for(int i = 1;i<size;i++){
			lowcost[i] = juzhen[0][i];
		}
		for(int i = 1;i<size;i++){
			min = Graph.MAX_WEIGHT;
			minId = 0;
			for(int j = 1;j<size;j++){
				if(lowcost[j]<min&&lowcost[j]>0){
					min = lowcost[j];
					minId = j;
				}
			}
			adjvex[minId]=minId;
			System.out.println("顶点："+adjvex[minId]+"权值："+min);
			sum+=min;
			lowcost[minId] = 0;
			for(int j = 1;j<size;j++){
				if(lowcost[j]!=0&&juzhen[minId][j]<lowcost[j]){
					lowcost[j] = juzhen[minId][j];
					adjvex[j] = minId;
				}
			}
		}
		System.out.println("最小生成树权值和:"+sum);
	}
	/*
	 * 
   public void prim(){
	   int[] lowcost=new int[size];//寻找最小权值的比较数组
	   int[] ajvex=new int[size];//记录找到权值的顶点
	   int min,minId,sum=0;
	   for (int i = 1; i < size; i++) {
		lowcost[i]=juzhen[0][i];
	}
	   for (int i = 1; i < size; i++) {
		   min=Graph.MAX_WEIGHT;
		   minId=0;
		   for (int j = 1; j < size; j++) {
			if (lowcost[j]<min&&lowcost[j]>0) {
				min=lowcost[j];
				minId=j;
			}
			}
			ajvex[minId]=minId;
			System.out.println("顶点："+ajvex[minId]+"权值："+min);
			sum+=min;
			lowcost[minId] = 0;
			for (int k = 1; k < size; k++) {
				if (juzhen[minId][k]<lowcost[k]) {
					lowcost[k]=juzhen[minId][k];
				}
			}
	}
	   System.out.println("最小生成树权值和:"+sum);
	   
   }
	 */
	// 获得某一顶点的出度
	public int getOuterDegree(int index) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			if (juzhen[index][i] != Graph.MAX_WEIGHT && juzhen[index][i] != 0) {
				sum++;
			}
		}

		return sum;
	}

	// 获得某一顶点的入度
	public int getinterDegree(int index) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			if (juzhen[i][index] != Graph.MAX_WEIGHT && juzhen[i][index] != 0) {
				sum++;
			}
		}

		return sum;
	}

	/**
	 * 图的广度优先遍历
	 * 对外调用的方法
	 */
	public void BFS() {
	
		for (int i = 0; i < dingDian.length; i++) {
			if (!ifvisited[i]) {
				BFS(i);

			}
		}
		ifvisited=new boolean[size];
	}
	
	/**图的广度优先遍历
	 * @param i   遍历的起始顶点下标
	 */
	private void BFS(int i) {
		int u ,w;
		LinkedList<Integer> queue = new LinkedList<>();
		System.out.println("访问了" + i + "顶点");
		ifvisited[i]=true;
		queue.add(i);//第一次把v0加到队列
		while (!queue.isEmpty()) {
			u=(Integer)(queue.removeFirst()).intValue();
			w=getFirstNeigber(u);
			while (w!=-1) {
				if (!ifvisited[w]) {
					
				System.out.println("访问了" + w + "顶点");
				ifvisited[w]=true;
				queue.add(w);
			}
			w=getNextNeigber(u, w);
		}
		}
	}
	/**
	 * 图的深度优先遍历
	 * 对外调用的方法
	 */
	public void DFS() {
	
		for (int i = 0; i < dingDian.length; i++) {
			if (!ifvisited[i]) {
				System.out.println("访问了" + i + "顶点");
				DFS(i);

			}
		}
		ifvisited=new boolean[size];
	}

	/**
	 * 图的深度优先遍历
	 * 
	 * @param index
	 *            遍历的起始顶点下标
	 */
	public void DFS(int index) {
		ifvisited[index] = true;
		int w = getFirstNeigber(index);
		while (w != -1) {
			if (!ifvisited[w]) {
				System.out.println("访问了" + w + "顶点");
				DFS(w);
			}
			w = getNextNeigber(index, w);
		}

	}


	/**
	 * 获取某一顶点的临接顶点
	 * 
	 * @param index
	 */
	public int getFirstNeigber(int index) {
		for (int i = 0; i < size; i++) {
			if (juzhen[index][i] > 0 && juzhen[index][i] <Graph.MAX_WEIGHT) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 根据前一个邻接点的下标获取下一个邻接点
	 * 
	 * @param v
	 *            要找的顶点
	 * @param index
	 *            相对于那个邻接点去找下一个邻接点
	 * @return
	 */
	public int getNextNeigber(int v, int index) {
		for (int i = index + 1; i < size; i++) {
			if (juzhen[v][i] > 0 && juzhen[v][i] <Graph.MAX_WEIGHT) {
				
				return i;
			}
		}
		return -1;

	}

}
