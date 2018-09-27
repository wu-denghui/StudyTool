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
		// V	put(K key, V value)  ��ָ��ֵ���ӳ���е�ָ�������й�����
		// ��ָ��ֵ���ӳ���е�ָ�������й�����
		map.put(1, null);
		map.put(2, "aaa");
		map.put(3, "bbb");
		map.put(4, "ccc");
		System.out.println(map);
		// ��ָ��ӳ���е�����ӳ���ϵ���Ƶ���ӳ���С�
		map2.putAll(map);
		System.out.println(map2);
		//���ش�ӳ���еļ�-ֵӳ���ϵ����
		System.out.println(map.size());
		System.out.println("---------------------------");
		/*
		 * Map.Entry<K,V> ceilingEntry(K key)
		 * ����һ����-ֵӳ���ϵ��������ڵ��ڸ���������С����������������������ļ����򷵻� null��
		 * 
		 */

		Map.Entry<Integer, String> entry = map.ceilingEntry(3);
		System.out.println(entry);
		System.out.println("---------------------------");
		/*
		 * K ceilingKey(K key) ���ش��ڵ��ڸ���������С������������������ļ����򷵻� null��
		 */
		Integer i = map.ceilingKey(3);
		System.out.println(i);
		System.out.println("---------------------------");
		/*
		 * void clear() �Ӵ�ӳ�����Ƴ�����ӳ���ϵ�� Object clone() ���ش� TreeMap ʵ����ǳ������
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
		 * ���ضԴ�ӳ���еļ���������ıȽ����������ӳ��ʹ�ü�����Ȼ˳���򷵻� null��
		 */
		Comparator<Integer> mComparator = (Comparator<Integer>) map.comparator();
		System.out.println(mComparator);
		System.out.println("---------------------------");
		/*
		 * boolean containsKey(Object key) �����ӳ�����ָ������ӳ���ϵ���򷵻� true�� boolean
		 * containsValue(Object value) �����ӳ��Ϊָ��ֵӳ��һ�����������򷵻� true��
		 */
		System.out.println(map.containsKey(4));
		System.out.println(map.containsValue("bbb"));
		/*
		 * NavigableSet<K> descendingKeySet() ���ش�ӳ������������������ NavigableSet��ͼ�������ͼû�е����� 
		 * NavigableMap<K,V> descendingMap() ���ش�ӳ����������ӳ���ϵ��������ͼ�� �����ͼ�е�����
		 * NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, KtoKey, boolean toInclusive) 
		 * ���ش�ӳ��Ĳ�����ͼ������ķ�Χ�� fromKey �� toKey��
		 * NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)
		 * ���ش�ӳ��Ĳ�����ͼ��������ڣ�����ڣ���� inclusive Ϊ true��fromKey��
		 * NavigableMap<K,V> headMap(K toKey, boolean inclusive) 
		 * ���ش�ӳ��Ĳ�����ͼ�����С�ڣ�����ڣ���� inclusiveΪ true��toKey��
		 * NavigableMap<K,V> headMap(K toKey, boolean inclusive) ���ش�ӳ��Ĳ�����ͼ�����С�ڣ�����ڣ���� inclusive Ϊ true��toKey��
		 * SortedMap<K,V> subMap(K fromKey, K toKey) ���ش�ӳ��Ĳ�����ͼ�����ֵ�ķ�Χ�� fromKey���������� toKey������������
		 * SortedMap<K,V>	 headMap(K toKey) ���ش�ӳ��Ĳ�����ͼ�����ֵ�ϸ�С�� toKey��
		 * SortedMap<K,V> tailMap(K fromKey)    ���ش�ӳ��Ĳ�����ͼ��������ڵ��� fromKey��
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
		 * Map.Entry<K,V> firstEntry() ����һ�����ӳ���е���С�������ļ�-ֵӳ���ϵ�����ӳ��Ϊ�գ��򷵻� null��
		 * Map.Entry<K,V> lastEntry() �������ӳ���е����������ļ�-ֵӳ���ϵ�����ӳ��Ϊ�գ��򷵻� null��
		 * Map.Entry<K,V> floorEntry(K key) ����һ����-ֵӳ���ϵ������С�ڵ��ڸ�������������������������������ļ����򷵻� null�� 
		 * Map.Entry<K,V> higherEntry(K key) ����һ����-ֵӳ���ϵ�������ϸ���ڸ���������С����������������������ļ����򷵻� null��
		 * Map.Entry<K,V> lowerEntry(K key) ����һ����-ֵӳ���ϵ�������ϸ�С�ڸ�������������������������������ļ����򷵻� null�� 
		 * Map.Entry<K,V> pollFirstEntry() �Ƴ����������ӳ���е���С�������ļ�-ֵӳ���ϵ�����ӳ��Ϊ�գ��򷵻� null��
		 * Map.Entry<K,V> pollLastEntry()  �Ƴ����������ӳ���е����������ļ�-ֵӳ���ϵ�����ӳ��Ϊ�գ��򷵻�null��

		 */
		System.out.println("---------------------------");
		/*
		 * K	lastKey()  ����ӳ���е�ǰ���һ������ߣ�����
		 * K	firstKey()  ���ش�ӳ���е�ǰ��һ������ͣ�����
         * K	floorKey(K key) ����С�ڵ��ڸ���������������������������ļ����򷵻� null��
         * K	higherKey(K key) �����ϸ���ڸ���������С������������������ļ����򷵻� null��
         * K	lowerKey(K key) �����ϸ�С�ڸ���������������������������ļ����򷵻� null��
         * V	get(Object key) ����ָ������ӳ���ֵ��������ڸü����ԣ���ӳ�䲻�����κ�ӳ���ϵ���򷵻� null��
         * V	remove(Object key)  ����� TreeMap �д��ڸü���ӳ���ϵ������ɾ����
		 */
		System.out.println("---------------------------");
		/*
		 * Set<Map.Entry<K,V>>	entrySet()  ���ش�ӳ���а�����ӳ���ϵ�� Set ��ͼ��
		 * Set<K>	keySet() 
		 * Collection<V>	values()  ���ش�ӳ�������ֵ�� Collection ��ͼ��
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
	      
	      
	      
	      
	      
	      
	      
	      
	      
		
		

