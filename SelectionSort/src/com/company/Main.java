package com.company;

public class Main {

    public static void main(String[] args) {

        int[] intArray = {81,55,95,48,92,88,73,58,66,90,80};

        for(int lastUnsortedIndex = intArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){//this splits array into sorted and unsorted parts

            int largest = 0;//first largest value is at first element

            for(int i = 1; i <=lastUnsortedIndex; i++){//looking to see if next element is larger or smaller than largest element
                if(intArray[i] > intArray[largest]){//if next element is larger than largest change largest to new element
                    largest = i;
                }

            }
            swap(intArray, largest, lastUnsortedIndex);
        }


        for(int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }
    public static void swap(int[] intArray, int i, int j){
        int temporary = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temporary;
    }
}
