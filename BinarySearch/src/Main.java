public class Main {

    public static void main(String[] args){

        int[] intArray = {-22, -15, 1, 7, 20, 35, 55};
        System.out.println(iterBinarySearch(intArray, 35));//showing output for iterative
        //System.out.println(recurBinarySearch(intArray, 35));//showing output for recursive
    }

    public static int iterBinarySearch(int[] input, int value){//array must be sorted to work, iterative preform slightly better less overhead

        int start = 0;
        int end = input.length;

        while(start < end){//if start == end then searched entire array
            int midpoint = (start + end) /2; //midpoint
            //System.out.println("midpoint = " + midpoint); //just to see midpoint in each iteration
            if(input[midpoint] == value){
                return midpoint;
            }
            else if(input[midpoint] < value){//searching right part of sorted array
                start = midpoint +1;//start becomes the next element over
            }
            else{
                end = midpoint;//last element becomes midpoint to search left part of the array
            }
        }
        return -1;
    }

    /*public static int recurBinarySearch(int[] input, int value){//recursive form of binary search
        return recurBinarySearch(input, 0, input.length, value);
    }

    public static int recurBinarySearch(int[] input, int start, int end, int value){//actual work
        //breaking condition
        if(start >= end){
            return -1;
        }
        int midpoint = (start + end)/2;
        System.out.println("midpoint = " + midpoint);

        if(input[midpoint] ==value){
            return midpoint;
        }
        else if(input[midpoint] < value){//searching right half of array
            return recurBinarySearch(input, midpoint + 1, end, value);
        }
        else{//searching left half of array
            return recurBinarySearch(input, start, midpoint, value);
        }
    }*/


}
