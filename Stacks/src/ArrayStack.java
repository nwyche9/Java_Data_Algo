import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top; //when top = 0 stack is empty

    public ArrayStack(int capacity){
        stack = new Employee[capacity];
    }

    public void push(Employee employee){
        if(top == stack.length){
            //resize array, linear time
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }
    public Employee pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Employee employee = stack[--top];// taking top - 1 and using that as the index as that would be the top of the stack
        stack[top] = null;//taking the elem at the top out of the stack
        return employee;

    }
    public Employee peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top - 1];//top points to next available position, minus one to find that top elem
    }
    public int size(){
        return top;
    }
    public boolean isEmpty(){
        return top == 0;
    }
    public void printStack(){
        for(int i = top - 1; i >= 0; i--){
            System.out.println(stack[i]);//printing from top to bottom
        }
    }


}
