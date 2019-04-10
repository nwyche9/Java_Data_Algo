public class Queue_Array {

    private Employee[] queue;
    private int front;
    private int back;

    public Queue_Array(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee){
        if (size() == queue.length - 1) { //only if the array needs to be resized, queue is circular so it uses all empty spots at the begining of the array
           //if array does need to be resized then last elems in queue moved to front while new elems put at end, resetting queue to front
            int numItems = size();
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            queue = newArray;

            front = 0;
            back = numItems;
        }

        queue[back] = employee;
        if(back< queue.length - 1) {//making sure back is less than queue length-1, so no need to resize array
            back++;
        }
        else{
            back = 0;
        }
    }
    public Employee remove() throws NoSuchFieldException {
        //need to check if queue is empty or not, then when employee removed front is incremented by 1, removing from the front
        if (size() ==0){
            throw new NoSuchFieldException();
        }
        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if(size() == 0){
            front = 0;
            back = 0;
        }
        else if(front == queue.length) {
            front = 0; //setting front back to 0
        }
        return employee;
    }

    public Employee peek() throws NoSuchFieldException{
        if(size() == 0){
            throw new NoSuchFieldException();
        }

        return queue[front];
    }

    public int size() {
        if(front <= back){
            //we know queue has not wrapped around
            return back - front;
        }
        else{
            return back - front + queue.length; //in case front larger than back, add length of queue to get correct number
        }
    }

    public void printQueue(){//need to check if back is less to front, if so split array into 2 parts then print those 2 parts as 1
        if(front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        else{
            for(int i = front; i < queue.length; i++){
                System.out.println(queue[i]);
                }
            for(int i = 0; i < back; i++){
                System.out.println(queue[i]);
            }

        }
    }

}
