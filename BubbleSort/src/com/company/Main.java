package com.company;

//O(n^2)
public class Main {

    public static void main(String[] args) {
        //this implementation is optimized to store where the sorted partition of the array is

        int[] intArray = {20, 35, -15, 7, 55, 1, 22};

        //implementing from left to right, array is unsorted and last index of array is last valid index of array
        //needs to be greater than zero, and decrementing after each loop
        for(int lastUnsortedIndex = intArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for(int i = 0; i < lastUnsortedIndex; i++){//lastUnsortedIndex makes it so only working in unsorted part
                //comparing i to i+1 to see if it needs to be swapped
                if(intArray[i] > intArray[i+1]){
                    swap(intArray, i, i+1);//using the swap method made on line 27(in this file)
                }
            }
        }
        //printing the output
        for(int i =0; i < intArray.length; i++){
                System.out.println(intArray[i]);
    }
    }
    //the swap method
    public static void swap(int[] array, int i, int j){
        if(i == j) {
            return;
        }
        //this makes og value become last value as new value comes in
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
