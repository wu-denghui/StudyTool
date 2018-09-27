package StructDemo;

import java.util.LinkedList;

public class GraphDemo {
	// ���ڽӾ��󴴽�һ����Ȩ����ͼ
	// ��ȡ���ȱ���ͼ
	//����ķ�㷨 ����С������
	//��ȡ���Ⱥ����
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

// ͼ��ʵ����
class Graph {
	public int size;
	public int[] dingDian;// ��������
	public int[][] juzhen;// ����
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
//����ķ�㷨 ����С������
	
	public void prim(){
		int [] lowcost = new int[size];//��С���۶���Ȩֵ������,Ϊ0��ʾ�Ѿ���ȡ��СȨֵ
		int [] adjvex = new int[size];//�Ŷ���Ȩֵ
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
			System.out.println("���㣺"+adjvex[minId]+"Ȩֵ��"+min);
			sum+=min;
			lowcost[minId] = 0;
			for(int j = 1;j<size;j++){
				if(lowcost[j]!=0&&juzhen[minId][j]<lowcost[j]){
					lowcost[j] = juzhen[minId][j];
					adjvex[j] = minId;
				}
			}
		}
		System.out.println("��С������Ȩֵ��:"+sum);
	}
	/*
	 * 
   public void prim(){
	   int[] lowcost=new int[size];//Ѱ����СȨֵ�ıȽ�����
	   int[] ajvex=new int[size];//��¼�ҵ�Ȩֵ�Ķ���
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
			System.out.println("���㣺"+ajvex[minId]+"Ȩֵ��"+min);
			sum+=min;
			lowcost[minId] = 0;
			for (int k = 1; k < size; k++) {
				if (juzhen[minId][k]<lowcost[k]) {
					lowcost[k]=juzhen[minId][k];
				}
			}
	}
	   System.out.println("��С������Ȩֵ��:"+sum);
	   
   }
	 */
	// ���ĳһ����ĳ���
	public int getOuterDegree(int index) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			if (juzhen[index][i] != Graph.MAX_WEIGHT && juzhen[index][i] != 0) {
				sum++;
			}
		}

		return sum;
	}

	// ���ĳһ��������
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
	 * ͼ�Ĺ�����ȱ���
	 * ������õķ���
	 */
	public void BFS() {
	
		for (int i = 0; i < dingDian.length; i++) {
			if (!ifvisited[i]) {
				BFS(i);

			}
		}
		ifvisited=new boolean[size];
	}
	
	/**ͼ�Ĺ�����ȱ���
	 * @param i   ��������ʼ�����±�
	 */
	private void BFS(int i) {
		int u ,w;
		LinkedList<Integer> queue = new LinkedList<>();
		System.out.println("������" + i + "����");
		ifvisited[i]=true;
		queue.add(i);//��һ�ΰ�v0�ӵ�����
		while (!queue.isEmpty()) {
			u=(Integer)(queue.removeFirst()).intValue();
			w=getFirstNeigber(u);
			while (w!=-1) {
				if (!ifvisited[w]) {
					
				System.out.println("������" + w + "����");
				ifvisited[w]=true;
				queue.add(w);
			}
			w=getNextNeigber(u, w);
		}
		}
	}
	/**
	 * ͼ��������ȱ���
	 * ������õķ���
	 */
	public void DFS() {
	
		for (int i = 0; i < dingDian.length; i++) {
			if (!ifvisited[i]) {
				System.out.println("������" + i + "����");
				DFS(i);

			}
		}
		ifvisited=new boolean[size];
	}

	/**
	 * ͼ��������ȱ���
	 * 
	 * @param index
	 *            ��������ʼ�����±�
	 */
	public void DFS(int index) {
		ifvisited[index] = true;
		int w = getFirstNeigber(index);
		while (w != -1) {
			if (!ifvisited[w]) {
				System.out.println("������" + w + "����");
				DFS(w);
			}
			w = getNextNeigber(index, w);
		}

	}


	/**
	 * ��ȡĳһ������ٽӶ���
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
	 * ����ǰһ���ڽӵ���±��ȡ��һ���ڽӵ�
	 * 
	 * @param v
	 *            Ҫ�ҵĶ���
	 * @param index
	 *            ������Ǹ��ڽӵ�ȥ����һ���ڽӵ�
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
