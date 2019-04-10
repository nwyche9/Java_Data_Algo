package com.company;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(iterativeFact(3));
        System.out.println(recursiveFact(3));
    }

    //calculating factorial in iterative, less space & faster
    public static int iterativeFact(int num) {
        if (num == 0) {
            return 1;
        }
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    //n! = n *(n-1)! calling the function again with new param = recursively more space and more time
    //returns in the reverse order of num
    //creates call stack then pops off when function value is found
    public static int recursiveFact(int num){
        if(num ==0){
            return 1;//needs break condition/base case to stop the function from running 4ever
        }
       return num * recursiveFact(num-1);//calling function again with new param
    }
}