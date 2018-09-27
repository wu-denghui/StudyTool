package StructDemo;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		TreeMap<Integer, String> map2 = new TreeMap<>();
		// V	put(K key, V value)  将指定值与此映射中的指定键进行关联。
		// 将指定值与此映射中的指定键进行关联。
		map.put(1, null);
		map.put(2, "aaa");
		map.put(3, "bbb");
		map.put(4, "ccc");
		System.out.println(map);
		// 将指定映射中的所有映射关系复制到此映射中。
		map2.putAll(map);
		System.out.println(map2);
		//返回此映射中的键-值映射关系数。
		System.out.println(map.size());
		System.out.println("---------------------------");
		/*
		 * Map.Entry<K,V> ceilingEntry(K key)
		 * 返回一个键-值映射关系，它与大于等于给定键的最小键关联；如果不存在这样的键，则返回 null。
		 * 
		 */

		Map.Entry<Integer, String> entry = map.ceilingEntry(3);
		System.out.println(entry);
		System.out.println("---------------------------");
		/*
		 * K ceilingKey(K key) 返回大于等于给定键的最小键；如果不存在这样的键，则返回 null。
		 */
		Integer i = map.ceilingKey(3);
		System.out.println(i);
		System.out.println("---------------------------");
		/*
		 * void clear() 从此映射中移除所有映射关系。 Object clone() 返回此 TreeMap 实例的浅表副本。
		 */
		TreeMap<Integer, String> map3;
		map3 = (TreeMap<Integer, String>) map.clone();
		Object map4;
		map4 = map.clone();
		System.out.println(map3);
		System.out.println(map4);
		System.out.println("---------------------------");
		/*
		 * Comparator<? super K> comparator()
		 * 返回对此映射中的键进行排序的比较器；如果此映射使用键的自然顺序，则返回 null。
		 */
		Comparator<Integer> mComparator = (Comparator<Integer>) map.comparator();
		System.out.println(mComparator);
		System.out.println("---------------------------");
		/*
		 * boolean containsKey(Object key) 如果此映射包含指定键的映射关系，则返回 true。 boolean
		 * containsValue(Object value) 如果此映射为指定值映射一个或多个键，则返回 true。
		 */
		System.out.println(map.containsKey(4));
		System.out.println(map.containsValue("bbb"));
		/*
		 * NavigableSet<K> descendingKeySet() 返回此映射中所包含键的逆序 NavigableSet视图。这个视图没有迭代器 
		 * NavigableMap<K,V> descendingMap() 返回此映射中所包含映射关系的逆序视图。 这个视图有迭代器
		 * NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, KtoKey, boolean toInclusive) 
		 * 返回此映射的部分视图，其键的范围从 fromKey 到 toKey。
		 * NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)
		 * 返回此映射的部分视图，其键大于（或等于，如果 inclusive 为 true）fromKey。
		 * NavigableMap<K,V> headMap(K toKey, boolean inclusive) 
		 * 返回此映射的部分视图，其键小于（或等于，如果 inclusive为 true）toKey。
		 * NavigableMap<K,V> headMap(K toKey, boolean inclusive) 返回此映射的部分视图，其键小于（或等于，如果 inclusive 为 true）toKey。
		 * SortedMap<K,V> subMap(K fromKey, K toKey) 返回此映射的部分视图，其键值的范围从 fromKey（包括）到 toKey（不包括）。
		 * SortedMap<K,V>	 headMap(K toKey) 返回此映射的部分视图，其键值严格小于 toKey。
		 * SortedMap<K,V> tailMap(K fromKey)    返回此映射的部分视图，其键大于等于 fromKey。
		 */
		NavigableMap<Integer, String> an = map.descendingMap();
		System.out.println(an);
		NavigableSet<Integer> ans = map.navigableKeySet();
		Iterator<Integer> inte = ans.iterator();
		while (inte.hasNext()) {
			System.out.println(inte.next());
		}
		System.out.println("---------------------------");
		/*
		 * Map.Entry<K,V> firstEntry() 返回一个与此映射中的最小键关联的键-值映射关系；如果映射为空，则返回 null。
		 * Map.Entry<K,V> lastEntry() 返回与此映射中的最大键关联的键-值映射关系；如果映射为空，则返回 null。
		 * Map.Entry<K,V> floorEntry(K key) 返回一个键-值映射关系，它与小于等于给定键的最大键关联；如果不存在这样的键，则返回 null。 
		 * Map.Entry<K,V> higherEntry(K key) 返回一个键-值映射关系，它与严格大于给定键的最小键关联；如果不存在这样的键，则返回 null。
		 * Map.Entry<K,V> lowerEntry(K key) 返回一个键-值映射关系，它与严格小于给定键的最大键关联；如果不存在这样的键，则返回 null。 
		 * Map.Entry<K,V> pollFirstEntry() 移除并返回与此映射中的最小键关联的键-值映射关系；如果映射为空，则返回 null。
		 * Map.Entry<K,V> pollLastEntry()  移除并返回与此映射中的最大键关联的键-值映射关系；如果映射为空，则返回null。

		 */
		System.out.println("---------------------------");
		/*
		 * K	lastKey()  返回映射中当前最后一个（最高）键。
		 * K	firstKey()  返回此映射中当前第一个（最低）键。
         * K	floorKey(K key) 返回小于等于给定键的最大键；如果不存在这样的键，则返回 null。
         * K	higherKey(K key) 返回严格大于给定键的最小键；如果不存在这样的键，则返回 null。
         * K	lowerKey(K key) 返回严格小于给定键的最大键；如果不存在这样的键，则返回 null。
         * V	get(Object key) 返回指定键所映射的值，如果对于该键而言，此映射不包含任何映射关系，则返回 null。
         * V	remove(Object key)  如果此 TreeMap 中存在该键的映射关系，则将其删除。
		 */
		System.out.println("---------------------------");
		/*
		 * Set<Map.Entry<K,V>>	entrySet()  返回此映射中包含的映射关系的 Set 视图。
		 * Set<K>	keySet() 
		 * Collection<V>	values()  返回此映射包含的值的 Collection 视图。
        */
	     Set<Map.Entry<Integer,String>> l=map.entrySet();
	     Iterator iterator=l.iterator();
	      while (iterator.hasNext()) {
             System.out.println(iterator.next());			
	}
	      Set<Integer> ll=map.keySet();
      Iterator<Integer> iterator2=ll.iterator();
      while (iterator2.hasNext()) {
              System.out.println(iterator2.next());			
	}
      Collection<String> lll=map.values();
    Iterator<String> iterator3=lll.iterator();
	      while (iterator3.hasNext()) {
    	  System.out.println(iterator3.next());
	      }
		}
}
	      
	      
	      
	      
	      
	      
	      
	      
	      
		
		

