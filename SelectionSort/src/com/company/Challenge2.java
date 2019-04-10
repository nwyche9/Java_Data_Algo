package com.company;

public class Challenge2 {
    public static void main(String[] args){
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };//changed implementation from iterative to recursive

        /*for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];

            int i;

            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }

            intArray[i] = newElement;
        }*/
        sort(intArray, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
    public static void sort(int[] input, int numItems){//recursive method here
        if(numItems < 2){
            return;
        }
        sort(input, numItems-1);

            int newElement = input[numItems-1];

            int i;

            for (i = numItems-1; i > 0 && input[i - 1] > newElement; i--) {
                input[i] = input[i - 1];
            }

            input[i] = newElement;
            System.out.println("Results of call = "+ numItems);
            for(i =0; i <input.length; i++){
                System.out.println(input[i]);

            }
            System.out.println("");
            System.out.println("-------------------------");
        }
    }



