public class Stack {
    //last in first out, can only work with last element in the data structure, good with linked lists constant time
    // using an array, not the best only good if number of elems is known and wont change
    public static void main(String[] args){

        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("Tony", "Stark", 002));
        stack.push(new Employee("Medican", "Bias", 003));
        stack.push(new Employee("Offensive","Bias", 004));
        stack.push(new Employee("Thor","Odinson", 005));
        stack.push(new Employee("First","end", 999));

        //stack.printStack();
        System.out.println("Popped " + stack.pop());
        System.out.println(stack.peek());




    }
}
