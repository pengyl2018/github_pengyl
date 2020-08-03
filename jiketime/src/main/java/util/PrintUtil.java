package util;

public class PrintUtil {
	public static void printArrays(int[][] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[0].length; j++) {
				System.out.print(arrays[i][j] + ",");
			}
			System.out.println();
		}
	}
}
