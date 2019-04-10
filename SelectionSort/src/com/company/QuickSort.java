package com.company;

public class QuickSort {
    //divide and conquer algorithm, memory efficient recursive algorithm O(nlogn) worst cased O(n^2) unstable algo, in place algo
    public static void main(String[] args){
        int[] intArray = {81, 55, 95, 48, 92, 88, 73, 58, 66, 90, 80};
        quickSort(intArray, 0, intArray.length);

        for(int i =0; i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }
    public static void quickSort(int[] input, int start, int end){
        if(end - start < 2){ //this means the array is one element
            return;
        }

        int pivtoIndex = partition(input, start, end); //returning position of pivot after array is partitioned, puts everything smaller to left and bigger to right
        quickSort(input, start, pivtoIndex);//partitioning the left subarray
        quickSort(input, pivtoIndex+1, end);//partitioning the right subarray
    }
    public static int partition(int[] input, int start, int end){
        //Using the first element of array as pivot
        int pivot =input[start];
        int i = start;//traversing from left to right
        int j = end;//traversing from right to left
        while(i<j){//make traversal stop when i and j cross each other

            while(i<j && input[--j] >= pivot);//just a loop to keep decrementing j as algo sorts
            if(i<j){// checking if i and j have crossed paths, moving j into i position
                input[i] = input[j];//input j finds element less than pivot and time to switch them
            }
            while(i<j&&input[++i] <= pivot);//just a loop to keep incrementing i as algo sorts
            if(i<j){//just checking if i and j have crossed paths
                input[j] = input[i];//input i finds element greater than pivot and time to switch them
            }

        }
        input[j] = pivot;
        return j;// returning index where pivot element is located
    }
}
