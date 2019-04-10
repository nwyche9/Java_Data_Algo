package com.company;

public class Merge{
    public static void main(String[] args) {
        int[] intArray = {81, 55, 95, 48, 92, 88, 73, 58, 66, 90, 80};

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {//base case to avoid infinte calls
            return;
        }

        int mid = (start + end) / 2; //splitting the array at the mid point
        //recursion part here
        mergeSort(input, start, mid); //end index is mid starting cause starting from left side
        mergeSort(input, mid, end); //end index is the actual end cause starting from right side
        merge(input, start, mid, end); //final merge call to bring the arrays back together
    }

    public static void merge(int[] input, int start, int mid, int end) {//merge function to put the sorted arrays together
        if (input[mid - 1] <= input[mid]) {//input[mid -1] = the last element in the left partition, input[mid]=first element in the right sode
            return; //if elements are less than or equal then the array is sorted and merging is done as each side is already sorted
        }
        int i = start;//pointer for left partition
        int j = mid;//pointer for right partition
        int tempIndex = 0;

        int[] temp = new int[end - start];//creating temporary array
        while(i < mid && j < end){//condition to leave after traversing the entire array
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];//putting the smaller value into temparray
        }
        //handling the remaining elements, if elements in left partition copy to temparray, if in right can do nothing, would be needless work
        System.arraycopy(input, i, input, start + tempIndex, mid - i);//copying elements to the input array letting them jump over other elements
        System.arraycopy(temp, 0, input, start, tempIndex);//copying elements in the temp array
    }

}
