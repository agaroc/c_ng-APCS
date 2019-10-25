import java.util.Arrays;

public class ArraysLab3 {

	public static void main(String[] args) {
		int [] arr1 = {1,2,3,4,6,7,7};
		int [] arr2 = {1,2,3};
		String stringArr = Arrays.toString(append(arr1, 4));
		System.out.println(stringArr);
		
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
		for(int i = 0; i < arr.length; i++) {
			if(i != idx) {
				removeArr[i] = arr[i];
			}
		}
		return removeArr;
	}
	//public static int[]
}
/*
Create a class named ArraysLab3 that contains 6 static methods (main plus the 5 methods defined below).

4) Write a method sumEven that accepts an array of integers arr and returns an integer containing the sum of the elements at the even indices of arr.  (That means elements at indices 0,2,4,6,8.)  You can assume arr has at least one element.

public static int sumEven(int[] arr) {


5) Write a method rotateRight that accepts an array of integers arr and does not return a value.  The rotateRight method moves each element of arr one index to the right (element 0 goes to element 1, element 1 goes to element 2, …, element n-1 goes to element 0).  You can assume arr has at least one element.

public static void rotateRight(int[] arr) {

6) Write a method main that will 

Contain
integer arrays a1, a2, sumArr, appendArr, removeArr
int variables appendNum, removeIdx, sumOfEvens
Carry out the following actions
Declare array a1 containing the values (5, 10, 15, 20, 25, 30, 35, 40) and array a2 containing the values (7, 14, 21, 28, 35, 42, 49, 56)
Form sumArr by calling the sum method with a1 and a2 as inputs
Declare int appendNum and set it to 200.
Form appendArr by calling the append method with a1 and appendNum as inputs
Declare int removeIdx and set it to 5.
Form removeArr by calling remove with a2 and removeIdx
Form sumOfEvens by calling sumEven with appendArr as the input
Call rotateRight with a1 as the input
On their own lines print out (use Arrays.toString to transform arrays into a printable strings) :
sumArr
appendArr
removeArr
sumOfEvens (an int you don’t need Arrays.toString)
a1
 
*/