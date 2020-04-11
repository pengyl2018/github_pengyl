import java.util.*;
public class ShellSort {
	public static void shellSort(int[] a){
		int j,temp,len=a.length;
		for(int dk=len/2;dk>=1;dk/=2){
			for(int i=dk;i<len;i++){
				if(a[i-dk]>a[i]){
					temp = a[i];
					for(j=i;j>=dk&&a[j-dk]>temp;j-=dk){
						a[j] = a[j-dk];
					}
					a[j] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] a = {3,12,76,23,17,8,54};
		shellSort(a);
		System.out.println(Arrays.toString(a));
	}
}
