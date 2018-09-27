package StructDemo;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Hashtable<Integer, String> map = new Hashtable<>();
		map.put(1, "wdh");
		map.put(1, "wdh");
		map.put(5, "wdh");
		map.put(5, "ys");
		map.put(3, "c");
		map.put(4, "sss");
		System.out.println(map);
		Hashtable<Integer, String> map2 = new Hashtable<>();
		map2.put(1, "wdh");
		map2.put(2, "ys");
		map2.put(3, "wh");
		map2.put(4, "dx");
		Hashtable<Integer, String> map3;
		map3 = (Hashtable<Integer, String>) map.clone();
		System.out.println(map.containsKey(3));
		System.out.println(map.containsValue("ys"));
		System.out.println(map.contains("ys"));
		System.out.println("-------------------");
		/*
		 * 通过Enumeration遍历Hashtable的value 效率高!
		 */
		Enumeration<String> en = map.elements();
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		System.out.println("-------------------");
		/*
		 * 通过entry set遍历Hashtable 效率高!
		 */
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-------------------");
		System.out.println(map.equals(map2));
		System.out.println(map.equals(map3));
		System.out.println("-------------------");
		String ste = map.get(4);
		System.out.println(ste);
		System.out.println("-------------------");
		/*
		 * 通过Enumeration遍历Hashtable的key 效率高!
		 */
		Enumeration<Integer> eun = map.keys();
		while (eun.hasMoreElements()) {
			System.out.println(eun.nextElement());
		}
		System.out.println("-------------------");
		/*
		 *返回此映射中包含的键的 Set 视图。 
		 */
         Set<Integer> set2=map.keySet();
         Iterator<Integer> sttt=set2.iterator();
         System.out.println(set2);
         /*
 		 *返回此映射中包含的值的 Set 视图。 
 		 */
         Collection<String> collection=map.values();
         System.out.println(collection);
         Iterator<String> itt=collection.iterator();
         
         /*
  		 *返回此 Hashtable 对象的字符串表示形式，其形式为 ASCII 字符 ", " （逗号加空格）分隔开的、括在括号中的一组条目。
  		 */
         String string=map.toString();
         System.out.println(string);
	}

}
