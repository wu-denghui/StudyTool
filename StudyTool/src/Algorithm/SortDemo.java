package Algorithm;

import java.util.ArrayList;
import java.util.List;


//排序总结
public class SortDemo {
	public static void main(String[] args) {
		SortDemo sortDemo = new SortDemo();
		int[] an = { 90, 3, 2, 67, 4,9,19,44, 9, 87, 65, 11, 9, 2, 8 };
		try {
			sortDemo.binaryInsertSort(an);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sortDemo.printArrary(an);
	}

	// 选择排序 从小到大
	public void selectSort(int[] an) {
		for (int i = 0; i < an.length; i++) {
			for (int j = i + 1; j < an.length; j++) {
				if (an[i] > an[j]) {
					int temp = an[i];
					an[i] = an[j];
					an[j] = temp;
				}
			}
		}

	}

	// 冒泡排序   从小到大
	public void bubbleSort(int[] an) {
		for (int i = 0; i < an.length - 1; i++) {
			for (int j = 0; j < an.length - 1 - i; j++) {
				if (an[j] > an[j + 1]) {
					int temp = an[j];
					an[j] = an[j + 1];
					an[j + 1] = temp;
				}
			}

		}

	}

	// 插入排序     从小到大
	public void insertSort(int[] an) {
		for (int i = 1; i < an.length; i++) {
			int temp = an[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				//找到第一个比temp大的元素
				if (temp < an[j]) {
					an[j + 1] = an[j];
				} else {
					break;
				}
			}
			an[j + 1] = temp;
		}

	}

	// 二分插入排序  从小到大
	public void binaryInsertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int left = 0;
			int right = i - 1;
			int mid = 0;
			while (left <=right) {
				mid = (left + right) / 2;
				if (temp < a[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
					
				}
			}
			for (int j = i - 1; j >= left; j--) {
				a[j + 1] = a[j];
			}
			if (mid != i) {
				a[left] = temp;
			}
		}
	}

	// 希尔排序  
	public void shellsort(int[] an) {
		int n = an.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				for (int j = i - gap; j >= 0 && an[j] > an[j + gap]; j -= gap) {
					int temp = an[j];
					an[j] = an[j + gap];
					an[j + gap] = temp;
				}
			}
		}
	}

	// 希尔排序  每次分成二组分k次 直到每组只有一个数
	public void shellSort(int[] an) {
		int k = an.length / 2;
		while (true) {
			for (int i = 0; i < k; i++) {
				for (int j = i; j + k < an.length; j += k) {
					for (int n = i; n + k < an.length; n += k) {
						if (an[n] > an[n + k]) {
							int temp = an[n];
							an[n] = an[n + k];
							an[n + k] = temp;
						}
					}
				}
			}
			if (k == 1) {
				break;
			}
			k = k / 2;
		}
	}

	// 快速排序 O(nlogn)    无额外空间
	public void quickSort(int[] an) {
		if (an == null || an.length <= 1) {
			return;
		} else {
			Sort(an, 0, an.length - 1);
		}

	}

	public void Sort(int[] an, int left, int right) {
		if (left <right) {
			int mid = getmid(an, left, right);
			Sort(an, 0, mid - 1);
			Sort(an, mid + 1, right);
		}
	}

	// 找到分割点
	private int getmid(int[] an, int left, int right) {
		int temp = an[left];
		while (left < right) {
			while (left < right && an[right] >= temp) {
				right--;
			}
			an[left] = an[right];
			while (left < right && an[left] <= temp) {
				left++;
			}
			an[right] = an[left];
		}
		an[left] = temp;
		return left;
	}

	// 归并排序  O(nlogn)  需要额外空间
	public void mergeSort(int[] an) {
		if (an == null || an.length <= 1) {
			return;
		} else {
			mSort(an, 0, an.length - 1);
		}

	}

	private void mSort(int[] an, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mSort(an, left, mid);
			mSort(an, mid + 1, right);
			merge(an, left, mid, right);
		}
	}

	private void merge(int[] an, int left, int mid, int right) {
		int[] un = new int[an.length];
		int rbiao = mid + 1;
		int zbiao = left;
		int ybiao = left;
		int tmp = left;
		while (zbiao <= mid && rbiao <= right) {
			if (an[zbiao] <= an[rbiao]) {
				un[ybiao++] = an[zbiao++];
			} else {
				un[ybiao++] = an[rbiao++];
			}
		}
		while (zbiao <= mid) {
			un[ybiao++] = an[zbiao++];

		}
		while (rbiao <= right) {
			un[ybiao++] = an[rbiao++];
		}
		while (tmp <= right) {
			an[tmp] = un[tmp++];
		}
	}

	// �基数排序
	public void basicSort(int[] an) throws Exception {
		int max = 0;
		for (int i = 0; i < an.length; i++) {
			if (an[i] > max) {
				max = an[i];
			}
		}
		int count = 0;
		while (max > 0) {
			max = max / 10;
			count++;
		}
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> q = new ArrayList<Integer>();
			queue.add(q);
		}
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < an.length; j++) {
				int x = an[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				ArrayList qq = queue.get(x);
				qq.add(an[j]);
				queue.set(x, qq);
			}
			int count2 = 0;
			for (int j = 0; j < 10; j++) {
				while (queue.get(j).size() > 0) {
					ArrayList<Integer> q2 = queue.get(j);
					an[count2] = q2.get(0);
					q2.remove(0);
					count2++;
				}
			}
		}
	}

	// 堆排序
	public void heapSort(int[] an) {
		if (an == null || an.length <= 1) {
			return;
		}
		int half = (an.length - 1) / 2;
		for (int i = half; i >= 0; i--) {
			creatHeap(an, an.length, i);
		}
		for (int i = an.length - 1; i >= 1; i--) {
			int temp = an[0];
			an[0] = an[i];
			creatHeap(an, i, 0);
		}
	}
	private void creatHeap(int[] an, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		if (left < heapSize && an[left] > an[index]) {
			largest = left;
		}
		if (right < heapSize && an[right] > an[largest]) {
			largest = right;
		}
		if (index != largest) {
			exchangeElements(an, index, largest);
			creatHeap(an, heapSize, largest);
		}
	}
	public void exchangeElements(int[] an, int index1, int index2) {
		int temp = an[index1];
		an[index1] = an[index2];
		an[index2] = temp;
	}

	// 打印数组
	public void printArrary(int[] an) {
		for (int i = 0; i < an.length; i++) {
			System.out.print(an[i]+" ");
		}
	}

}
