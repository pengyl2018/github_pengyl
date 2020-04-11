import java.util.*;
public class HeapSort {
	public static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void heapSort(int[] a){
		buildMaxHeap(a); // ����󶥶�
		for(int i=a.length-1;i>0;i--){
			swap(a,i,0);   // ����Ԫ�غ͵�ǰ���һ��Ԫ�ؽ���λ��
			adjustDown(a,0,i); // �Ӷ�Ԫ�ؿ�ʼ���½��е���
		}
	}
	
	public static void buildMaxHeap(int[] a){
		int len = a.length;
		// ����󶥶�ʱ����һ��Ҫ�Ƚϵ�Ԫ���±�������(���鳤��-1)/2
		for(int i=(len-1)/2;i>=0;i--){  
			adjustDown(a,i,len);
		}
	}
	
	public static void adjustDown(int[] a,int i,int len){
		int temp = a[i];
		// �±�Ϊi��Ԫ�ص����Һ��ӽڵ�ֱ���2*i+1��2*i+2
		for(int j=2*i+1;j<len;j=2*j+1){
			if(a[j+1]>a[j]&&j+1<len)
				j++;
			if(a[j]<=temp){
				break;
			}else{
				a[i] = a[j];
				i = j;
			}
		}
		a[i] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {3,12,76,23,17,8,54};
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}
}
