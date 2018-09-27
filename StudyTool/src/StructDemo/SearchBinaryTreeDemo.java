package StructDemo;

import java.util.LinkedHashMap;


//                                    用数组方法创建一个查找二叉树
//                                     二叉树的搜索查询
//                                      二叉树的删除、添加结点操作

public class SearchBinaryTreeDemo {
	static TreeNode root;
	static int index = 0;
	static LinkedHashMap<Integer, TreeNode> map = new LinkedHashMap<>();// 用来存放遍历结点
	static LinkedHashMap<Integer, TreeNode> map2 = new LinkedHashMap<>();// 用来存放遍历结点

	public static void main(String[] args) {
		SearchBinaryTreeDemo searchBinaryTreeDemo = new SearchBinaryTreeDemo();
		int[] an = { 50, 30, 20, 15, 35, 49,60,25,34,27 };
		for (int i = 0; i < an.length; i++) {
			searchBinaryTreeDemo.put(an[i]);
			System.out.println(index);
		}
		searchBinaryTreeDemo.midOrder(root);
		System.out.println("-----------使用map根据index查找结点---------");
		searchBinaryTreeDemo.midOrder2(root);
		searchBinaryTreeDemo.midOrder3(root);
		System.out.println(map.size());
		System.out.println(map2.size());
		TreeNode aNode = searchBinaryTreeDemo.getNode(2);
		TreeNode aNode2 = searchBinaryTreeDemo.getNode2(50);
		System.out.println(aNode.toString());
		System.out.println(aNode2.toString());
		System.out.println("--------使用search根据data查找结点------------");
		TreeNode aNode3=searchBinaryTreeDemo.search(27);
		System.out.println(aNode3.toString());
		System.out.println("--------------------");
		searchBinaryTreeDemo.deleteNode(60);
		searchBinaryTreeDemo.midOrder(root);
		
	}
	//二叉树的删除操作

	// 根据data查找并返回结点
	public TreeNode search(int data) {
		TreeNode node = root;
		if (node == null) {
			return null;
		} else {
			while (node != null && node.data != data) {
				if (data > node.data) {
					node = node.rChild;
				} else {
					node = node.lChild;
				}
			}
		}
		return node;
	}
	
	//删除结点的对外方法
	public void deleteNode(int data) {
		TreeNode node=search(data);
		if (node==null) {
			System.out.println("未找到此结点");
		}else {
			delete(node);
		}
		
	}
	// 删除结点的实现方法
	private void delete(TreeNode node) {
		TreeNode parent=node.parent;
		//被删除结点无左右结点
		if (node.lChild==null&&node.rChild==null) {
			if (parent.lChild==node) {
				parent.lChild=null;
			}else {
				parent.rChild=null;
			}
			//被删除结点有右结点
		}else if (node.lChild==null&&node.rChild!=null) {
			if (parent.lChild==node) {
				parent.lChild=node.rChild;
			}else {
				parent.rChild=node.rChild;
			}
			//被删除结点有左结点
		} else if (node.rChild==null&&node.lChild!=null) {
			if (parent.lChild==node) {
				parent.lChild=node.lChild;
			}else {
				parent.rChild=node.lChild;
			}
			//既有右孩子也有左孩子
			
		}else {
			TreeNode next=getNext(node);
			delete(next);
			node.data=next.data;
			
		}
		
	}
	
      //找到后继结点
	public  TreeNode getNext(TreeNode next) {
		TreeNode node=null;
		if (next==null) {
			return null;
		}else {
			if (next.rChild!=null) {
				//找到最小关键字结点
				return getMin(next.rChild);
			}else {
				TreeNode parent=next.parent;
				while(parent!=null&&parent.data<next.data){
					parent=parent.parent;
				}
				parent=parent.parent;
				parent=node;
			}
		}
		return node;
		
	}
	//找到最小关键字结点
	private TreeNode getMin(TreeNode node) {
		if (node==null) {
			return null;
		}else {
			while (node.lChild!=null) {
				node=node.lChild;
			}
		}
	return node;
}
		

	// 根据data大小添加结点，创建一颗查找二叉树
	public TreeNode put(int data) {
		TreeNode node = null;
		TreeNode parent = null;
		if (root == null) {
			node = new TreeNode(index, data);
			root = node;
			return node;
		} else {
			node = root;
			index++;
		}
		while (node != null) {
			parent = node;
			if (data > node.data) {
				node = node.rChild;
			} else if (data < node.data) {
				node = node.lChild;
			} else {
				return node;
			}
		}
		node = new TreeNode(index, data);
		if (data < parent.data) {
			parent.lChild = node;
		} else {
			parent.rChild = node;
		}
		node.parent = parent;
		return node;
	}

	
	
	// 中序遍历这个树
	public void midOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			midOrder(node.lChild);
			System.out.println("midOrder data:" + node.getData() + "     index:" + node.getIndex());
			midOrder(node.rChild);
		}

	}
    //
	//
	//
	// 中序遍历结点并放进一个map集合 key为index
	public LinkedHashMap<Integer, TreeNode> midOrder2(TreeNode node) {
		map.put(node.index, node);
		if (node.lChild != null) {
			midOrder2(node.lChild);
		}
		if (node.rChild != null) {
			midOrder2(node.rChild);
		}
		return map;
	}

	// 根据index返回结点
	public TreeNode getNode(int index) {
		TreeNode rTreeNode = map.get(index);
		return rTreeNode;
	}
	// 中序遍历结点并放进一个map集合 key为data

	public LinkedHashMap<Integer, TreeNode> midOrder3(TreeNode node) {
		map2.put(node.data, node);
		if (node.lChild != null) {
			midOrder3(node.lChild);
		}
		if (node.rChild != null) {
			midOrder3(node.rChild);
		}
		return map2;
	}

	// 根据data返回结点
	public TreeNode getNode2(int data) {
		TreeNode rTreeNode = map2.get(data);
		return rTreeNode;
	}

	class TreeNode {
		private int index;
		private int data;
		private TreeNode parent;
		private TreeNode lChild;
		private TreeNode rChild;

		public TreeNode(int index, int data) {
			super();
			this.index = index;
			this.data = data;
		}

		public TreeNode(int index, int data, TreeNode parent, TreeNode lChild, TreeNode rChild) {
			super();
			this.index = index;
			this.data = data;
			this.parent = parent;
			this.lChild = lChild;
			this.rChild = rChild;
		}

		public TreeNode(int index, int data, TreeNode lChild, TreeNode rChild) {
			super();
			this.index = index;
			this.data = data;
			this.lChild = lChild;
			this.rChild = rChild;
		}

		public TreeNode(int index, int data, TreeNode parent) {
			super();
			this.index = index;
			this.data = data;
			this.parent = parent;
		}

		int getIndex() {
			return index;
		}

		void setIndex(int index) {
			this.index = index;
		}

		int getData() {
			return data;
		}

		void setData(int data) {
			this.data = data;
		}

		TreeNode getParent() {
			return parent;
		}

		void setParent(TreeNode parent) {
			this.parent = parent;
		}

		TreeNode getlChild() {
			return lChild;
		}

		void setlChild(TreeNode lChild) {
			this.lChild = lChild;
		}

		TreeNode getrChild() {
			return rChild;
		}

		void setrChild(TreeNode rChild) {
			this.rChild = rChild;
		}

		@Override
		public String toString() {
			return "TreeNode index=" + index + ", data=" + data;
		}
	}
}
