package StructDemo;

//  ͨ���Ͻ�˹�����㷨ʵ��ͼ�����·������
public class GraphDemo3 {
	private final static int MAXVEX = 9;
	private final static int INFINITY = 65535;
	static int shortPathTable[] = new int[MAXVEX]; // ���ڱ�����ʼ�㵽��������·����Ȩֵ
	int pathmatirx[] = new int[MAXVEX]; // ���ڴ洢���·���±������

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
	 * int v,w,k,min; int final[MAXVEX]; //final[w] = 1��ʾ��ö���v0��vw�����·��
	 * for(v=0;v<G.numVertexes;v++){ //��ʼ������ final[v] = 0; //ȫ�������ʼ��Ϊδ֪���·��״̬
	 * (*D)[v] = G.matirx[v0][v]; //����v0�������ߵĶ������Ȩֵ (*P)[v] = 0; //��ʼ��·������Ϊ0 }
	 * (*D)[v0] = 0; //v0��v0��·��Ϊ0 final[v0] = 1; //v0��v0����Ҫ��·��
	 * //��ʼ��ѭ����ÿ�����v0��ĳ��v��������·�� for(v = 1;v<G.numVertexes;v++){ min = INFINITY;
	 * //��ǰ��֪��v0������������ for(w = 0;w<G.numVertexes;w++){ //Ѱ����v0����Ķ���
	 * if(!final[w]&&(*D)[w]<min){ k = w; min = (*D)[w]; //w������v0������� } }
	 * final[k] = 1; //��Ŀǰ�ҵ�������Ķ�����Ϊ1 for(w = 0;w<G.numVertexes;w++){
	 * //������ǰ���·������� //�������v�����·������������·���ĳ��ȶ̵Ļ�
	 * if(!final[w]&&(min+G.matirx[k][w]<(*D)[w])){ //˵���ҵ��˸��̵�·�����޸�D[w]��P[w]
	 * (*D)[w] = min + G.matirx[k][w];//�޸ĵ�ǰ·������ (*P)[w] = k; } } }
	 */
	// �Ͻ�˹�����㷨ʵ��ͼ�����·��
	public void ShortestPath_Dijkstra(Graph graph) {
		int mini;
		int k = 0;// ��¼�±�
		boolean[] ifGetPath = new boolean[MAXVEX]; // ��ĳ������·���Ƿ��ҵ�
		for (int i = 0; i < graph.size; i++) {
			shortPathTable[i] = graph.juzhen[0][i]; // ��ȡһ��Ȩֵ����
		}
		shortPathTable[0] = 0;
		ifGetPath[0] = true;
		for (int v = 1; v < graph.size; v++) {
			mini = INFINITY;
			for (int w = 0; w < graph.size; w++) {
				// ��ô���Ȩֵ�������Сֵ
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
