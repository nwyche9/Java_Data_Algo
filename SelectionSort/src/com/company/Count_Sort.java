package com.company;

public class Count_Sort {
//counting the number of element occurances within an array, creates another array equal to input array

    public static void main(String[] args){
        int[] intArray = {81, 55, 95, 48, 92, 88, 73, 58, 66, 90, 80};
        countingSort(intArray, 48, 95);

        for(int i =0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }

   public static void countingSort(int[] input, int min, int max){
        int[] countArray = new int[max - min + 1];

        for(int i =0; i < input.length; i++){
            countArray[input[i] - min]++;// counting phase incrementing the value in count array by 1
        }

        int j = 0;
        for(int i = min; i <= max; i++){//j index used to write to input array, j traverses the count array
            while(countArray[i - min] > 0){
                input[j++] = i;
                countArray[i - min]--;
            }

        }
   }
}
