package StructDemo;

//  通过迪杰斯特拉算法实现图的最短路径计算
public class GraphDemo3 {
	private final static int MAXVEX = 9;
	private final static int INFINITY = 65535;
	static int shortPathTable[] = new int[MAXVEX]; // 用于保存起始点到各点的最短路径的权值
	int pathmatirx[] = new int[MAXVEX]; // 用于存储最短路径下标的数组

	public static void main(String[] args) {
		Graph graph = new Graph(9);
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		graph.setDingDian(a);
		int[][] an = {
				{ 0, 10, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 11, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT,
						Graph.MAX_WEIGHT },
				{ 10, 0, 18, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 16, Graph.MAX_WEIGHT, 12 },
				{ Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 0, 22, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT,
						Graph.MAX_WEIGHT, 8 },
				{ Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 22, 0, 20, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 16, 21 },
				{ Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 20, 0, 26, Graph.MAX_WEIGHT, 7,
						Graph.MAX_WEIGHT },
				{ 11, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 26, 0, 17, Graph.MAX_WEIGHT,
						Graph.MAX_WEIGHT },
				{ Graph.MAX_WEIGHT, 16, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 17, 0, 19,
						Graph.MAX_WEIGHT },
				{ Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, 16, 7, Graph.MAX_WEIGHT, 19, 0,
						Graph.MAX_WEIGHT },
				{ Graph.MAX_WEIGHT, 12, 8, 21, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT, Graph.MAX_WEIGHT,
						0 } };
		graph.setJuzhen(an);
		GraphDemo3 graphDemo3 = new GraphDemo3();
		graphDemo3.ShortestPath_Dijkstra(graph);
		
	}

	/*
	 * 
	 * int v,w,k,min; int final[MAXVEX]; //final[w] = 1表示求得顶点v0至vw的最短路径
	 * for(v=0;v<G.numVertexes;v++){ //初始化数据 final[v] = 0; //全部顶点初始化为未知最短路径状态
	 * (*D)[v] = G.matirx[v0][v]; //将与v0点有连线的顶点加上权值 (*P)[v] = 0; //初始化路径数组为0 }
	 * (*D)[v0] = 0; //v0至v0的路径为0 final[v0] = 1; //v0至v0不需要求路径
	 * //开始主循环，每次求得v0到某个v顶点的最短路径 for(v = 1;v<G.numVertexes;v++){ min = INFINITY;
	 * //当前所知离v0顶点的最近距离 for(w = 0;w<G.numVertexes;w++){ //寻找离v0最近的顶点
	 * if(!final[w]&&(*D)[w]<min){ k = w; min = (*D)[w]; //w顶点离v0顶点更近 } }
	 * final[k] = 1; //将目前找到的最近的顶点置为1 for(w = 0;w<G.numVertexes;w++){
	 * //修正当前最短路径与距离 //如果经过v顶点的路径比现在这条路径的长度短的话
	 * if(!final[w]&&(min+G.matirx[k][w]<(*D)[w])){ //说明找到了更短的路径，修改D[w]和P[w]
	 * (*D)[w] = min + G.matirx[k][w];//修改当前路径长度 (*P)[w] = k; } } }
	 */
	// 迪杰斯特拉算法实现图的最短路径
	public void ShortestPath_Dijkstra(Graph graph) {
		int mini;
		int k = 0;// 记录下标
		boolean[] ifGetPath = new boolean[MAXVEX]; // 到某结点最短路径是否找到
		for (int i = 0; i < graph.size; i++) {
			shortPathTable[i] = graph.juzhen[0][i]; // 获取一行权值数组
		}
		shortPathTable[0] = 0;
		ifGetPath[0] = true;
		for (int v = 1; v < graph.size; v++) {
			mini = INFINITY;
			for (int w = 0; w < graph.size; w++) {
				// 获得此行权值数组的最小值
				if (!ifGetPath[w] && shortPathTable[w] < mini) {
			
					mini = shortPathTable[w];
				}
			}
			ifGetPath[k] = true;
			for (int j = 0; j < graph.size; j++) {
				if (!ifGetPath[j] && (mini + graph.juzhen[k][j] < shortPathTable[j])) {
					shortPathTable[j] = mini + graph.juzhen[k][j];
				}
			}

		}
		for (int i = 0; i < shortPathTable.length; i++) {
			System.out.println(shortPathTable[i]);
		}
	}
}
