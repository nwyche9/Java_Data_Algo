public class Heap {
    //need array

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    //check if heap is full
    public boolean isFull() {
        return size == heap.length;
    }

    //check if heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //method to get parent
    public int getParent(int index) {
        return (index - 1) / 2; //equation to get parent, only works if complete binary tree, will be rounded down automatically
    }

    //method to get child
    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);//if left is true + 1, else + 2
    }


    //insert method, always put at end of the array
    public void insert(int value) {
        //throwing exception if array is full
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full fam");
        }

        heap[size] = value;//putting elem @ first avail spot

        fixHeapAbove(size);
        size++;

    }

    private void fixHeapAbove(int index) {//fixing heap on insert
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {//while we have not hit root yet
            //comparing elem to parent
            heap[index] = heap[getParent(index)];//assigning parent to where new value is
            index = getParent(index);//moving elems down
        }
        heap[index] = newValue;//assigning new value to where parent was

    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int child2Swap;

        //compare root to children to swap if root less than any children
        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {//index has a left child
                if (rightChild > lastHeapIndex) {//index has a right child
                    child2Swap = leftChild;
                } else {
                    child2Swap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);//if heap left greater than heap right make left 1 to swap
                }

                //only need to swap if index less than child
                if (heap[index] < heap[child2Swap]) {//actually swapping here
                    int tmp = heap[index];
                    heap[index] = heap[child2Swap];
                    heap[child2Swap] = tmp;
                } else {
                    break;
                }
                index = child2Swap;
            } else {
                break;
            }

        }
    }

    public int delete(int index) {//taking index so no need for a search, only really want to delete root
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty fam");
        }
        int parent = getParent(index);//gotten parent of index 2 be deleted
        int deletedValue = heap[index];//deleted value

        heap[index] = heap[size - 1];//right most value replaces what was in index because that was deleted

        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    //peek method to look at the root
    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("heap is empty fam");
        }
        return heap[0];
    }

    public void sort(){//sorting a heap with last index becoming the root and excluding where the previous root is
        int lastHeapIndex = size -1;
        for(int i = 0; i < lastHeapIndex; i++){
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = tmp;

            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

}
