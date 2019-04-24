public class Main {


    public static void main(String[] args){

        Heap heap = new Heap(10);

        //O(logn) because of fixing heap possibility
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        //printing heap
        heap.printHeap();

        //testing delete method O(nlogn) without index, O(n) worst case with index because fixing heap
        //heap.delete(5);
        //heap.printHeap();

        //printing peek method O(n)
        //System.out.println(heap.peek());

        //testing heap sort method O(nlogn) worst case in place
        //heap.sort();
        //heap.printHeap();
    }
}
