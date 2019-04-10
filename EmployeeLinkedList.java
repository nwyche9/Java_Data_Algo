public class EmployeeLinkedList {
    //what makes a linked list
    private EmployeeNode head;
    private int sizes;

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        sizes++;
    }

    public int getSize(){
        return sizes;
    }

    public boolean isEmpty(){
        return head == null;
    }
    //method to print the list
    public void printList(){
        EmployeeNode current = head;
        System.out.print("HEAD ->");
        while(current != null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    //method to remove first node
    public EmployeeNode removeFromFront(){
        if(isEmpty()){
            return null;
        }
        EmployeeNode removedNode = head;
        head = head.getNext();
        sizes--;
        return removedNode;
    }

}
