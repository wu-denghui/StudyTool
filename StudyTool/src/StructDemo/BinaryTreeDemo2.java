package StructDemo;

import java.util.ArrayList;

public class BinaryTreeDemo2 {
	private TreeNode  root = null;
	public static void main(String[] args) {
		BinaryTreeDemo2 eBinary=new BinaryTreeDemo2();
		ArrayList<String> list=new ArrayList<>();
		String[] str = new String[]{ "A", "B", "D", "#", "#", "E", "#", "#", "C", "#", "F", "#", "#" };
		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);
		}
		System.out.println(list.size());
		eBinary.creatTree(list);
        eBinary.preOrder(eBinary.root);
	} 
	public void preOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			System.out.println("preOrder data:"+node.getData());
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}

	public void creatTree(ArrayList<String> list) {

	}


	class TreeNode {
		private String data;
		public TreeNode leftChild;
		public TreeNode rightChild;

		public TreeNode getLeftChild() {
			return leftChild;
		}


		/**
		 * @param data
		 */
		public TreeNode(String data) {
			super();
			this.data = data;
		}


		public TreeNode( String data, TreeNode leftChild, TreeNode rightChild) {
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		public void setLeftChild(TreeNode leftChild) {
			this.leftChild = leftChild;
		}

		public TreeNode getRightChild() {
			return rightChild;
		}

		public void setRightChild(TreeNode rightChild) {
			this.rightChild = rightChild;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}


		

	}
}