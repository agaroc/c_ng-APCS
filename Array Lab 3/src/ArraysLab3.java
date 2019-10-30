/*
 * Caleb Ng
 * 10/30/19
 * 4th Period
 * Arraylab questions
 */
import java.util.Arrays;

public class ArraysLab3 {

	public static void main(String[] args) {
		int [] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int [] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int appendNum = 200;
		int removeIdx = 5;
		int [] sumArr = sum(a1,a2);
		int [] appendArr = append(a1,appendNum);
		int [] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		rotateRight(a1);
	}
	public static int[] sum(int[] arr1, int[] arr2) {
		int length = arr1.length;
		int [] sumArray = new int[length];
		for(int i = 0; i < length; i++) {
			sumArray[i] = arr1[i] + arr2[i];
		}
		return sumArray;
	}
	public static int[] append(int[] arr, int idx) {
		int[] appendArray = new int[arr.length+1];
		for(int i = 0; i < arr.length;i++) {
			appendArray[i] = arr[i];
		}
		appendArray[arr.length] = idx;
		return appendArray;
	}
	public static int[] remove(int[] arr, int idx) {
		int[] removeArr = new int[arr.length-1];
		for(int i = 0, j= 0; i < arr.length;i++) {
			if(i != idx) {
				removeArr[j++] = arr[i];
			}
		}
		
		return removeArr;
	}
	public static int sumEven(int[] arr) {
		int sum = 0;
		for(int currentNumber: arr) {
			if(currentNumber % 2 ==0) {
				sum += currentNumber;
			}
		}
		return sum;
	}
	public static void rotateRight(int[] arr) {
		int [] rightArr = new int[arr.length+1];
		for(int i = 0; i < arr.length; i++) {
			rightArr[i+1] = arr[i];
		}
		System.out.println(Arrays.toString(rightArr));
	}
}
