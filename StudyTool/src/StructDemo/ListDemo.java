package StructDemo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

public class ListDemo {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList=new ArrayList<>();
		arrayList.add(2);
		arrayList.add(4);
		arrayList.add(4);
		arrayList.add(null);
		arrayList.add(null);
		arrayList.set(4, 8);
		System.out.println(arrayList);
		LinkedList<Integer> linkedList= new LinkedList<>();
		linkedList.add(2);
		linkedList.add(4);
		linkedList.add(4);
		linkedList.add(null);
		linkedList.add(null);
		System.out.println(linkedList);
		Vector<Integer> vector2 = new Vector<>();
		vector2.add(2);
		vector2.add(2);
		vector2.add(4);
		vector2.add(4);
		vector2.add(null);
		vector2.add(null);
		System.out.println(vector2);
		Stack<Integer> stack = new Stack<Integer>();
		/*
		 * ִ��pushʱ(������Ԫ������ջ��)����ͨ����Ԫ��׷�ӵ������ĩβ�С�
		 * ִ��peekʱ(����ȡ��ջ��Ԫ�أ���ִ��ɾ��)���Ƿ�������ĩβ��Ԫ�ء�
		 * ִ��popʱ(����ȡ��ջ��Ԫ�أ�������Ԫ�ش�ջ��ɾ��)����ȡ������ĩβ��Ԫ�أ�Ȼ�󽫸�Ԫ�ش�������ɾ����
		 */
		stack.push(2);
		stack.push(2);
		stack.push(4);
		stack.push(null);
		stack.add(null);
		System.out.println(stack);
		Deque<Integer> da = new ArrayDeque<Integer>();
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(1);
		vector.add(2);
		vector.add(3);
		vector.add(null);
		System.out.println("-------------------");
		System.out.println(vector.get(3));
		System.out.println(vector.toString());
		System.out.println("-------------------");
		Object[] object = vector.toArray();
		Integer[] annn = (Integer[]) vector.toArray(new Integer[vector.size()]);
		for (int i = 0; i < annn.length; i++) {
			System.out.println(annn[i]);
		}
		System.out.println("-------------------");
		ListIterator<Integer> cc = vector.listIterator(vector.size());
		while (cc.hasPrevious()) {
			System.out.println(cc.previous());
		}
		System.out.println("-------------------");
		Enumeration<Integer> xx = vector.elements();
		while (xx.hasMoreElements()) {
			System.out.println((Integer) xx.nextElement());
		}
	}
}