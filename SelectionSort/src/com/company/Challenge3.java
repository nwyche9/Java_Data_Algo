package com.company;

public class Challenge3 {
    public static void main(String[] args) {
        String[] stringsArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        // do radix sort
        radixSort(stringsArray, 26, 5);

        for (int i = 0; i < stringsArray.length; i++) {
            System.out.println(stringsArray[i]);
        }
    }

    private static void radixSort(String[] stringsArray, int radix, int width) {
        for(int i = width-1; i >= 0; i--){
            radixSingleSort(stringsArray, i, radix);
        }
    }

    private static void radixSingleSort(String[] input, int position, int radix) {
        int numLetters = input.length;

        int[] array = new int[radix];

        for(String value: input){
            array[getLetter(position, value)]++;
        }
        for(int j = 1; j < radix; j++){
            array[j] += array[j-1];//this is adding all the values in the indices to adjust count array
        }
        String[] temp = new String[numLetters]; //temp array to hold sorted values
        for(int tempIndex = numLetters- 1; tempIndex >= 0; tempIndex--){
            temp[--array[getLetter(position, input[tempIndex])]] = input[tempIndex];//taking next index value and assign it to tempIndex, tempIndex starts at right and moves to left
        }
        for(int tempIndex = 0; tempIndex < numLetters; tempIndex++){
            input[tempIndex] = temp[tempIndex];//used to put values back into the og array
        }
    }

    private static int getLetter(int position, String value) {
        return value.charAt(position) - 'a';
    }
}
