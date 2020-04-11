import java.util.*;
public class BubbleSort{
	public static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void bubbleSort(int[] a){
		int len = a.length;
		for(int j=len-1;j>0;j--){
			for(int i=0;i<j;i++){
				if(a[i]>a[i+1]){
					swap(a,i,i+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {3,12,76,23,17,8,54};
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}
}
