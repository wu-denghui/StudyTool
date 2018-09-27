package StructDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.Attributes.Name;

public class SetDemo {
	public static void main(String[] args) {
		Set<String> set2 = new LinkedHashSet<String>();
		Set<Integer> set = new HashSet<Integer>();
		set.add(3);
		set.add(2);
		set.add(1);
		set.add(null);
		System.out.println(set);
		System.out.println("-------------------linkedhashset");
		set2.add("1");
		set2.add("2");
		set2.add(null);
		set2.add(null);
		System.out.println(set2);
		Object[] inn = set2.toArray();
		for (int i = 0; i < inn.length; i++) {
			System.out.println(inn[i]);
		}
		System.out.println("-------------------hashset");
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());

		}
		System.out.println("-------------------");
		String str = "4,456,543,765 ";
		String[] aa = str.split(",");
		for (int i = 0; i < aa.length; i++) {
			if (set2.contains(aa[i]))
				System.out.println("aa[i]:" + aa[i] + "已经在内了");
			else {

				set2.add(aa[i]);
			}

		}
		System.out.println("-------------------");

		Iterator<String> iter2 = set2.iterator();
		while (iter2.hasNext()) {
			System.out.print(iter2.next() + "      ");

		}
		System.out.println("\n");
		System.out.println("-------------------");
		Set<Integer> set3 = new TreeSet<Integer>();
		
		
		
		TreeSet<Student> ts = new TreeSet<Student>(); // 创建一个TreeSet的集合
		ts.add(new Student("lisi02", 22)); // 往集合添加元素
		ts.add(new Student("lisi007", 20));
		ts.add(new Student("lisi09", 19));
		ts.add(new Student("lisi08", 19));
		Iterator it = ts.iterator(); // 初始化迭代器，遍历集合中的所有元素

		while (it.hasNext()) {
			Student stu = (Student) it.next();
			System.out.println(stu.getName() + "..." + stu.getAge());
		}
	}
}
//自然排序
class Student implements Comparable {
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object obj) { // 第二：复写CompareTo方法
		// return 0;

		if (!(obj instanceof Student)) // 第三：判断对象是否是特定类的一个实例

			throw new RuntimeException("不是学生对象");

		Student s = (Student) obj;

		// 第四：当前对象的年龄与插入对象的年龄进行比较，当前年龄大于插入对象的年龄时，返回1，

		if (this.age > s.age) // 判断当前对象年龄是否大于传入的对象年龄

			return 1;
		// 如果当前年龄等于传入对象的年龄，则比较姓名是否相同{
		if (this.age == s.age) {
			return this.name.compareTo(s.name);
		}

		return -1;

	}

}
