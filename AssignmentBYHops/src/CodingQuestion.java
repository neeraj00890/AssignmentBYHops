

import java.util.Arrays;

public class CodingQuestion {

	private static int[] array;
	private  static int lentgh;

	public static void main(String... args) {

		performPatternManupulation();
		evaluationPIEquation();
		
		int arr[]=new int[]{1,2,3,4,223,5,21,3};
		sort(arr);
		System.out.println("Third Question----->");
		Arrays.stream(arr).forEach((number)->{
			System.out.print(number+" ");
		});
		
		evaluateMathmaticalEqFromNumberN(10);  //n=1,2,3,4.......

	}
	
	/*
	 * 
	 * @Output :1.0E10
	 * 
	 */
	
	private static void evaluateMathmaticalEqFromNumberN(int n) {
		System.out.println();
		System.out.println("Fourth Question----->");
		System.out.println(Math.pow(n, n));
	}

	
	/*
	 * @Output : 1 2 3 3 4 5 21 223 
	 */
	private static void sort(int[] arry) {
		if (arry == null || arry.length == 0) {
			return;
		}
		array = arry;
		lentgh = arry.length;
		quicksort(0, lentgh - 1);
	}

	private static  void quicksort(int low, int high) {
		int i = low, j = high;
		int pivot = array[low + (high - low) / 2];

		while (i <= j) {

			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}

		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private static void exchange(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/*
	 * @Output
	 * 
	 * 1+1=2 2*2=4 4+3=7 7*4=28 28+5=33 33*6=198 198+7=205 205*8=1640 1640+9=1649
	 */
	private static void performPatternManupulation() {

		System.out.println("First Question----->");

		boolean ismulOp = false;
		Long firstStart = 1L;
		Long scndStart = 1L;
		Long nextnumber = 1L;

		while (true) {
			Long res = 0l;
			if (ismulOp) {
				res = firstStart * scndStart;
				ismulOp = !ismulOp;
				if (res > 10000) {
					break;
				}
				System.out.println("" + firstStart + "*" + scndStart + "=" + (res));
			} else {
				res = firstStart + scndStart;
				ismulOp = !ismulOp;
				if (res > 10000) {
					break;
				}
				System.out.println("" + firstStart + "+" + scndStart + "=" + (res));
				// addd
			}
			nextnumber++;
			firstStart = res;
			scndStart = nextnumber;

		}

		System.out.println();
	}

	/*
	 * @Output 4.442882938158366
	 */
	private static void evaluationPIEquation() {
		System.out.println("Second Question----->");
		double sqrSumOfPi = Math.pow(Math.PI, 2) + Math.pow(Math.PI, 2);
		System.out.println(Math.pow(sqrSumOfPi, 0.5));
		System.out.println();

	}

}
