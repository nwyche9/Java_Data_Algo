import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args){

        int[] intArray = {53, 46, 83, 67, 95, 92, 43};

        bucketSort(intArray);

        for(int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }
    }
    public static void bucketSort(int[] input){//bucket sort algo
        List<Integer>[] buckets = new List[10];//intialization

        for(int i = 0; i < buckets.length; i++){//creating arraylist for each bucket
            buckets[i] = new ArrayList<Integer>();//can use this with anything that uses lists
        }

        //scattering the value
        for(int i = 0; i < input.length; i++){//traversing input array now
            buckets[hash(input[i])].add(input[i]);//doing the scaterring here, taking hashed num and adding to arraylist
        }

        for(List bucket : buckets){//sorting the buckets here using .sort method, uses merge sort
            Collections.sort(bucket);
        }

        int j = 0;//keeps track of input array, i tracks bucket array
        for(int i = 0; i < buckets.length; i++){//gathering step and putting back in array, traversing bucket array here
            for(int value: buckets[i]){//traversing arraylist
                input[j++] = value;//copying values to arraylist
            }
        }

    }
    //need a hashing function, mod by length of array to not get outofbounds exception and possibly reduce collisions
    private static int hash(int value){
        return value/(int) 10 % 10;//taking the first num of value to decide which bucket to use
        //return Math.abs(value % 10);
    }
}
