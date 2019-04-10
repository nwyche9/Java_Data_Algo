package com.company;

public class Radix_Sort {//all inputs have to have same radix and width, og not stable, need to be made stable

    public static void main(String[] args){
        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(radixArray, 10, 4);

        for(int i = 0; i < radixArray.length; i++){
            System.out.println(radixArray[i]);
        }
    }

    public static void radixSort(int[] input, int radix, int width){
        for(int i =0; i <width;i++){//will start at least sig digit, right most num, and go from right to left
            radixSingleSort(input, i, radix);
        }

    }
    public static void radixSingleSort(int[] input, int position, int radix){
        int numItems = input.length;

        int[] countArray = new int[radix];//create new array that will hold all values of radix

        for(int value: input){//for every value in input array count how many values have enough digits at that position
            countArray[getDigit(position, value, radix)]++;//will return the digit

        }
        for(int j = 1; j < radix; j++){
            countArray[j] += countArray[j-1];//this is adding all the values in the indices to adjust count array
        }
        int[] temp = new int[numItems]; //temp array to hold sorted values
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--){
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];//taking next index value and assign it to tempIndex, tempIndex starts at right and moves to left
        }
        for(int tempIndex = 0; tempIndex< numItems; tempIndex++){
            input[tempIndex] = temp[tempIndex];//used to put values back into the og array
        }
    }
    public static int getDigit(int position, int value, int radix){
        return value/ (int) Math.pow(radix, position) % radix;//taking value and dividing by the input(radix) by the current position in countArray then return remainder of the value
    }
}
