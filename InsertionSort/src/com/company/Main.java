package com.company;

public class Main {

    public static void main(String[] args) {

	int[] intArray = {20,35,-15,7,55,1,-22};

	for(int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++){
	    int newElement = intArray[firstUnsortedIndex];

	    int i;

	    for(i = firstUnsortedIndex; i > 0 && intArray[i-1]> newElement;i--){//looping as long as i = 0 and keep going as long as i-1 position greater than the new element, decrementing becasue moving from right to left
	        intArray[i] = intArray[i-1];//shifting/swapping first index with next index, O(n^2) at base implementation, shell sort is the next lvl
        }
        intArray[i] = newElement;//when dropping out of the loop, making the smallest value to the front
    }
	for(int i = 0; i < intArray.length; i++){//print the values of the array
	    System.out.println(intArray[i]);
    }
    }
}
